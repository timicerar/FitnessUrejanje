package si.um.feri.praktikum.jsf.programi;

import si.um.feri.praktikum.vao.Program;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "programBean")
@SessionScoped
public class ProgramBean {

    private Program novProgram = new Program();

    public void novProgram() {
        System.out.println("nov program...");
    }

}
