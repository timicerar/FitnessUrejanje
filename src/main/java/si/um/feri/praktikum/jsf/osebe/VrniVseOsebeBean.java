package si.um.feri.praktikum.jsf.osebe;

import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBOseba;
import si.um.feri.praktikum.vao.Oseba;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "vrniVseOsebeBean")
@SessionScoped
public class VrniVseOsebeBean {

    @Setter
    private List<Oseba> vsiClani = null;

    @EJB
    private EJBOseba ejbOseba;

    public List<Oseba> getVsiClani() {
        try {
            vsiClani = ejbOseba.vrniVseOsebe();
        } catch (Exception e) {
            vsiClani = new ArrayList<>();
        }

        return vsiClani;
    }
}
