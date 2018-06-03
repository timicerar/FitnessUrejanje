package si.um.feri.praktikum.jsf.programi;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBProgram;
import si.um.feri.praktikum.vao.Program;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "programBean")
@SessionScoped
public class ProgramBean {

    @Getter
    @Setter
    private Program novProgram = new Program();
    @Getter
    @Setter
    private Program izbranProgram = new Program();
    @Getter
    private int idIzbranegaPrograma;

    public void setIdIzbranegaPrograma(int idIzbranegaPrograma) {
        this.idIzbranegaPrograma = idIzbranegaPrograma;
        izbranProgram = ejbProgram.programById(idIzbranegaPrograma);
    }

    @EJB
    private EJBProgram ejbProgram;

    public void novProgram() {
        if (ejbProgram.validateNazivPrograma(novProgram.getNaziv())) {
            ejbProgram.addProgram(novProgram);
            novProgram = new Program();
            info();
        } else {
            novProgram = new Program();
            warnNaziv();
        }
    }

    public void urediProgram(int idProgram) {
        Program program = ejbProgram.programById(idProgram);

        if (!program.getNaziv().equals(izbranProgram.getNaziv()) || program.getIntenzivnost() != izbranProgram.getIntenzivnost() ||
                !program.getOpis().equals(izbranProgram.getOpis())) {
            if (program.getNaziv().equals(izbranProgram.getNaziv())) {
                ejbProgram.mergeProgram(izbranProgram);
                infoUrejanje();
            } else {
                if (ejbProgram.validateNazivPrograma(izbranProgram.getNaziv())) {
                    ejbProgram.mergeProgram(izbranProgram);
                    infoUrejanje();
                } else {
                    izbranProgram = ejbProgram.programById(idProgram);
                    warnNaziv();
                }
            }
        } else {
            warnUrejanje();
        }
    }

    public void deleteProgram(int idProgram) {
        ejbProgram.deleteProgram(idProgram);
    }

    private void warnNaziv() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Program s takšnim nazivom že obstaja!"));
    }

    private void warnUrejanje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Niste spremenili nobenega podatka!"));
    }

    private void infoUrejanje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Program je bil uspešno spremenjen."));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Program je bil uspešno dodan v sistem."));
    }

}
