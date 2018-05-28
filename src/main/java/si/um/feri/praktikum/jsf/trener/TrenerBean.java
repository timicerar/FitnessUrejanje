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
import java.nio.charset.StandardCharsets;
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
            warn();
        }
    }

    public void urediTrenerja(int idTrener) {

    }

    public void izbrisiTrener(int idTrener) {

    }

    private void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Uporabniško ime ali email sta že v uporabi!"));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Trener je bil uspešno dodan v sistem."));
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
