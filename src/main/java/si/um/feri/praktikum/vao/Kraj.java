package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Kraj implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdKraj")
    @Getter
    @Setter
    private int idKraj;
    @Column(name = "Naziv", nullable = false)
    @Getter
    @Setter
    private String naziv;
    @Column(name = "TkIdDrzava")
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
