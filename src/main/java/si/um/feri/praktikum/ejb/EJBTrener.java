package si.um.feri.praktikum.ejb;

import si.um.feri.praktikum.jsf.trener.CryptWithMD5;
import si.um.feri.praktikum.vao.Oseba;
import si.um.feri.praktikum.vao.Program;
import si.um.feri.praktikum.vao.Trener;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.UnsupportedEncodingException;
import java.util.List;

@LocalBean
@Stateless
public class EJBTrener {

    @EJB
    private EJBProgram ejbProgram;
    @EJB
    private EJBOseba ejbOseba;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Trener> vrniVseTrenerje() {
        return entityManager.createQuery("SELECT t FROM Trener t").getResultList();
    }

    public Trener trenerById(int idTrener) {
        return entityManager.find(Trener.class, idTrener);
    }

    public void addTrener(Trener t) throws UnsupportedEncodingException {
        t.setGeslo(CryptWithMD5.cryptWithMD5(t.getGeslo()));
        entityManager.persist(t);
    }

    public Trener mergeTrener(Trener t) {
        if (t.getIdTrener() > 0) {
            entityManager.merge(t);
            return entityManager.find(Trener.class, t.getIdTrener());
        }

        return t;
    }

    public void deleteTrener(int idTrener) {
        if (ejbProgram.programiByTkIdTrener(idTrener) != null) {
            List<Program> programiTrenerja = ejbProgram.programiByTkIdTrener(idTrener);

            for (int i=0; i<programiTrenerja.size(); i++) {
                programiTrenerja.get(i).getTkIdOseba().clear();
            }

            List<Oseba> listVsehOseb = ejbOseba.vrniVseOsebe();

            for (int i = 0; i < listVsehOseb.size(); i++) {
                for (int k = 0; k < programiTrenerja.size(); k++) {
                    for (int j = 0; j < listVsehOseb.get(i).getTkIdProgram().size(); j++) {
                        if (listVsehOseb.get(i).getTkIdProgram().get(j).getIdProgram() == programiTrenerja.get(k).getIdProgram()) {
                            listVsehOseb.get(i).getTkIdProgram().remove(j);
                        }
                    }
                }
            }

            for (Oseba aListVsehOseb : listVsehOseb) {
                ejbOseba.mergeOseba(aListVsehOseb);
            }

            for (Program aProgrami : programiTrenerja) {
                ejbProgram.mergeProgram(aProgrami);
            }
        }

        entityManager.createQuery("UPDATE Program p SET p.tkIdTrener = null WHERE p.tkIdTrener.idTrener = " + idTrener).executeUpdate();
        Trener trener = entityManager.find(Trener.class, idTrener);
        entityManager.remove(trener);
    }

    public boolean validateEmailAndUsername(String upoIme, String email) {
        return entityManager.createQuery("SELECT t FROM Trener t WHERE t.email = '" + email + "' OR t.uporabniskoIme = '" + upoIme + "'").getResultList().size() == 0;
    }

    public Trener resetPassword(Trener t) {
        if (t.getIdTrener() > 0) {
            t.setGeslo(CryptWithMD5.cryptWithMD5(t.getGeslo()));
            entityManager.merge(t);
            return entityManager.find(Trener.class, t.getIdTrener());
        }

        return t;
    }

}
