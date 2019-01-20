package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Constants;

public class KlientController implements Initializable{

    @FXML
    private Label imie;
    @FXML
    private Label nazwisko;
    @FXML
    private Label pesel;
    @FXML
    private Label nip;
    @FXML
    private Label dataurodzenia;
    @FXML
    private Label ulica;
    @FXML
    private Label numerdomu;
    @FXML
    private Label numerlokalu;
    @FXML
    private Label kodpocztowy;
    @FXML
    private Label miejscowosc;
    @FXML
    private Label telefon;
    @FXML
    private Label email;
    @FXML
    private Label person;
    @FXML
    private Label saldo;
    @FXML
    private Label numerkonta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        person.setText(Constants.client.getName() + " " + Constants.client.getLastName());
        imie.setText(Constants.client.getName());
        nazwisko.setText(Constants.client.getLastName());
        pesel.setText(Constants.client.getPesel());
        nip.setText(Constants.client.getNip());
        dataurodzenia.setText(Constants.client.getDate());
        ulica.setText(Constants.client.getAdress().getUlica());
        numerdomu.setText(Integer.toString(Constants.client.getAdress().getNumerDomu()));
        numerlokalu.setText(Integer.toString(Constants.client.getAdress().getNumerLokalu()));
        kodpocztowy.setText(Constants.client.getAdress().getKodPocztowy());
        miejscowosc.setText(Constants.client.getAdress().getMiejscowosc());
        telefon.setText(Integer.toString(Constants.client.getTelephone()));
        email.setText(Constants.client.getMail());
        saldo.setText(Float.toString(Constants.client.getAccounts().get(0).getSaldo()));
        numerkonta.setText(Constants.client.getAccounts().get(0).getNumer());
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

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void transactionButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/klientNowaTransakcja.fxml"));
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
    protected void historyButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/klientHistoria.fxml"));
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
    protected void loanButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/klientPozyczka.fxml"));
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
    protected void investmentButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/klientLokaty.fxml"));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }
}
