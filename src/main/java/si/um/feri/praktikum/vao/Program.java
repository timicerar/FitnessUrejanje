package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Program")
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
    @Column(nullable = false, name = "Opis", length = 10000)
    @Getter
    @Setter
    private String opis;
    @Column(nullable = false, name = "Intenzivnost", length = 10000)
    @Getter
    @Setter
    private int intenzivnost;
    @ManyToMany(targetEntity = Oseba.class, fetch = FetchType.EAGER)
    @Getter
    @Setter
    private List<Oseba> tkIdOseba;
    @ManyToMany(targetEntity = Vadba.class, fetch = FetchType.LAZY, mappedBy = "tkIdProgram")
    @Getter
    @Setter
    private List<Vadba> tkIdVadba;

    public Program() {

    }

    public Program(int idProgram, String naziv, String opis, int intenzivnost, List<Oseba> tkIdOseba, List<Vadba> tkIdVadba) {
        this.idProgram = idProgram;
        this.naziv = naziv;
        this.opis = opis;
        this.intenzivnost = intenzivnost;
        this.tkIdOseba = tkIdOseba;
        this.tkIdVadba = tkIdVadba;
    }
}
