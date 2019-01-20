package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.org.apache.bcel.internal.classfile.Constant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Constants;

public class PlaceInfoController implements Initializable {

    @FXML
    private Label nazwa;
    @FXML
    private Label telefon;
    @FXML
    private Label mail;



    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void createAccButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/pracownikStworzKonto.fxml"));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }
    
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void existingAccButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/pracownikAkcjaNaKoncie.fxml"));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void addEmployeeButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/pracownikDodajPracownika.fxml"));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void editButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nazwa.setText(Constants.bank.getNazwa());
        telefon.setText(Constants.bank.getTelefon());
        mail.setText(Constants.bank.getEmail());
    }
}
