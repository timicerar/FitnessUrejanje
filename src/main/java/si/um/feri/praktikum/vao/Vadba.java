package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
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
    @Column(nullable = false, name = "Opis")
    @Getter
    @Setter
    private String opis;
    @Column(nullable = false, name = "Video")
    @Getter
    @Setter
    private String video;
    @Column(nullable = false, name = "Slika")
    @Getter
    @Setter
    private String slika;
    @Column(nullable = false, name = "Tip_vadbe")
    @Getter
    @Setter
    private String tipVadbe;

    public Vadba() {
    }

    public Vadba(String naziv, String opis, String video, String slika, String tipVadbe) {
        this.naziv = naziv;
        this.opis = opis;
        this.video = video;
        this.slika = slika;
        this.tipVadbe = tipVadbe;
    }
}
