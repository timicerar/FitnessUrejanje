package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

public class Drzava {

    @Getter
    @Setter
    private int idDrzava;
    @Getter
    @Setter
    private String naziv;

    public Drzava() {
    }

    public Drzava(int idDrzava, String naziv) {
        this.idDrzava = idDrzava;
        this.naziv = naziv;
    }
}
