package si.um.feri.praktikum.jsf.trener;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBTrener;
import si.um.feri.praktikum.email.PosljiSporocilo;
import si.um.feri.praktikum.vao.Trener;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.jms.JMSException;
import javax.naming.NamingException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

@ManagedBean(name = "trenerBean")
@SessionScoped
public class TrenerBean {
    @Getter
    @Setter
    private Trener novTrener = new Trener();
    @Getter
    @Setter
    private Trener izbranTrener = new Trener();
    @Getter
    private int idIzbranegaTrenerja;

    public void setIdIzbranegaTrenerja(int idIzbranegaTrenerja) {
        this.idIzbranegaTrenerja = idIzbranegaTrenerja;
        izbranTrener = ejbTrener.trenerById(idIzbranegaTrenerja);
    }

    @EJB
    private EJBTrener ejbTrener;

    public void dodajTrenerja() throws JMSException, NamingException, UnsupportedEncodingException {
        if (ejbTrener.validateEmailAndUsername(novTrener.getUporabniskoIme(), novTrener.getEmail())) {
            novTrener.setDatumVpisa(new Date());
            novTrener.setGeslo(getSaltString());
            PosljiSporocilo.posljiPodatkeTrenerja(novTrener, 2);
            ejbTrener.addTrener(novTrener);
            novTrener = new Trener();
            info();
        } else {
            novTrener = new Trener();
            warnEmailUpo();
        }
    }

    public void urediTrenerja(int idTrener) {
        Trener trener = ejbTrener.trenerById(idTrener);

        if (!trener.getUporabniskoIme().equals(izbranTrener.getUporabniskoIme()) || !trener.getIme().equals(izbranTrener.getIme()) || !trener.getPriimek().equals(izbranTrener.getPriimek()) || !trener.getEmail().equals(izbranTrener.getEmail()) || !trener.getDatumRojstva().equals(izbranTrener.getDatumRojstva()) || trener.getSpol() != izbranTrener.getSpol() || !trener.getTelefon().equals(izbranTrener.getTelefon())) {
            if (trener.getEmail().equals(izbranTrener.getEmail()) && trener.getUporabniskoIme().equals(izbranTrener.getUporabniskoIme())) {
                ejbTrener.mergeTrener(izbranTrener);
                infoUrejanje();
            } else {
                if (ejbTrener.validateEmailAndUsername(izbranTrener.getUporabniskoIme(), izbranTrener.getEmail())) {
                    ejbTrener.mergeTrener(izbranTrener);
                    infoUrejanje();
                } else {
                    izbranTrener = ejbTrener.trenerById(idTrener);
                    warnEmailUpo();
                }
            }
        } else {
            warnPodatki();
        }
    }

    public void resetGeslo() throws JMSException, NamingException {
        izbranTrener.setGeslo(getSaltString());
        PosljiSporocilo.posljiPodatkeTrenerja(izbranTrener, 3);
        ejbTrener.resetPassword(izbranTrener);
        infoResetPw();
    }

    public void izbrisiTrenerja(int idTrener) {
        ejbTrener.deleteTrener(idTrener);
    }

    private void warnEmailUpo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Uporabniško ime ali email sta že v uporabi!"));
    }
    private void warnPodatki() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Niste spremenili nobenega podatka!"));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Trener je bil uspešno dodan v sistem."));
    }

    private void infoUrejanje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Trener je bil uspešno spremenjen."));
    }

    private void infoResetPw() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Geslo je bilo uspešno spremenjeno. Trener je bil obveščen po emailu."));
    }

    private String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();

        Random rand = new Random();

        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rand.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        return salt.toString();
    }
}
