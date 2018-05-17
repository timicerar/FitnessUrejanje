package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

public class TipClanarine {
    @Getter
    @Setter
    private int idTipClanarine;
    @Getter
    @Setter
    private String naziv;

    public TipClanarine() {
    }

    public TipClanarine(int idTipClanarine, String naziv) {
        this.idTipClanarine = idTipClanarine;
        this.naziv = naziv;
    }
}
