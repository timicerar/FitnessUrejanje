package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

public class Kraj {
    @Getter
    @Setter
    private int idKraj;
    @Getter
    @Setter
    private String naziv;
    @Getter
    @Setter
    private int tkIdDrzava;

    public Kraj() {
    }

    public Kraj(int idKraj, String naziv, int tkIdDrzava) {
        this.idKraj = idKraj;
        this.naziv = naziv;
        this.tkIdDrzava = tkIdDrzava;
    }
}
