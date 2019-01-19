package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException{
        System.out.println(event.getSource().toString());
    	Parent viewParent = FXMLLoader.load(getClass().getResource("klientDaneKonta.fxml"));
    	Scene viewScene = new Scene(viewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(viewScene);
    	window.show();
    }
    
}
