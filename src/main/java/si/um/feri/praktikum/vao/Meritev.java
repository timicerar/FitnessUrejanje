package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "Meritev")
@Table(name = "Meritev")
public class Meritev implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMeritev")
    @Getter
    @Setter
    private int idMeritev;
    @Column(name = "Visina", nullable = false)
    @Getter
    @Setter
    private double visina;
    @Column(name = "Teza", nullable = false)
    @Getter
    @Setter
    private double teza;
    @Column(name = "ObsegPasu", nullable = false)
    @Getter
    @Setter
    private double obsegPasu;
    @Column(name = "DatumVpisa", nullable = false)
    @Getter
    @Setter
    private LocalDate datumVpisa;
    @ManyToOne(targetEntity = Oseba.class, fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Oseba tkIdOseba;

    public Meritev() {
    }

    public Meritev(int idMeritev, double visina, double teza, double obsegPasu, LocalDate datumVpisa, Oseba tkIdOseba) {
        this.idMeritev = idMeritev;
        this.visina = visina;
        this.teza = teza;
        this.obsegPasu = obsegPasu;
        this.datumVpisa = datumVpisa;
        this.tkIdOseba = tkIdOseba;
    }


}
