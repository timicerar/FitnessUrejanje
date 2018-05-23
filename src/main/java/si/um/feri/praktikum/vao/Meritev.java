package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Meritev")
public class Meritev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idMeritev;
    @Column(nullable = false, name = "Teza")
    @Getter
    @Setter
    private double teza;
    @Column(nullable = false, name = "Visina")
    @Getter
    @Setter
    private double visina;
    @Column(nullable = false, name = "Obseg_pasu")
    @Getter
    @Setter
    private double obsegPasu;
    @Column(nullable = false, name = "Datum_vpisa")
    @Getter
    @Setter
    private LocalDate datumVpisa;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Oseba oseba;

    public Meritev() {
    }

    public Meritev(double teza, double visina, double obsegPasu, LocalDate datumVpisa, Oseba oseba) {
        this.teza = teza;
        this.visina = visina;
        this.obsegPasu = obsegPasu;
        this.datumVpisa = datumVpisa;
        this.oseba = oseba;
    }
}
