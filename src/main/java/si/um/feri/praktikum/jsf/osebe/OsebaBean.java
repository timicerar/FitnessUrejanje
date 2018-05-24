package si.um.feri.praktikum.jsf.osebe;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.vao.Oseba;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "osebaBean")
@SessionScoped
public class OsebaBean {
    @Getter
    @Setter
    private Oseba novaOseba = new Oseba();

    public void dodajClana() {
        System.out.println("Dodajanje clana!");
    }
}
