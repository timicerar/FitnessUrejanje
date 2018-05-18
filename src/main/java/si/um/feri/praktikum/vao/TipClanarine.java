package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TipClanarine")
@Table(name = "TipClanarine")
public class TipClanarine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipClanarine")
    @Getter
    @Setter
    private int idTipClanarine;
    @Column(name = "Naziv", nullable = false)
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
