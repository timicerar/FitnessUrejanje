package si.um.feri.praktikum.jsf.postavke;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.vao.Postavka;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "postavkaBean")
@SessionScoped
public class PostavkaBean {

    @Getter
    @Setter
    private Postavka novaPostavka = new Postavka();

    public void dodajPostavko(){

    }
}
