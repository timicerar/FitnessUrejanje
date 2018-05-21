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
    @Column(name = "IdVadba")
    @Getter
    @Setter
    private int idVadba;
    @Column(name = "Naziv", nullable = false)
    @Getter
    @Setter
    private String naziv;
    @Column(name = "Opis", nullable = false, length = 10000)
    @Getter
    @Setter
    private String opis;
    @Column(name = "SteviloIzvedb", nullable = false)
    @Getter
    @Setter
    private int steviloIzvedb;
    @Column(name = "SteviloPonovitev", nullable = false)
    @Getter
    @Setter
    private int steviloPonovitev;
    @Column(name = "Tezavnost", nullable = false)
    @Getter
    @Setter
    private int tezavnost;
    @Column(name = "Video", nullable = false)
    @Getter
    @Setter
    private String video;
    @Column(name = "Slika", nullable = false)
    @Getter
    @Setter
    private String slika;
    @ManyToOne(targetEntity = TipVadbe.class, fetch = FetchType.EAGER)
    @Getter
    @Setter
    private int tkIdTipVadbe;
    @ManyToOne(targetEntity = Program.class, fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Program tkIdProgram;
    @ManyToMany(targetEntity = Oseba.class, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<Oseba> tkIdOseba;
    @ManyToOne(targetEntity = Trener.class, fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Trener tkIdTrener;
    @ManyToMany(targetEntity = Znacka.class, fetch = FetchType.EAGER, mappedBy = "tkIdVadba")
    @Getter
    @Setter
    private List<Znacka> tkIdZnacka;

    public Vadba() {

    }

    public Vadba(int idVadba, String naziv, String opis, int steviloIzvedb, int steviloPonovitev, int tezavnost, String video, String slika, int tkIdTipVadbe, Program tkIdProgram, List<Oseba> tkIdOseba, Trener tkIdTrener, List<Znacka> tkIdZnacka) {
        this.idVadba = idVadba;
        this.naziv = naziv;
        this.opis = opis;
        this.steviloIzvedb = steviloIzvedb;
        this.steviloPonovitev = steviloPonovitev;
        this.tezavnost = tezavnost;
        this.video = video;
        this.slika = slika;
        this.tkIdTipVadbe = tkIdTipVadbe;
        this.tkIdProgram = tkIdProgram;
        this.tkIdOseba = tkIdOseba;
        this.tkIdTrener = tkIdTrener;
        this.tkIdZnacka = tkIdZnacka;
    }
}
