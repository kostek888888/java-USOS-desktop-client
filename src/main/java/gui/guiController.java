package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class guiController {

	

	
    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passTextField;

    
    @FXML
    void loginButtonClick(MouseEvent event) {
    	if("login".equals(loginTextField.getText())     &&    "haslo".equals(passTextField.getText()) )
    	{
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("Success Login");

    		alert.showAndWait();
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.WARNING);
    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("Wrong Login or Password");

    		alert.showAndWait();
    	}  	
    }
    
    
    @FXML
    void enterPressed(KeyEvent key)
    {
    		  if (key.getCode().equals(KeyCode.ENTER))
              {
    			  if("login".equals(loginTextField.getText())     &&    "haslo".equals(passTextField.getText()) )
    		    	{
    		    		Alert alert = new Alert(AlertType.INFORMATION);
    		    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		    		alert.setTitle("Information Dialog");
    		    		alert.setHeaderText(null);
    		    		alert.setContentText("Success Login");
    		    		alert.showAndWait();
    		    	}
    		    	else
    		    		{
	    		    		Alert alert = new Alert(AlertType.WARNING);
	    		    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    		    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
	    		    		alert.setTitle("Information Dialog");
	    		    		alert.setHeaderText(null);
	    		    		alert.setContentText("Wrong Login or Password");
	
	    		    		alert.showAndWait();
    		    		}  	
 
              }
    }
	

}
