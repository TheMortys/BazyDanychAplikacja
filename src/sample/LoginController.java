package sample;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    protected void handleClientButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("klientDaneKonta.fxml"));
        Scene viewScene = new Scene(viewParent);
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
                        // ...
                        Platform.runLater(() -> {
                            //TODO tutaj mamy authToken
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
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    	Parent viewParent = FXMLLoader.load(getClass().getResource("pracownikStworzKonto.fxml"));
    	Scene viewScene = new Scene(viewParent);

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
                        Platform.runLater(() -> {
                            //TODO tutaj mamy authToken
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
