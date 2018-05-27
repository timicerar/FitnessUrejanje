package si.um.feri.praktikum.jsf.meritve;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBMeritev;
import si.um.feri.praktikum.vao.Meritev;

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
    @Setter
    private int idIzbraneOsebe;

    public void setIdIzbraneMeritve(int idIzbraneMeritve) {
        this.idIzbraneMeritve = idIzbraneMeritve;
        izbranaMeritev = ejbMeritev.meritevById(idIzbraneMeritve);
    }

    @EJB
    private EJBMeritev ejbMeritev;

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

    public void warnMeritev() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Niste spremenili nobenega podatka."));
    }

    public void infoMeritev() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Meritev je bila uspešno spremenjena!"));

    }
}
