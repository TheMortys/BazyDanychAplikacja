package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddEmployeeController {
    

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
    protected void infoButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void addAccButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    }
    
}
