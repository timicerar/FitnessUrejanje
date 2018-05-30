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

    private void warnNaziv() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Program s takšnim nazivom že obstaja!"));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Program je bil uspešno dodan v sistem."));
    }

}
