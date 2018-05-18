package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Znacka")
@Table(name = "Znacka")
public class Znacka implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdZnacka")
    @Getter
    @Setter
    private int idZnacka;
    @Column(name = "Naziv", nullable = false)
    @Getter
    @Setter
    private String naziv;

    public Znacka() {

    }

    public Znacka(int idZnacka, String naziv) {
        this.idZnacka = idZnacka;
        this.naziv = naziv;
    }
}
