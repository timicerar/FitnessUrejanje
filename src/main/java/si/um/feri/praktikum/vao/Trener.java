package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Trener")
@Table(name = "Trener")
public class Trener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idTrener;
    @Column(nullable = false, name = "UporabniskoIme")
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
    @Column(nullable = false, name = "DatumVpisa")
    @Getter
    @Setter
    private Date datumVpisa;
    @Column(nullable = false, name = "DatumRojstva")
    @Getter
    @Setter
    private Date datumRojstva;
    @Column(nullable = false, name = "Telefon")
    @Getter
    @Setter
    private String telefon;

    public Trener() {
    }

    public Trener(int idTrener, String uporabniskoIme, String geslo, String ime, String priimek, String email, int spol, Date datumVpisa, Date datumRojstva, String telefon) {
        this.idTrener = idTrener;
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
