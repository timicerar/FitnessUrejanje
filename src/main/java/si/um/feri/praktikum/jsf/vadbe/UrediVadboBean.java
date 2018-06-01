package si.um.feri.praktikum.jsf.vadbe;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.UploadedFile;
import si.um.feri.praktikum.ejb.EJBVadba;
import si.um.feri.praktikum.ejb.EJBZnacka;
import si.um.feri.praktikum.vao.Vadba;
import si.um.feri.praktikum.vao.Znacka;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagedBean(name = "urediVadboBean")
@SessionScoped
public class UrediVadboBean {

    @EJB
    private EJBVadba ejbVadba;
    @EJB
    private EJBZnacka ejbZnacka;

    @Getter
    @Setter
    private String znacke = "";
    @Getter
    @Setter
    private UploadedFile file;
    @Getter
    @Setter
    private List<Znacka> listZnack = new ArrayList<>();
    @Getter
    @Setter
    private Vadba izbranaVadba = new Vadba();
    @Getter
    private int idIzbraneVadbe;

    public void setIdIzbraneVadbe(int idIzbraneVadbe) {
        this.idIzbraneVadbe = idIzbraneVadbe;
        izbranaVadba = ejbVadba.vadbaById(idIzbraneVadbe);
        listZnack = ejbZnacka.znackeZaVadbo(idIzbraneVadbe);

        for (int i = 0; i < listZnack.size(); i++) {
            if (i == 0)
                znacke = "#" + listZnack.get(i).getNaziv() + " ";
            else
                znacke = znacke + "#" + listZnack.get(i).getNaziv() + " ";
        }
    }

    public void urediVadbo(int idVadba) {
        Vadba v = ejbVadba.vadbaById(idVadba);
        boolean napaka = false;
        List<String> tempListZnack = new ArrayList<>();

        Pattern patt = Pattern.compile("(#\\w+)\\b");
        Matcher match = patt.matcher(znacke);

        while (match.find()) {
            tempListZnack.add(match.group(1).substring(1).toLowerCase());
        }

        List<String> originalneZnacke = new ArrayList<>();

        for (Znacka trenutnaZnacka : listZnack) {
            originalneZnacke.add(trenutnaZnacka.getNaziv());
        }

        if (!v.getNaziv().equals(izbranaVadba.getNaziv()) || !v.getOpis().equals(izbranaVadba.getOpis()) ||
                !v.getVideo().equals(izbranaVadba.getVideo()) || v.getTipVadbe() != izbranaVadba.getTipVadbe() ||
                file.getSize() > 0 || !tempListZnack.containsAll(originalneZnacke)) {

            napaka = preveriNaziv(v, napaka);
            napaka = preveriVideo(v, napaka);
            napaka = preveriSliko(napaka);
            preveriZnacke(tempListZnack, originalneZnacke);

            if (!napaka) {
                ejbVadba.mergeVadba(izbranaVadba);
                info();
            }
        } else {
            warnUrejanje();
        }
    }

    private void preveriZnacke(List<String> tempListZnack, List<String> originalneZnacke) {
        if (!tempListZnack.containsAll(originalneZnacke)) {
            for (Znacka trZnacka : listZnack) {
                ejbZnacka.removeZnacka(trZnacka.getIdZnacka());
            }

            for (String trZnacka : tempListZnack) {
                ejbZnacka.addZnacka(new Znacka(trZnacka, izbranaVadba));
            }
        }
    }

    private boolean preveriSliko(boolean napaka) {
        if (file.getSize() > 0) {
            if (file.getFileName().endsWith(".jpg") || file.getFileName().endsWith(".png")) {
                if (file.getSize() < 250000000) {
                    izbranaVadba.setSlika(file.getContents());
                    ejbVadba.mergeVadba(izbranaVadba);
                } else {
                    izbranaVadba = ejbVadba.vadbaById(idIzbraneVadbe);
                    napaka = true;
                    errorSlikaVelikost();
                }
            } else {
                izbranaVadba = ejbVadba.vadbaById(idIzbraneVadbe);
                napaka = true;
                errorSlikaKoncnica();
            }
        }
        return napaka;
    }

    private boolean preveriVideo(Vadba v, boolean napaka) {
        if (!v.getVideo().equals(izbranaVadba.getVideo())) {
            String regexURL = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

            if (izbranaVadba.getVideo().matches(regexURL)) {
                ejbVadba.mergeVadba(izbranaVadba);
            } else {
                izbranaVadba = ejbVadba.vadbaById(idIzbraneVadbe);
                napaka = true;
                warnVideo();
            }
        }
        return napaka;
    }

    private boolean preveriNaziv(Vadba v, boolean napaka) {
        if (!v.getNaziv().equals(izbranaVadba.getNaziv())) {
            if (ejbVadba.validateNazivVadbe(izbranaVadba.getNaziv())) {
                ejbVadba.mergeVadba(izbranaVadba);
            } else {
                izbranaVadba = ejbVadba.vadbaById(idIzbraneVadbe);
                napaka = true;
                warnNaziv();
            }
        }

        return napaka;
    }

    private void warnUrejanje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Niste spremenili nobenega podatka!"));
    }

    private void warnNaziv() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Vadba s takšnim nazivom že obstaja!"));
    }

    private void warnVideo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Vpišite ustrezen URL naslov za video!"));
    }

    private void errorSlikaKoncnica() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Uporabite lahko format .jpg ali .png!"));
    }

    private void errorSlikaVelikost() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Slika je prevelika!"));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Vadba je bila uspešno spremenjena."));
    }

}
