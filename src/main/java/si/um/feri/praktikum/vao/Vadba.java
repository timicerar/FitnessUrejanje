package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Vadba")
@Table(name = "Vadba")
public class Vadba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idVadba;
    @Column(nullable = false, name = "Naziv")
    @Getter
    @Setter
    private String naziv;
    @Column(nullable = false, name = "Opis", length = 10000)
    @Getter
    @Setter
    private String opis;
    @Column(nullable = false, name = "Video", length = 3000)
    @Getter
    @Setter
    private String video;
    @Column(nullable = false, name = "Slika", length = 500)
    @Getter
    @Setter
    private String slika;
    @Column(nullable = false, name = "TipVadbe")
    @Getter
    @Setter
    private String tipVadbe;
    @ManyToMany(targetEntity = Program.class, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<Program> tkIdProgram;

    public Vadba() {

    }

    public Vadba(int idVadba, String naziv, String opis, String video, String slika, String tipVadbe, List<Program> tkIdProgram) {
        this.idVadba = idVadba;
        this.naziv = naziv;
        this.opis = opis;
        this.video = video;
        this.slika = slika;
        this.tipVadbe = tipVadbe;
        this.tkIdProgram = tkIdProgram;
    }
}
