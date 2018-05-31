package si.um.feri.praktikum.jsf.vadbe;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;
import si.um.feri.praktikum.vao.Vadba;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@ManagedBean(name = "vadbaBean")
@SessionScoped
public class VadbaBean {

    @Getter
    @Setter
    private Vadba novaVadba = new Vadba();
    @Getter
    @Setter
    private String znacke;
    @Getter
    @Setter
    private UploadedFile file;

    public void dodajVadbo() throws IOException {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        if (novaVadba.getVideo().matches(regex)) {
            if (file != null) {
                if(file.getFileName().endsWith(".jpg") || file.getFileName().endsWith(".png")) {
                    if (file.getSize() < 250000000) {
                        /*InputStream input = file.getInputstream();
                        Path folder = Paths.get("C:\\Users\\timic\\IdeaProjects\\FitnessUrejanje\\web\\slike");
                        String filename = FilenameUtils.getBaseName(file.getFileName());
                        String extension = FilenameUtils.getExtension(file.getFileName());
                        Path file = Files.createTempFile(folder, filename, extension);*/
                    } else {
                        errorSlikaVelikost();
                    }
                } else {
                    errorSlikaKoncnica();
                }
            } else {
                novaVadba = new Vadba();
                znacke = "";
                errorSlikaNull();
            }
        } else {
            novaVadba = new Vadba();
            znacke = "";
            errorVideo();
        }
    }

    private void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Program s takšnim nazivom že obstaja!"));
    }

    private void errorSlikaNull() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Izberite sliko!"));
    }

    private void errorSlikaKoncnica() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Uporabite lahko format .jpg ali .png!"));
    }

    private void errorSlikaVelikost() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Slika je prevelika!"));
    }

    private void errorVideo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Vpišite ustrezen URL!"));
    }

    private void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Program je bil uspešno dodan v sistem."));
    }

}
