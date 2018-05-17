package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

public class TipPrograma {
    @Getter
    @Setter
    private int idTipPrograma;
    @Getter
    @Setter
    private String naziv;

    public TipPrograma() {
    }

    public TipPrograma(int idTipPrograma, String naziv) {
        this.idTipPrograma = idTipPrograma;
        this.naziv = naziv;
    }
}
