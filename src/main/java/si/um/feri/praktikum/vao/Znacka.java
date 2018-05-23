package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Znacka")
public class Znacka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idZnacka;
    @Column(nullable = false, name = "Naziv")
    @Getter
    @Setter
    private String naziv;
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Vadba vadba;

    public Znacka() {
    }

    public Znacka(String naziv, Vadba vadba) {
        this.naziv = naziv;
        this.vadba = vadba;
    }
}
