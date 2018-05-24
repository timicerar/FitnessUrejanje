package si.um.feri.praktikum.ejb;

import si.um.feri.praktikum.vao.Trener;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class EJBTrener {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Trener> vrniVseTrenerje() {
        return entityManager.createQuery("SELECT t FROM Trener t").getResultList();
    }

    public Trener trenerById(int idTrener) {
        return entityManager.find(Trener.class, idTrener);
    }

    public void addTrener(Trener t) {
        System.out.println("Shranjujem trenerja...");
        entityManager.persist(t);
    }

    public Trener mergeTrener(Trener t) {
        System.out.println("Merganje trenerja...");

        if (t.getIdTrener() > 0) {
            entityManager.merge(t);
            return entityManager.find(Trener.class, t.getIdTrener());
        }

        return t;
    }

    public void deleteTrener(int idTrener) {
        System.out.println("Brisem trenerja...");
        Trener trener = entityManager.find(Trener.class, idTrener);
        entityManager.remove(trener);
    }

}