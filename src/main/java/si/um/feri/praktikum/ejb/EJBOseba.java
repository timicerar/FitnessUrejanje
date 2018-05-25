package si.um.feri.praktikum.ejb;

import si.um.feri.praktikum.vao.Oseba;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.List;

@LocalBean
@Stateless
public class EJBOseba {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Oseba> vrniVseOsebe() {
        return entityManager.createQuery("SELECT o FROM Oseba o").getResultList();
    }

    public Oseba osebById(int idOseba) {
        return entityManager.find(Oseba.class, idOseba);
    }

    public void addOseba(Oseba o) {
        entityManager.persist(o);
    }

    public Oseba mergeOseba(Oseba o) {
        System.out.println("Merganje osebe...");

        if(o.getIdOseba() > 0) {
            entityManager.merge(o);
            return entityManager.find(Oseba.class, o.getIdOseba());
        }

        return o;
    }

    public void deleteOseba(int idOseba) {
        System.out.println("Brisem osebo...");
        entityManager.createQuery("UPDATE Meritev m SET m.tkIdOseba = null WHERE m.tkIdOseba.idOseba = " + idOseba).executeUpdate();
        entityManager.remove(entityManager.find(Oseba.class, idOseba));
    }

    public void updateOseba(Oseba o) {
        System.out.println("Spreminjam osebo...");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datumRojstva = simpleDateFormat.format(o.getDatumRojstva());
        entityManager.createQuery("UPDATE Oseba o SET o.ime = '" + o.getIme() + "', o.priimek = '" + o.getPriimek() + "', o.datumRojstva = '" + datumRojstva + "', o.email = '" + o.getEmail() + "' WHERE o.idOseba = " + o.getIdOseba()).executeUpdate();
    }

    public boolean validateEmail(String email) {
        return entityManager.createQuery("SELECT o FROM Oseba o WHERE o.email = '" + email + "'").getResultList().size() == 0;
    }

}
