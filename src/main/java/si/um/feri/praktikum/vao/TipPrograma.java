package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TipPrograma")
@Table(name = "TipPrograma")
public class TipPrograma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipPrograma")
    @Getter
    @Setter
    private int idTipPrograma;
    @Column(name = "Naziv", nullable = false)
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
