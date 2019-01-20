package sample.Controllers;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.*;

public class LoginController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    @FXML
    protected void handleClientButtonAction(ActionEvent event){
        System.out.println(event.getSource().toString());
        //TODO client / pracownik
        Server.getInstance().getRoute().clientLogin(new LoginRequest(loginField.getText(), passwordField.getText()))
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Client>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        //DISPOSABLE
                    }

                    @Override
                    public void onNext(Client client) {

                        Constants.CLIENT_AUTH_TOKEN = client.getAuthToken();
                        downloadClientProfile();
                        Platform.runLater(() -> {
                            //TODO tutaj mamy authToken
                            Parent viewParent = null;
                            try {
                                viewParent = FXMLLoader.load(getClass().getResource("FXMLs/klientDaneKonta.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Scene viewScene = new Scene(viewParent);
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            window.setScene(viewScene);
                            window.show();
                        });
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.toString());
                        errorLabel.setVisible(true);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void downloadClientProfile() {
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
    }

    private void downloadBankProfile() {
        Server.getInstance().getRoute().getBank("Bearer " + Constants.WORKER_AUTH_TOKEN)
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Bank>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(Bank bank) {
                        //System.out.println(clientProfile.toString());
                        Constants.bank = bank;
                        System.out.println(Constants.bank);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event){
        System.out.println(event.getSource().toString());


    	//TODO client / pracownik
        Server.getInstance().getRoute().workerLogin(new LoginRequest(loginField.getText(), passwordField.getText()))
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Worker>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        //DISPOSABLE
                    }

                    @Override
                    public void onNext(Worker worker) {
                        // ...
                        Constants.WORKER_AUTH_TOKEN = worker.getAuthToken();
                        downloadBankProfile();
                        Platform.runLater(() -> {
                            //TODO tutaj mamy authToken
                            Parent viewParent = null;
                            try {
                                viewParent = FXMLLoader.load(getClass().getResource("FXMLs/pracownikStworzKonto.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Scene viewScene = new Scene(viewParent);
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            window.setScene(viewScene);
                            window.show();
                        });
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.toString());
                        errorLabel.setVisible(true);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
