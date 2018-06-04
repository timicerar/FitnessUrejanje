package si.um.feri.praktikum.jsf.dnevi;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBDan;
import si.um.feri.praktikum.vao.Dan;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "podrobnostiDnevaBean")
@SessionScoped
public class PodrobnostiDnevaBean {

    @Getter
    @Setter
    private Dan izbranDan = new Dan();
    @Getter
    private int idIzbranegaDneva;

    @EJB
    private EJBDan ejbDan;

    public void setIdIzbranegaDneva(int idIzbranegaDneva) {
        this.idIzbranegaDneva = idIzbranegaDneva;
        izbranDan = ejbDan.danById(idIzbranegaDneva);
    }

    public void removeDan(int idDan) {
        ejbDan.deleteDan(idDan);
    }

    public void urediDan(int idDan) {
        Dan dan = ejbDan.danById(idDan);

        if (!dan.getNaziv().equals(izbranDan.getNaziv()) || !dan.getOpis().equals(izbranDan.getOpis())) {
            if (dan.getNaziv().equals(izbranDan.getNaziv())) {
                ejbDan.mergeDan(izbranDan);
                infoUrejanje();
            } else {
                if (ejbDan.validateNazivDnevaVProgramu(izbranDan.getTkIdProgram().getIdProgram(), izbranDan.getNaziv())) {
                    ejbDan.mergeDan(izbranDan);
                    infoUrejanje();
                } else {
                    izbranDan = ejbDan.danById(idDan);
                    warnNaziv();
                }
            }
        } else {
            izbranDan = ejbDan.danById(idDan);
            warnUrejanje();
        }
    }

    private void infoUrejanje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Dan je bil uspešno spremenjen."));
    }

    private void warnNaziv() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "V programu '" + izbranDan.getTkIdProgram().getNaziv() + "' že obstaja dan s takšnim imenom!"));
    }

    private void warnUrejanje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Niste spremenili nobenega podatka!"));
    }
}
