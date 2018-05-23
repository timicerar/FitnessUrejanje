package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
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
    @Column(name = "Komentar")
    @Getter
    @Setter
    private String komentar;
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Program program;

    public Dan() {
    }

    public Dan(String naziv, String komentar, Program program) {
        this.naziv = naziv;
        this.komentar = komentar;
        this.program = program;
    }
}
