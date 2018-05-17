package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
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
    @Column(name = "Opis", nullable = false)
    @Getter
    @Setter
    private String opis;
    @Column(name = "Spol", nullable = false)
    @Getter
    @Setter
    private int spol;
    @Column(name = "TkIdOseba")
    @Getter
    @Setter
    private int tkIdOseba;
    @Column(name = "TkIdTipPrograma")
    @Getter
    @Setter
    private int tkIdTipPrograma;

    public Program() {

    }

    public Program(int idProgram, String naziv, int casTrajanja, int tezavnost, int spol, int tkIdOseba, int tkIdTipPrograma) {
        this.idProgram = idProgram;
        this.naziv = naziv;
        this.casTrajanja = casTrajanja;
        this.tezavnost = tezavnost;
        this.spol = spol;
        this.tkIdOseba = tkIdOseba;
        this.tkIdTipPrograma = tkIdTipPrograma;
    }
}
