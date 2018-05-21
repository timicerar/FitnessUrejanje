package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @ManyToMany(targetEntity = Vadba.class, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<Vadba> tkIdVadba;

    public Znacka() {

    }

    public Znacka(int idZnacka, String naziv, List<Vadba> tkIdVadba) {
        this.idZnacka = idZnacka;
        this.naziv = naziv;
        this.tkIdVadba = tkIdVadba;
    }
}
