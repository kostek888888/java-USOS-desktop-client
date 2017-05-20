package gui;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import usos.LoginInvalidCredentialsException;
import usos.LogoutException;
import usos.UsosManager;


public class MainController {

    @FXML
    private ImageView imageEnglishLanguage;
    
    @FXML
    private ImageView imagePolishLanguage;
    
	
    @FXML
    private Label loginLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button loginButton;
    
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passTextField;
    
   	@FXML
	private AnchorPane anchorPane;
   	
    @FXML
    private Button authorsButton;
   	
    private UsosStage getUsosStage() {
    	//FUSZERKA !!! @todo
    	return  (UsosStage) anchorPane.getScene().getWindow();
    }
    
    private UsosManager getUsosManager() {
    	//FUSZERKA !!! @todo
        return getUsosStage().getUsosManager();
    }
	
   
    @FXML
    private void loginButtonClick(MouseEvent event) throws IOException, SQLException, LogoutException  {
    	loginAction();
    }
    
   
    @FXML
   private void enterPressed(KeyEvent key) throws IOException, SQLException, LogoutException
    {
    	if (key.getCode().equals(KeyCode.ENTER)) {
    		loginAction();
    	}
    }
    
    private void loginAction() throws IOException {
    	UsosManager usosManager = getUsosManager();
    	
    	///tworzenie obiektow dla okienka dialogowego
    	Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
		alert.setHeaderText(null);
		
		usosManager.turnOnTestMode("http://31.178.72.165:8080/javaUSOSpskMock");    ///tryb testowy
		
		try {
			usosManager.login(loginTextField.getText(),passTextField.getText());    ///haslo musi byc qwerty
			
        	alert.setTitle(getUsosStage().getMsg("login.dialog.sussessTitle"));
        	alert.setContentText(getUsosStage().getMsg("login.dialog.sussessText"));
    		alert.showAndWait();
			
    		Home home = new Home();
        	home.start(this.getUsosStage());
        	
		} catch (LoginInvalidCredentialsException e) {
				
			alert.setTitle(getUsosStage().getMsg("login.dialog.failedTitle"));
        	alert.setContentText(getUsosStage().getMsg("login.dialog.failedText"));	

    		alert.showAndWait();   		
		}
    }
    
    @FXML
    void selectEnglish(MouseEvent event) {
    	getUsosStage().setEnLanguage();
    	resetLanguage();
    }

    @FXML
    void selectPolish(MouseEvent event) {
    	getUsosStage().setPlLanguage();
    	resetLanguage();
    }
    
    void resetLanguage() {
    	loginLabel.setText(getUsosStage().getMsg("login.login"));
    	passwordLabel.setText(getUsosStage().getMsg("login.pass"));
    	loginButton.setText(getUsosStage().getMsg("login.loginButton"));
    	authorsButton.setText(getUsosStage().getMsg("login.authorsButton"));
    	
    	getUsosStage().setTitle(getUsosStage().getMsg("login.title"));
    }
	
    ///ustawienie kursora na dlon gdy wejdzie na obszar flag
    @FXML
    void changeCursor(MouseEvent event) {
    	imageEnglishLanguage.getScene().getRoot().setCursor(Cursor.HAND);
    }
    
    ///powrot do standardowego kursora gdy opusci obszar flag
    @FXML
    void backCursor(MouseEvent event) {
    	imageEnglishLanguage.getScene().getRoot().setCursor(Cursor.DEFAULT);
    }

    @FXML
    void authorsButtonClick(MouseEvent event) {

    	Authors authors = new Authors();
    	authors.start(this.getUsosStage());
    	
    }

}