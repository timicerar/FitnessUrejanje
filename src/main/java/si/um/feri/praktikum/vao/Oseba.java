package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "Oseba")
@Table(name = "Oseba")
public class Oseba implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdOseba")
    @Getter
    @Setter
    private int idOseba;
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
    @Column(name = "TkIdTipOsebe")
    @Getter
    @Setter
    private int tkIdTipOsebe;
    @Column(name = "TkIdTipClanarine")
    @Getter
    @Setter
    private int tkIdTipClanarine;

    public Oseba() {

    }

    public Oseba(int idOseba, String ime, String priimek, String email, int spol, LocalDate datumRojstva, int telefon, LocalDate datumVpisa, String kraj, String drzava, int tkIdTipOsebe, int tkIdTipClanarine) {
        this.idOseba = idOseba;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.spol = spol;
        this.datumRojstva = datumRojstva;
        this.telefon = telefon;
        this.datumVpisa = datumVpisa;
        this.kraj = kraj;
        this.drzava = drzava;
        this.tkIdTipOsebe = tkIdTipOsebe;
        this.tkIdTipClanarine = tkIdTipClanarine;
    }
}
