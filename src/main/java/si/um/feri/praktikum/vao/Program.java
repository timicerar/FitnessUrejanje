package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Program {
    @Getter
    @Setter
    private int idProgram;
    @Getter
    @Setter
    private String naziv;
    @Getter
    @Setter
    private LocalDate datumZacetka;
    @Getter
    @Setter
    private int casTrajanja;
    @Getter
    @Setter
    private int tezavnost;
    @Getter
    @Setter
    private String nacinOgrevanja;
    @Getter
    @Setter
    private String nacinOhlajanja;
    @Getter
    @Setter
    private int spol;
    @Getter
    @Setter
    private int tkIdOseba;
    @Getter
    @Setter
    private int tkIdTippPrograma;

    public Program() {
    }

    public Program(int idProgram, String naziv, LocalDate datumZacetka, int casTrajanja, int tezavnost, String nacinOgrevanja, String nacinOhlajanja, int spol, int tkIdOseba, int tkIdTippPrograma) {
        this.idProgram = idProgram;
        this.naziv = naziv;
        this.datumZacetka = datumZacetka;
        this.casTrajanja = casTrajanja;
        this.tezavnost = tezavnost;
        this.nacinOgrevanja = nacinOgrevanja;
        this.nacinOhlajanja = nacinOhlajanja;
        this.spol = spol;
        this.tkIdOseba = tkIdOseba;
        this.tkIdTippPrograma = tkIdTippPrograma;
    }
}
