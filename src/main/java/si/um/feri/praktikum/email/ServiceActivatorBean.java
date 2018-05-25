package si.um.feri.praktikum.email;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.time.LocalDate;

@Stateless
@Local(EJBServiceActivator.class)
public class ServiceActivatorBean implements EJBServiceActivator {

    @Override
    public void posljiMailNovemuClanu(String ime, String priimek, String email) {
        LocalDate datum = LocalDate.now();

        String besedilo = "Dobrodošli, "
                + ime
                + " "
                + priimek
                + "!"
                + "<br/><br/>Uspešno ste bili včlanjeni v Fitness!"
                + "<br/><br/>V našo aplikacijo se lahko prijavite preko Faceebook profila ali z Google računom. Uporabiti morate email, ki ste ga podali receptorju ob včlanitvi v Fitness."
                + "<br/><br/>Datum včlanitve v Fitness: " + datum
                + "<br/><br/>Lep pozdrav," + "<br/>Fitness";

        SendEmail.posljiEmail(email, "Potrdilo o uspešnem včlantvu v Fitness", besedilo);
    }

    @Override
    public void posljiMailNovemuTrenerju(String ime, String priimek, String upoIme, String geslo, String email) {
        LocalDate datum = LocalDate.now();

        String besedilo = "Dobrodošli, "
                + ime
                + " "
                + priimek
                + "!"
                + "<br/><br/>Uspešno ste postali nov trener v Fitness-u!"
                + "<br/><br/>Želimo vam, uspešno uporabo naše aplikacije in veliko dobro ustvarjenih programov."
                + "<br/><br/>Uporabniško ime: " + upoIme
                + "<br/><br/>Začasno geslo, ki ga lahko kasneje spremenite: " + geslo
                + "<br/><br/>Datum vpisa v Fitness: " + datum
                + "<br/><br/>Lep pozdrav," + "<br/>Fitness";

        SendEmail.posljiEmail(email, "Potrdilo o članstvu novega Trenerja Fitness kluba", besedilo);
    }
}
