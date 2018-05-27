package si.um.feri.praktikum.jsf.meritve;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.ejb.EJBMeritev;
import si.um.feri.praktikum.vao.Meritev;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "vrniVseMeritveOsebe")
@SessionScoped
public class VrniMeritveOsebe {
    @Getter
    @Setter
    private List<Meritev> meritveOsebe = null;

    @Getter
    private int izbranIdOsebe;

    @EJB
    private EJBMeritev ejbMeritev;

    public void setIzbranIdOsebe(int idOsebe) {
        izbranIdOsebe = idOsebe;
        meritveOsebe = ejbMeritev.vrniMeritvePoId(idOsebe);
    }
}
