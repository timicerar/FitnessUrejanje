package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Oseba {

    @Getter
    @Setter
    private String idOseba;
    @Getter
    @Setter
    private String ime;
    @Getter
    @Setter
    private String priimek;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private int spol;
    @Getter
    @Setter
    private LocalDate datumRojstva;
    @Getter
    @Setter
    private int telefon;
    @Getter
    @Setter
    private LocalDateTime datumVpisa;
    @Getter
    @Setter
    private int tkIdKraj;
    @Getter
    @Setter
    private int tkIdTipOsebe;
    @Getter
    @Setter
    private int tkIdTipClanarine;

    public Oseba() {

    }

    public Oseba(String idOseba, String ime, String priimek, String email, int spol, LocalDate datumRojstva, int telefon, LocalDateTime datumVpisa, int tkIdKraj, int tkIdTipOsebe, int tkIdTipClanarine) {
        this.idOseba = idOseba;
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.spol = spol;
        this.datumRojstva = datumRojstva;
        this.telefon = telefon;
        this.datumVpisa = datumVpisa;
        this.tkIdKraj = tkIdKraj;
        this.tkIdTipOsebe = tkIdTipOsebe;
        this.tkIdTipClanarine = tkIdTipClanarine;
    }

}
