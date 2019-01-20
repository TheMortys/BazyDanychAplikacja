package sample.Controllers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransactionsController{
    @FXML
    private Label person;
    @FXML
    private Label saldo;
    @FXML
    private TextField dst;
    @FXML
    private TextField tytul;
    @FXML
    private TextField kwota;
    @FXML
    private DatePicker data;
    @FXML
    private Label errorLabel;

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

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void acceptButtonAction(ActionEvent event){
        System.out.println(event.getSource().toString());
        if (Constants.client.getAccounts().get(0).getSaldo() > Float.parseFloat(kwota.getText()) && Float.parseFloat(kwota.getText()) > 0f) {
            errorLabel.setVisible(false);
            Server.getInstance().getRoute().addTransfer("Bearer " + Constants.CLIENT_AUTH_TOKEN, new Transfer(dst.getText(), tytul.getText(), Float.parseFloat(kwota.getText()), data.getValue().toString()))
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<DefaultResponse>() {
                        @Override
                        public void onSubscribe(Disposable disposable) {

                        }

                        @Override
                        public void onNext(DefaultResponse defaultResponse) {
                            System.out.println(defaultResponse.getSuccess() + " wartosc");
                            Server.getInstance().getRoute().getClientProfile("Bearer " + Constants.CLIENT_AUTH_TOKEN)
                                    .subscribeOn(Schedulers.io())
                                    .subscribe(new Observer<ClientProfile>() {
                                        @Override
                                        public void onSubscribe(Disposable disposable) {

                                        }

                                        @Override
                                        public void onNext(ClientProfile clientProfile) {
                                            //System.out.println(clientProfile.toString());
                                            Constants.client = clientProfile;
                                            System.out.println(Constants.client);
                                        }

                                        @Override
                                        public void onError(Throwable throwable) {

                                        }

                                        @Override
                                        public void onComplete() {

                                        }
                                    });
                            saldo.setText(Float.toString(Constants.client.getAccounts().get(0).getSaldo()));
                        }

                        @Override
                        public void onError(Throwable throwable) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
        else errorLabel.setVisible(true);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void accInfoButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/klientDaneKonta.fxml"));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }

    public void initialize() {
        person.setText(Constants.client.getName() + " " + Constants.client.getLastName());
        saldo.setText(Float.toString(Constants.client.getAccounts().get(0).getSaldo()));
    }
}
