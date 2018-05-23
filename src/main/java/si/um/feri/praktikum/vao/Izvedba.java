package si.um.feri.praktikum.vao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Izvedba")
public class Izvedba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int idIzvedba;
    @Column(nullable = false, name = "Pocutje")
    @Getter
    @Setter
    private int pocutje;
    @Column(nullable = false, name = "Cas_izvedbe")
    @Getter
    @Setter
    private LocalDate casIzvedbe;
    @OneToOne(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Dan dan;

    public Izvedba() {
    }

}
