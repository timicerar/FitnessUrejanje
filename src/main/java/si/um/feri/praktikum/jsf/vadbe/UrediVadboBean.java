package si.um.feri.praktikum.jsf.vadbe;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.UploadedFile;
import si.um.feri.praktikum.ejb.EJBVadba;
import si.um.feri.praktikum.ejb.EJBZnacka;
import si.um.feri.praktikum.vao.Vadba;
import si.um.feri.praktikum.vao.Znacka;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "urediVadboBean")
@SessionScoped
public class UrediVadboBean {

    @EJB
    private EJBVadba ejbVadba;
    @EJB
    private EJBZnacka ejbZnacka;

    @Getter
    @Setter
    private String znacke = "";
    @Getter
    @Setter
    private UploadedFile file;
    @Getter
    @Setter
    private List<Znacka> listZnack = new ArrayList<>();
    @Getter
    @Setter
    private Vadba izbranaVadba = new Vadba();
    @Getter
    private int idIzbraneVadbe;

    public void setIdIzbraneVadbe(int idIzbraneVadbe) {
        this.idIzbraneVadbe = idIzbraneVadbe;
        izbranaVadba = ejbVadba.vadbaById(idIzbraneVadbe);
        listZnack = ejbZnacka.znackeZaVadbo(idIzbraneVadbe);

        for (int i=0; i<listZnack.size(); i++) {
            if (i == 0)
                znacke = "#" + listZnack.get(i).getNaziv() + " ";
            else
                znacke = znacke + "#" + listZnack.get(i).getNaziv() + " ";
        }
    }

    public void urediVadbo(int idVadba) {
        Vadba v = ejbVadba.vadbaById(idVadba);

    }
    
}
