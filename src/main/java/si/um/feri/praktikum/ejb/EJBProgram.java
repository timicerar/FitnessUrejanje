package si.um.feri.praktikum.ejb;

import si.um.feri.praktikum.vao.Program;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class EJBProgram {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Program> vrniVsePrograme() {
        return entityManager.createQuery("SELECT p FROM Program p").getResultList();
    }

    public Program programById(int idProgram) {
        return entityManager.find(Program.class, idProgram);
    }

    public void addProgram(Program p) {
        entityManager.persist(p);
    }

    public Program mergeProgram(Program p) {
        if(p.getIdProgram() > 0) {
            entityManager.merge(p);
            return entityManager.find(Program.class, p.getIdProgram());
        }

        return p;
    }

    public boolean validateNazivPrograma(String naziv) {
        return entityManager.createQuery("SELECT p FROM Program p WHERE p.naziv = '" + naziv + "'").getResultList().size() == 0;
    }
}
