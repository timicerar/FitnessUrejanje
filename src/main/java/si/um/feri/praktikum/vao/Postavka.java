package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Postavka")
public class Postavka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idPostavka;
    @Column(nullable = false, name = "Tip_postavke")
    @Getter
    @Setter
    private int tipPostavke;
    @Column(nullable = false, name = "Zaporedna_stevilka")
    @Getter
    @Setter
    private int zaporednaSt;
    @Column(nullable = false, name = "Stevilo_serij")
    @Getter
    @Setter
    private int steviloSerij;
    @Column(nullable = false, name = "Stevilo_ponovitev")
    @Getter
    @Setter
    private int steviloPonovitev;
    @Column(name = "Trajanje")
    @Getter
    @Setter
    private String trajanje;
    @Column(name = "Teza")
    @Getter
    @Setter
    private double teza;
    @Column(nullable = false, name = "Tezavnost")
    @Getter
    @Setter
    private int tezavnost;
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Dan dan;
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Vadba vadba;

    public Postavka() {
    }

    public Postavka(int tipPostavke, int zaporednaSt, int steviloSerij, int steviloPonovitev, String trajanje, double teza, int tezavnost, Dan dan, Vadba vadba) {
        this.tipPostavke = tipPostavke;
        this.zaporednaSt = zaporednaSt;
        this.steviloSerij = steviloSerij;
        this.steviloPonovitev = steviloPonovitev;
        this.trajanje = trajanje;
        this.teza = teza;
        this.tezavnost = tezavnost;
        this.dan = dan;
        this.vadba = vadba;
    }
}
