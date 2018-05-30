package si.um.feri.praktikum.ejb;

import si.um.feri.praktikum.vao.Vadba;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class EJBVadba {

    @PersistenceContext
    EntityManager entityManager;

    public List<Vadba> vrniVseVadbe() {
        return entityManager.createQuery("SELECT v FROM Vadba v").getResultList();
    }

    public Vadba vadbaById(int idVadba) {
        return entityManager.find(Vadba.class, idVadba);
    }

    public void addVadba(Vadba v) {
        entityManager.persist(v);
    }

    public Vadba mergeVadba(Vadba v) {
        if (v.getIdVadba() > 0){
            entityManager.merge(v);
            return entityManager.find(Vadba.class, v.getIdVadba());
        }

        return v;
    }

    public boolean validateNazivVadbe(String naziv) {
        return entityManager.createQuery("SELECT v FROM Vadba v WHERE v.naziv = '" + naziv + "'").getResultList().size() == 0;
    }
}
