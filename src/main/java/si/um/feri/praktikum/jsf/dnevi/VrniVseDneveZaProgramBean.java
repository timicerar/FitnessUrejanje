package si.um.feri.praktikum.jsf.dnevi;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBDan;
import si.um.feri.praktikum.vao.Dan;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "vrniVseDneveProgama")
@SessionScoped
public class VrniVseDneveZaProgramBean {

    @Setter
    private List<Dan> vsiDneviPrograma = null;
    @Getter
    @Setter
    private int idIzbranegaPrograma;

    @EJB
    private EJBDan ejbDan;

    public List<Dan> getVsiDneviPrograma() {
        try {
            vsiDneviPrograma = ejbDan.vrniVseDnevePrograma(idIzbranegaPrograma);
        } catch (Exception e) {
            vsiDneviPrograma = new ArrayList<>();
        }

        return vsiDneviPrograma;
    }

}
