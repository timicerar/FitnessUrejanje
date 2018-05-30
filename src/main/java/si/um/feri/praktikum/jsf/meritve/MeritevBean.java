package si.um.feri.praktikum.jsf.meritve;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBMeritev;
import si.um.feri.praktikum.ejb.EJBOseba;
import si.um.feri.praktikum.vao.Meritev;
import si.um.feri.praktikum.vao.Oseba;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "meritevBean")
@SessionScoped
public class MeritevBean {

    @Getter
    @Setter
    private Meritev izbranaMeritev = new Meritev();
    @Getter
    private int idIzbraneMeritve;
    @Getter
    private int idIzbraneOsebe;
    @Getter
    @Setter
    private Oseba izbranaOseba = new Oseba();

    public void setIdIzbraneMeritve(int idIzbraneMeritve) {
        this.idIzbraneMeritve = idIzbraneMeritve;
        izbranaMeritev = ejbMeritev.meritevById(idIzbraneMeritve);
    }

    public void setIdIzbraneOsebe(int idIzbraneOsebe) {
        this.idIzbraneOsebe = idIzbraneOsebe;
        izbranaOseba = ejbOseba.osebById(idIzbraneOsebe);
    }

    @EJB
    private EJBMeritev ejbMeritev;
    @EJB
    private EJBOseba ejbOseba;

    public void urediMeritev(int idMeritev) {
        Meritev meritev = ejbMeritev.meritevById(idMeritev);

        if (meritev.getTeza() != izbranaMeritev.getTeza() || meritev.getVisina() != izbranaMeritev.getVisina() ||
                meritev.getObsegPasu() != izbranaMeritev.getObsegPasu()) {
            ejbMeritev.mergeMeritev(izbranaMeritev);
            infoMeritev();
        } else {
            warnMeritev();
        }
    }

    public void izbrisiMeritev(int idMeritev) {
        ejbMeritev.deleteMeritev(idMeritev);
    }

    private void warnMeritev() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Niste spremenili nobenega podatka."));
    }

    private void infoMeritev() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Meritev je bila uspešno spremenjena!"));

    }
}
