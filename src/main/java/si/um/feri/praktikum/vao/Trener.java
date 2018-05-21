package si.um.feri.praktikum.vao;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "Trener")
@Table(name = "Trener")
public class Trener implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTrener")
    @Getter
    @Setter
    private int idTrener;
    @Column(name = "UpoIme", nullable = false)
    @Getter
    @Setter
    private String upoIme;
    @Column(name = "Geslo", nullable = false)
    @Getter
    @Setter
    private String geslo;
    @Column(name = "Ime", nullable = false)
    @Getter
    @Setter
    private String ime;
    @Column(name = "Priimek", nullable = false)
    @Getter
    @Setter
    private String priimek;
    @Column(name = "Email", nullable = false)
    @Getter
    @Setter
    private String email;
    @Column(name = "Spol", nullable = false)
    @Getter
    @Setter
    private int spol;
    @Column(name = "DatumRojstva", nullable = false)
    @Getter
    @Setter
    private LocalDate datumRojstva;
    @Column(name = "Telefon", nullable = false)
    @Getter
    @Setter
    private int telefon;
    @Column(name = "DatumVpisa", nullable = false)
    @Getter
    @Setter
    private LocalDate datumVpisa;
    @Column(name = "Kraj", nullable = false)
    @Getter
    @Setter
    private String kraj;
    @Column(name = "Drzava", nullable = false)
    @Getter
    @Setter
    private String drzava;

    public Trener() {

    }

    public Trener(int idTrener, String upoIme, String geslo, String ime, String priimek, String email, int spol, LocalDate datumRojstva, int telefon, LocalDate datumVpisa, String kraj, String drzava) {
        this.idTrener = idTrener;
        this.upoIme = upoIme;
        this.geslo = geslo;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.spol = spol;
        this.datumRojstva = datumRojstva;
        this.telefon = telefon;
        this.datumVpisa = datumVpisa;
        this.kraj = kraj;
        this.drzava = drzava;
    }
}
