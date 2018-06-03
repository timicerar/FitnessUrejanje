package si.um.feri.praktikum.jsf.dnevi;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBDan;
import si.um.feri.praktikum.ejb.EJBProgram;
import si.um.feri.praktikum.vao.Dan;
import si.um.feri.praktikum.vao.Program;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "danBean")
@SessionScoped
public class DanBean {

    @Getter
    @Setter
    private Dan novDan = new Dan();
    @Getter
    @Setter
    private Program izbranProgram = new Program();

    @Getter
    private int idProgram;

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
        izbranProgram = ejbProgram.programById(idProgram);
    }

    @EJB
    private EJBDan ejbDan;
    @EJB
    private EJBProgram ejbProgram;

    public void dodajDan() {
        if (ejbDan.validateNazivDnevaVProgramu(idProgram, novDan.getNaziv())) {
            novDan.setTkIdProgram(izbranProgram);
            ejbDan.addDan(novDan);
            novDan = new Dan();
            info();
        } else {
            novDan = new Dan();
            warnNaziv();
        }
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Programu '" + izbranProgram.getNaziv() + "' se je uspešno dodal nov dan."));
    }

    private void warnNaziv() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "V programu '" + izbranProgram.getNaziv() + "' že obstaja dan s takšnim imenom!"));
    }
}
