package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PlaceInfoController {
    
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
    protected void existingAccButtonAction(ActionEvent event) throws IOException{
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
    protected void editButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }

    
    
}
