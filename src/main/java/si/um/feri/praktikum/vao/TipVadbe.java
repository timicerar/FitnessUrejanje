package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TipVadbe")
@Table(name = "TipVadbe")
public class TipVadbe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipVadbe")
    @Getter
    @Setter
    private int idTipVadbe;
    @Column(name = "Naziv", nullable = false)
    @Getter
    @Setter
    private String naziv;

    public TipVadbe() {
    }

    public TipVadbe(int idTipVadbe, String naziv) {
        this.idTipVadbe = idTipVadbe;
        this.naziv = naziv;
    }
}
