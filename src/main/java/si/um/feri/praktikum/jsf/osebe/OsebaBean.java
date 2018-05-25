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
import java.util.Date;
import java.util.List;

@ManagedBean(name = "osebaBean")
@SessionScoped
public class OsebaBean {
    @Getter
    @Setter
    private Oseba novaOseba = new Oseba();

    @EJB
    private EJBOseba ejbOseba;

    public void dodajClana() throws JMSException, NamingException {
        if(ejbOseba.validateEmail(novaOseba.getEmail())) {
            novaOseba.setDatumVpisa(new Date());
            ejbOseba.addOseba(novaOseba);
            PosljiSporocilo.posljiPodatkeOsebe(novaOseba, 1);
            novaOseba = new Oseba();
            info();
        } else {
            novaOseba = new Oseba();
            warn();
        }
    }

    private void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Email je že v uporabi!"));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Član je bil uspešno dodan v sistem."));
    }

}
