package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

public class TipOsebe {
    @Getter
    @Setter
    private int idTipOsebe;
    @Getter
    @Setter
    private String naziv;

    public TipOsebe() {
    }

    public TipOsebe(int idTipOsebe, String naziv) {
        this.idTipOsebe = idTipOsebe;
        this.naziv = naziv;
    }
}
