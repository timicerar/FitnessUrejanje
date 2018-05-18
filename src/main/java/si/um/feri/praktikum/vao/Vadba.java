package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @Column(name = "TkIdTipVadbe")
    @Getter
    @Setter
    private int tkIdTipVadbe;
    @Column(name = "TkIdProgram")
    @Getter
    @Setter
    private int tkIdProgram;
    @Column(name = "TkIdOseba")
    @Getter
    @Setter
    private int tkIdOseba;

    public Vadba() {

    }

    public Vadba(int idVadba, String naziv, String opis, int steviloIzvedb, int steviloPonovitev, int tezavnost, String video, String slika, int tkIdTipVadbe, int tkIdProgram, int tkIdOseba) {
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
    }
}
