package si.um.feri.praktikum.jsf.osebe;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.vao.Oseba;
import si.um.feri.praktikum.vao.Trener;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "osebaBean")
@SessionScoped
public class OsebaBean {
    @Getter
    @Setter
    private Oseba novaOseba = new Oseba();

    @Getter
    @Setter
    private Trener novTrener = new Trener();

    public void dodajClana() {
        System.out.println("Dodajanje clana!");
    }

    public void dodajTrenerja() {
        System.out.println("Dodajanje Trenerja!");
    }
}
