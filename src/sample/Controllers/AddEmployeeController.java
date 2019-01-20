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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.*;

public class AddEmployeeController {

    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField telefon;
    @FXML
    private TextField email;
    @FXML
    private TextField stanowisko;
    @FXML
    private TextField login;
    @FXML
    private TextField haslo;
    @FXML
    private Label errorLabel;

    public TextField getImie() {
        return imie;
    }

    public void setImie(TextField imie) {
        this.imie = imie;
    }

    public TextField getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(TextField nazwisko) {
        this.nazwisko = nazwisko;
    }

    public TextField getTelefon() {
        return telefon;
    }

    public void setTelefon(TextField telefon) {
        this.telefon = telefon;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(TextField stanowisko) {
        this.stanowisko = stanowisko;
    }

    public TextField getLogin() {
        return login;
    }

    public void setLogin(TextField login) {
        this.login = login;
    }

    public TextField getHaslo() {
        return haslo;
    }

    public void setHaslo(TextField haslo) {
        this.haslo = haslo;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(Label errorLabel) {
        this.errorLabel = errorLabel;
    }

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
    protected void addAccButtonAction(ActionEvent event){
        System.out.println(event.getSource().toString());
        Server.getInstance().getRoute().addWorker("Bearer " + Constants.WORKER_AUTH_TOKEN, new Worker(imie.getText(), nazwisko.getText(), login.getText(), haslo.getText(), email.getText(), stanowisko.getText(), telefon.getText()))
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
