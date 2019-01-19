package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ActionOnAccController {
    
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void createAccButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }
    
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void addEmployeeButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void infoButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }

    
    
     /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void searchButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }
    
}
