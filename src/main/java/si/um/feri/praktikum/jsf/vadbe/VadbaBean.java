package si.um.feri.praktikum.jsf.vadbe;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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
import javax.faces.event.PhaseId;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagedBean(name = "vadbaBean")
@SessionScoped
public class VadbaBean {

    @Getter
    @Setter
    private Vadba novaVadba = new Vadba();
    @Getter
    @Setter
    private String znacke;
    @Getter
    @Setter
    private UploadedFile file;
    @Setter
    private StreamedContent slika;
    @Getter
    @Setter
    private List<Znacka> znackeIzbraneVadbe = new ArrayList<>();
    @Getter
    @Setter
    private Vadba izbranaVadba = new Vadba();
    @Getter
    private int idIzbraneVadbe;

    public void setIdIzbraneVadbe(int idIzbraneVadbe) {
        this.idIzbraneVadbe = idIzbraneVadbe;
        izbranaVadba = ejbVadba.vadbaById(idIzbraneVadbe);
        znackeIzbraneVadbe = ejbZnacka.znackeZaVadbo(idIzbraneVadbe);
    }

    public StreamedContent getSlika() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            return new DefaultStreamedContent(new ByteArrayInputStream(izbranaVadba.getSlika()));
        }
    }

    @EJB
    private EJBVadba ejbVadba;
    @EJB
    private EJBZnacka ejbZnacka;

    public void dodajVadbo() {
        if (ejbVadba.validateNazivVadbe(novaVadba.getNaziv())) {
            String regexURL = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

            if (novaVadba.getVideo().matches(regexURL)) {
                if (file != null) {
                    if (file.getFileName().endsWith(".jpg") || file.getFileName().endsWith(".png")) {
                        if (file.getSize() < 250000000) {
                            novaVadba.setSlika(file.getContents());
                            ejbVadba.addVadba(novaVadba);

                            Pattern patt = Pattern.compile("(#\\w+)\\b");
                            Matcher match = patt.matcher(znacke);

                            while (match.find()) {
                                ejbZnacka.addZnacka(new Znacka(match.group(1).substring(1).toLowerCase(), novaVadba));
                            }

                            novaVadba = new Vadba();
                            znacke = "";
                            info();
                        } else {
                            errorSlikaVelikost();
                        }
                    } else {
                        errorSlikaKoncnica();
                    }
                } else {
                    novaVadba = new Vadba();
                    znacke = "";
                    errorSlikaNull();
                }
            } else {
                novaVadba = new Vadba();
                znacke = "";
                errorVideo();
            }
        } else {
            warn();
            novaVadba = new Vadba();
        }
    }

    private void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Program s takšnim nazivom že obstaja!"));
    }

    private void errorSlikaNull() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Izberite sliko!"));
    }

    private void errorSlikaKoncnica() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Uporabite lahko format .jpg ali .png!"));
    }

    private void errorSlikaVelikost() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Slika je prevelika!"));
    }

    private void errorVideo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Vpišite ustrezen URL!"));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Vadba je bila uspešno dodana v sistem."));
    }

}
