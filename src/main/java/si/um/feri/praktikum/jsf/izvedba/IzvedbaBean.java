package si.um.feri.praktikum.jsf.izvedba;

import si.um.feri.praktikum.ejb.EJBIzvedba;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "izvedbaBean")
@SessionScoped
public class IzvedbaBean {
    @EJB
    private EJBIzvedba ejbIzvedba;

    public int vrniStIzvedbZaZeloSlabo(int idDan) {
        return ejbIzvedba.vrniIzvedbeZaZeloSlabo(idDan).size();
    }

    public int vrniStIzvedbZaSlabo(int idDan) {
        return ejbIzvedba.vrniIzvedbeZaSlabo(idDan).size();
    }

    public int vrniStIzvedbZaPovprecno(int idDan) {
        return ejbIzvedba.vrniIzvedbeZaPovprecno(idDan).size();
    }

    public int vrniStIzvedbZaDobro(int idDan) {
        return ejbIzvedba.vrniIzvedbeZaDobro(idDan).size();
    }

    public int vrniStIzvedbZaZeloDobro(int idDan) {
        return ejbIzvedba.vrniIzvedbeZaZeloDobro(idDan).size();
    }
}
