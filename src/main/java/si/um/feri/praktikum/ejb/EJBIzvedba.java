package si.um.feri.praktikum.ejb;

import si.um.feri.praktikum.vao.Izvedba;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class EJBIzvedba {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Izvedba> vrniIzvedbeZaZeloSlabo(int idDan) {
        return entityManager.createQuery("SELECT i FROM Izvedba i WHERE i.pocutje = 0 AND i.tkIdDan.idDan = " + idDan).getResultList();
    }

    public List<Izvedba> vrniIzvedbeZaSlabo(int idDan) {
        return entityManager.createQuery("SELECT i FROM Izvedba i WHERE i.pocutje = 1 AND i.tkIdDan.idDan = " + idDan).getResultList();
    }

    public List<Izvedba> vrniIzvedbeZaPovprecno(int idDan) {
        return entityManager.createQuery("SELECT i FROM Izvedba i WHERE i.pocutje = 2 AND i.tkIdDan.idDan = " + idDan).getResultList();
    }

    public List<Izvedba> vrniIzvedbeZaDobro(int idDan) {
        return entityManager.createQuery("SELECT i FROM Izvedba i WHERE i.pocutje = 3 AND i.tkIdDan.idDan = " + idDan).getResultList();
    }

    public List<Izvedba> vrniIzvedbeZaZeloDobro(int idDan) {
        return entityManager.createQuery("SELECT i FROM Izvedba i WHERE i.pocutje = 4 AND i.tkIdDan.idDan = " + idDan).getResultList();
    }
}
