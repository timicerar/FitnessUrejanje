package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

public class Znacka {

    @Getter
    @Setter
    private int idZnacka;
    @Getter
    @Setter
    private String naziv;

    public Znacka() {

    }

    public Znacka(int idZnacka, String naziv) {
        this.idZnacka = idZnacka;
        this.naziv = naziv;
    }
}
