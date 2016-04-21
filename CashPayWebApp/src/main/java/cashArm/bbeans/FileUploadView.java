package cashArm.bbeans;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 25.08.14.
 */
@Named
public class FileUploadView {

        private UploadedFile file;

        public UploadedFile getFile() {
            return file;
        }

        public void setFile(UploadedFile file) {
            this.file = file;
        }

        public void upload() {
            if(file != null) {
                FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getFileName()));
            text = in.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    private String text;
    public String getText(){
        return text;
    }
}
