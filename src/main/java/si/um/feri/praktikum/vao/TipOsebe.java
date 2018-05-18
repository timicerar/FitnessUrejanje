package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TipOsebe")
@Table(name = "TipOsebe")
public class TipOsebe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipOsebe")
    @Getter
    @Setter
    private int idTipOsebe;
    @Column(name = "Naziv", nullable = false)
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
