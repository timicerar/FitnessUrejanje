package si.um.feri.praktikum.jsf.osebe;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBOseba;
import si.um.feri.praktikum.email.PosljiSporocilo;
import si.um.feri.praktikum.vao.Oseba;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.jms.JMSException;
import javax.naming.NamingException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@ManagedBean(name = "osebaBean")
@SessionScoped
public class OsebaBean {
    @Getter
    @Setter
    private Oseba novaOseba = new Oseba();
    @Getter
    private int izbranIdOsebe;
    @Getter
    @Setter
    private Oseba izbranaOseba = new Oseba();

    public void setIzbranIdOsebe(int izbranIdOsebe) {
        this.izbranIdOsebe = izbranIdOsebe;
        izbranaOseba = ejbOseba.osebById(izbranIdOsebe);
    }

    @EJB
    private EJBOseba ejbOseba;

    public void dodajClana() throws JMSException, NamingException, UnsupportedEncodingException {
        if (ejbOseba.validateEmail(novaOseba.getEmail())) {
            novaOseba.setDatumVpisa(new Date());
            ejbOseba.addOseba(novaOseba);
            PosljiSporocilo.posljiPodatkeOsebe(novaOseba, 1);
            novaOseba = new Oseba();
            info();
        } else {
            novaOseba = new Oseba();
            warnEmail();
        }
    }

    public void urediClana(int idOseba) {
        Oseba oseba = ejbOseba.osebById(idOseba);

        if(!oseba.getIme().equals(izbranaOseba.getIme()) || !oseba.getPriimek().equals(izbranaOseba.getPriimek()) || !oseba.getEmail().equals(izbranaOseba.getEmail()) || !oseba.getDatumRojstva().equals(izbranaOseba.getDatumRojstva()) || oseba.getSpol() != izbranaOseba.getSpol() || !oseba.getTelefon().equals(izbranaOseba.getTelefon())) {
            if (oseba.getEmail().equals(izbranaOseba.getEmail())) {
                ejbOseba.mergeOseba(izbranaOseba);
                infoUrejanje();
            } else {
                if (ejbOseba.validateEmail(izbranaOseba.getEmail())) {
                    ejbOseba.mergeOseba(izbranaOseba);
                    infoUrejanje();
                } else {
                    izbranaOseba = ejbOseba.osebById(idOseba);
                    warnEmail();
                }
            }
        } else {
            warnUrejanje();
        }
    }

    public void izbrisiClana(int idOseba) {
        ejbOseba.deleteOseba(idOseba);
    }

    private void warnEmail() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Email je že v uporabi!"));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Član je bil uspešno dodan v sistem."));
    }

    private void infoUrejanje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Član je bil uspešno spremenjen."));
    }

    private void warnUrejanje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Niste spremenili nobenega podatka."));
    }

}
