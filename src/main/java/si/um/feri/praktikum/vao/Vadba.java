package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

public class Vadba {
    @Getter
    @Setter
    private int idVadba;
    @Getter
    @Setter
    private String naziv;
    @Getter
    @Setter
    private String opis;
    @Getter
    @Setter
    private int steviloIzvedb;
    @Getter
    @Setter
    private int steviloPonovitev;
    @Getter
    @Setter
    private int tezavnost;
    @Getter
    @Setter
    private String video;
    @Getter
    @Setter
    private String slika;
    @Getter
    @Setter
    private int tkIdProgram;

    public Vadba() {
    }

    public Vadba(int idVadba, String naziv, String opis, int steviloIzvedb, int steviloPonovitev, int tezavnost, String video, String slika, int tkIdProgram) {
        this.idVadba = idVadba;
        this.naziv = naziv;
        this.opis = opis;
        this.steviloIzvedb = steviloIzvedb;
        this.steviloPonovitev = steviloPonovitev;
        this.tezavnost = tezavnost;
        this.video = video;
        this.slika = slika;
        this.tkIdProgram = tkIdProgram;
    }
}
