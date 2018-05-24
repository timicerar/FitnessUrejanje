package si.um.feri.praktikum.jsf.vadbe;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.vao.Vadba;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "vadbaBean")
@SessionScoped
public class VadbaBean {

    @Getter
    @Setter
    private Vadba novaVadba = new Vadba();

    public void dodajVadba() {
        System.out.println("Dodajanje vadbe...");
    }

}
