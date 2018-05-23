package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Dan")
@Table(name = "Dan")
public class Dan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idDan;
    @Column(nullable = false, name = "Naziv")
    @Getter
    @Setter
    private String naziv;
    @Column(name = "Opis")
    @Getter
    @Setter
    private String opis;
    @ManyToOne(targetEntity = Program.class, fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Program tkIdProgram;

    public Dan() {

    }

    public Dan(int idDan, String naziv, String opis, Program tkIdProgram) {
        this.idDan = idDan;
        this.naziv = naziv;
        this.opis = opis;
        this.tkIdProgram = tkIdProgram;
    }
}
