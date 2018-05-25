package si.um.feri.praktikum.jsf.trener;

import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBTrener;
import si.um.feri.praktikum.vao.Trener;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "vrniVseTrenerjeBean")
@SessionScoped
public class VrniVseTrenerjeBean {

    @Setter
    private List<Trener> vsiTrenerji = null;

    @EJB
    private EJBTrener ejbTrener;

    public List<Trener> getVsiTrenerji() {
        try {
            vsiTrenerji = ejbTrener.vrniVseTrenerje();
        } catch (Exception e) {
            vsiTrenerji = new ArrayList<>();
        }

        return vsiTrenerji;
    }

}
