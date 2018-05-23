package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idProgram;
    @Column(nullable = false, name = "Naziv")
    @Getter
    @Setter
    private String naziv;
    @Column(nullable = false, name = "Opis")
    @Getter
    @Setter
    private String opis;
    @Column(nullable = false, name = "Intenzivnost")
    @Getter
    @Setter
    private int intenzivnost;
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Oseba oseba;
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Trener trener;

    public Program() {
    }

    public Program(String naziv, String opis, int intenzivnost, Oseba oseba, Trener trener) {
        this.naziv = naziv;
        this.opis = opis;
        this.intenzivnost = intenzivnost;
        this.oseba = oseba;
        this.trener = trener;
    }
}
