package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Trener")
public class Trener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idTrener;
    @Column(nullable = false, name = "Uporabnisko_ime")
    @Getter
    @Setter
    private String uporabniskoIme;
    @Column(nullable = false, name = "Geslo")
    @Getter
    @Setter
    private String geslo;
    @Column(nullable = false, name = "Ime")
    @Getter
    @Setter
    private String ime;
    @Column(nullable = false, name = "Priimek")
    @Getter
    @Setter
    private String priimek;
    @Column(nullable = false, name = "Email")
    @Getter
    @Setter
    private String email;
    @Column(nullable = false, name = "Spol")
    @Getter
    @Setter
    private int spol;
    @Column(nullable = false, name = "Datum_vpisa")
    @Getter
    @Setter
    private LocalDate datumVpisa;
    @Column(nullable = false, name = "Datum_rojstva")
    @Getter
    @Setter
    private LocalDate datumRojstva;
    @Column(nullable = false, name = "Telefon")
    @Getter
    @Setter
    private String telefon;

    public Trener() {
    }

    public Trener(String uporabniskoIme, String geslo, String ime, String priimek, String email, int spol, LocalDate datumVpisa, LocalDate datumRojstva, String telefon) {
        this.uporabniskoIme = uporabniskoIme;
        this.geslo = geslo;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.spol = spol;
        this.datumVpisa = datumVpisa;
        this.datumRojstva = datumRojstva;
        this.telefon = telefon;
    }
}
