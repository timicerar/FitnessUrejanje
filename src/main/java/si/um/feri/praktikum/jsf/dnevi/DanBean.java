package si.um.feri.praktikum.jsf.dnevi;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.praktikum.vao.Dan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "danBean")
@SessionScoped
public class DanBean {

    @Getter
    @Setter
    private Dan novDan = new Dan();

    public void dodajDan() {
    }
}
