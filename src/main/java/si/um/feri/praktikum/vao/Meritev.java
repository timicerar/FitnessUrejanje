package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Meritev {
    @Getter
    @Setter
    private int idMeritev;
    @Getter
    @Setter
    private double visina;
    @Getter
    @Setter
    private double teza;
    @Getter
    @Setter
    private double obsegPasu;
    @Getter
    @Setter
    private LocalDate datumVpisa;
    @Getter
    @Setter
    private int tkIdOseba;

    public Meritev() {
    }

    public Meritev(int idMeritev, double visina, double teza, double obsegPasu, LocalDate datumVpisa, int tkIdOseba) {
        this.idMeritev = idMeritev;
        this.visina = visina;
        this.teza = teza;
        this.obsegPasu = obsegPasu;
        this.datumVpisa = datumVpisa;
        this.tkIdOseba = tkIdOseba;
    }
}
