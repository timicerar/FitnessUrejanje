package si.um.feri.praktikum.jsf.postavke;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;
import si.um.feri.praktikum.ejb.EJBDan;
import si.um.feri.praktikum.ejb.EJBPostavka;
import si.um.feri.praktikum.ejb.EJBVadba;
import si.um.feri.praktikum.vao.Dan;
import si.um.feri.praktikum.vao.Postavka;
import si.um.feri.praktikum.vao.Vadba;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "postavkaBean")
@SessionScoped
public class PostavkaBean {

    @Getter
    @Setter
    private Postavka novaPostavka = new Postavka();
    @Getter
    @Setter
    private String zaporednoSt;
    @Getter
    @Setter
    private String steviloSerij;
    @Getter
    @Setter
    private String steviloPonovitev;
    @Getter
    @Setter
    private String teza;

    @EJB
    private EJBVadba ejbVadba;
    @EJB
    private EJBDan ejbDan;
    @EJB
    private EJBPostavka ejbPostavka;

    public void dodajPostavko(int idVadba, int idDan) {
        Vadba vadba = ejbVadba.vadbaById(idVadba);
        Dan dan = ejbDan.danById(idDan);

        novaPostavka.setZaporednaSt(Integer.parseInt(zaporednoSt));
        novaPostavka.setSteviloSerij(Integer.parseInt(steviloSerij));
        novaPostavka.setSteviloPonovitev(Integer.parseInt(steviloPonovitev));

        if (Double.parseDouble(teza) > 0)
            novaPostavka.setTeza(Double.parseDouble(teza));

        novaPostavka.setTkIdDan(dan);
        novaPostavka.setTkIdVadba(vadba);

        ejbPostavka.addPostavka(novaPostavka);

        novaPostavka = new Postavka();
        zaporednoSt = "";
        steviloPonovitev = "";
        steviloSerij = "";
        teza = "";
    }

    public boolean preveri(int idDan, Vadba v) {
        List<Postavka> postavkeZaDan = ejbPostavka.vrniVsePostavkeZaDan(idDan);

        for (Postavka trPostavka : postavkeZaDan) {
            if (trPostavka.getTkIdVadba().getIdVadba() == v.getIdVadba()) {
                return true;
            }
        }

        return false;
    }

    public void odstraniPostavko(int idDan, int idVadba) {
        ejbPostavka.removePostavkaZaDanInVadbo(idDan, idVadba);
    }
}
