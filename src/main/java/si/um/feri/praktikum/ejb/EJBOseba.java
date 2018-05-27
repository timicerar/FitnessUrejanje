package si.um.feri.praktikum.ejb;

import si.um.feri.praktikum.vao.Oseba;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.UnsupportedEncodingException;
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

    public void addOseba(Oseba o) throws UnsupportedEncodingException {
        entityManager.persist(o);
    }

    public Oseba mergeOseba(Oseba o) {
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

    public boolean validateEmail(String email) {
        System.out.println(email);
        return entityManager.createQuery("SELECT o FROM Oseba o WHERE o.email = '" + email + "'").getResultList().size() == 0;
    }
}
