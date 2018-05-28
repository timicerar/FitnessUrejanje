package si.um.feri.praktikum.email;

public interface EJBServiceActivator {

    void posljiMailNovemuClanu(String ime, String priimek, String email);
    void posljiMailNovemuTrenerju(String ime, String priimek, String upoIme, String geslo, String email);
    void posljiSpremenjenoGeslo(String ime, String priimek, String upoIme, String geslo, String email);
}
