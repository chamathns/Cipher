package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    JFXTextField txtEncryptFile, txtDecryptFile;
    @FXML
    JFXButton btnEncrypt, btnDecrypt;
    @FXML
    AnchorPane paneEncrypt, paneDecrypt;

    private boolean mode;
    public static String filePath;

    @FXML
    public void handlePane(MouseEvent event){
        if (event.getSource()==btnEncrypt){
            paneEncrypt.toFront();
            mode = false;
            System.out.println(mode);


        } else if (event.getSource()==btnDecrypt){
            paneDecrypt.toFront();
            mode = true;
            System.out.println(mode);
        }
    }

    public void filePicker(ActionEvent e){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\"));
        if (mode){
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("text files","*.txt"));
            File selectedFile = fc.showOpenDialog(null);
            if(selectedFile != null){
                    txtDecryptFile.setText(selectedFile.getAbsolutePath());
                    filePath = txtDecryptFile.getText().trim();
                System.out.println(filePath);
            }else {
//            System.out.println("File is not valid");
            }

        }else {
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("text files","*.txt"));
            File selectedFile = fc.showOpenDialog(null);

            if(selectedFile != null){
                txtEncryptFile.setText(selectedFile.getAbsolutePath());
                filePath = txtEncryptFile.getText().trim();
                System.out.println(filePath);
            }else {
//            System.out.println("File is not valid");
            }
        }
    }
    public void handleEncrypt(ActionEvent event) throws IOException {
        try {
            FileController.fileReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
}
