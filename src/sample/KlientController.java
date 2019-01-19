package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class KlientController {
    
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
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void historyButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void loanButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void investmentButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }
    
}
