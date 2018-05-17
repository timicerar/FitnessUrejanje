package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Drzava implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDrzava")
    @Getter
    @Setter
    private int idDrzava;
    @Column(name = "Naziv", nullable = false)
    @Getter
    @Setter
    private String naziv;

    public Drzava() {

    }

    public Drzava(int idDrzava, String naziv) {
        this.idDrzava = idDrzava;
        this.naziv = naziv;
    }
}
