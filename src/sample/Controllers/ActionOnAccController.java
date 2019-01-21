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
import sample.*;

public class ActionOnAccController {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField pesel;
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
    protected void searchButtonAction(ActionEvent event){
        System.out.println(event.getSource().toString());
        Server.getInstance().getRoute().findProfile("Bearer " + Constants.WORKER_AUTH_TOKEN, name.getText(), surname.getText(), Integer.parseInt(pesel.getText()))
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ClientProfile>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(ClientProfile clientProfile) {
                        //System.out.println(clientProfile.toString());
                        Constants.findedClient = clientProfile;
                        System.out.println(Constants.findedClient);
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
