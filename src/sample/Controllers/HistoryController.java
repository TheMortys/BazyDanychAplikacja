package sample.Controllers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Bank;
import sample.Constants;
import sample.Server;
import sample.Transfer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

    @FXML
    private Label person;
    @FXML
    private Label saldo;
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
    protected void filterButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        person.setText(Constants.client.getName() + " " + Constants.client.getLastName());
        saldo.setText(Float.toString(Constants.client.getAccounts().get(0).getSaldo()));
        downloadHistory();
    }

    private void downloadHistory() {
        Server.getInstance().getRoute().getHistory("Bearer " + Constants.CLIENT_AUTH_TOKEN, Integer.toString(Constants.client.getId()))
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Transfer[]>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(Transfer[] transfers) {
                        System.out.println(transfers.toString());
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
