package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Program")
@Table(name = "Program")
public class Program implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProgram")
    @Getter
    @Setter
    private int idProgram;
    @Column(name = "Naziv", nullable = false)
    @Getter
    @Setter
    private String naziv;
    @Column(name = "CasTrajanja", nullable = false)
    @Getter
    @Setter
    private int casTrajanja;
    @Column(name = "Tezavnost", nullable = false)
    @Getter
    @Setter
    private int tezavnost;
    @Column(name = "Opis", nullable = false, length = 10000)
    @Getter
    @Setter
    private String opis;
    @Column(name = "Spol", nullable = false)
    @Getter
    @Setter
    private int spol;

    public Program() {

    }

    public Program(int idProgram, String naziv, int casTrajanja, int tezavnost, int spol) {
        this.idProgram = idProgram;
        this.naziv = naziv;
        this.casTrajanja = casTrajanja;
        this.tezavnost = tezavnost;
        this.spol = spol;
    }
}
