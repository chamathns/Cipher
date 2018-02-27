package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.FileController.everything;

public class Controller implements Initializable{
    @FXML
    JFXTextField txtEncryptFile, txtDecryptFile;
    @FXML
    JFXPasswordField secretKeyEncrypt, secretKeyDecrypt;
    @FXML
    JFXButton btnEncrypt, btnEncryptPane, btnDecryptPane;
    @FXML
    AnchorPane paneEncrypt, paneDecrypt;

    private boolean mode;
    public static String filePath;
    public File selectedFile;
    private String encryptedValue,decryptedValue;
//    Substitution substitution = new Substitution();
//    Permutation permutation = new Permutation();

    @FXML
    public void handlePane(MouseEvent event){
        if (event.getSource()==btnEncryptPane){
            paneEncrypt.toFront();
            mode = false;

        } else if (event.getSource()==btnDecryptPane){
            paneDecrypt.toFront();
            mode = true;
        }
    }

    public void filePicker(ActionEvent e){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\"));
        if (mode){
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("text files","*.txt"));
            selectedFile = fc.showOpenDialog(null);
            if(selectedFile != null){
                    txtDecryptFile.setText(selectedFile.getAbsolutePath());
                    filePath = txtDecryptFile.getText().trim();
                System.out.println(filePath);
            }else {
//            System.out.println("File is not valid");
            }

        }else if (!mode){
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("text files","*.txt"));
            selectedFile = fc.showOpenDialog(null);

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
            FileController.fileReader(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String secretKey = secretKeyEncrypt.getText().trim();
        encryptedValue = Permutation.getInstance().getEncryptPermutation(Substitution.getInstance().getEncryptSubstitution(everything,secretKey),secretKey);

        try {
            FileController.fileWriter("C:\\data\\savedText.txt",encryptedValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleDecrypt(ActionEvent event) throws IOException {
        try {
            FileController.fileReader(filePath);
        }catch (IOException e){
            e.printStackTrace();
        }
        String secretKey = secretKeyDecrypt.getText().trim();
        System.out.println(secretKey);
        decryptedValue = Substitution.getInstance().getDecryptSubstitution(Permutation.getInstance().getDecryptPermutation(everything,secretKey),secretKey);

        System.out.println(decryptedValue);

        try {
            FileController.fileWriter("C:\\data\\savedText.txt",decryptedValue);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
