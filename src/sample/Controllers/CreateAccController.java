package sample.Controllers;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Client;
import sample.Constants;
import sample.DefaultResponse;
import sample.Server;

public class CreateAccController {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField pesel;
    @FXML
    private TextField nip;
    @FXML
    private TextField date;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private TextField street;
    @FXML
    private TextField adrNumber1;
    @FXML
    private TextField adrNumber2;
    @FXML
    private TextField zipCode;
    @FXML
    private TextField city;
    @FXML
    private TextField telephone;
    @FXML
    private TextField mail;


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
    protected void newEmployeeButtonAction(ActionEvent event) throws IOException{
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
    protected void infoButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLs/pracownikDanePlacowki.fxml"));
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
    protected void createAccButtonAction(ActionEvent event){
        System.out.println(event.getSource().toString());
        Server.getInstance().getRoute().addClient("Bearer " + Constants.WORKER_AUTH_TOKEN, new Client(name.getText(), surname.getText(), pesel.getText(), nip.getText(), date.getText(), login.getText(), password.getText(), street.getText(), adrNumber1.getText(), adrNumber2.getText(), zipCode.getText(), city.getText(), Integer.parseInt(telephone.getText()), mail.getText()))
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DefaultResponse>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(DefaultResponse defaultResponse) {
                        System.out.println(defaultResponse.getSuccess() + " wartosc");
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    
}
