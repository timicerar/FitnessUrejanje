package si.um.feri.praktikum.jsf.vadbe;

import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBTrener;
import si.um.feri.praktikum.ejb.EJBVadba;
import si.um.feri.praktikum.vao.Trener;
import si.um.feri.praktikum.vao.Vadba;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "vrniVseVadbeBean")
@SessionScoped
public class VrniVseVadbeBean {
    @Setter
    private List<Vadba> vseVadbe = null;

    /*@EJB
    private EJBVadba ejbVadba;

    public List<Vadba> getVseVadbe() {
        try {
            vseVadbe = ejbVadba.vrniVseVadbe();
        } catch (Exception e) {
            vseVadbe = new ArrayList<>();
        }

        return vseVadbe;
    }*/
}
