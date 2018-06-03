package si.um.feri.praktikum.jsf.dnevi;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBDan;
import si.um.feri.praktikum.vao.Dan;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
}
