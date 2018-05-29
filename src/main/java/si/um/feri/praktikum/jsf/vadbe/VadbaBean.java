package si.um.feri.praktikum.jsf.vadbe;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import si.um.feri.praktikum.vao.Vadba;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

    public void dodajVadba() {
        System.out.println("Dodajanje vadbe...");
        System.out.println(novaVadba.getOpis());
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        System.out.println(event.getFile().getFileName() + " asd");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
