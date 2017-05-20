package gui;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import usos.UsosManager;
import usos.helper.Semester;

public class HomeController {
	
	String soundPath = "src/main/resources/sound.mp3";

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label loginAsLabel;
    
    @FXML
    private Button testDzwiekuButton;
    
    private TableView<?> tableView;
    
    @FXML
    private TableColumn<?, ?> columnSubject;

    @FXML
    private TableColumn<?, ?> columnType;

    @FXML
    private TableColumn<?, ?> columnMarks;

    
    ///fakeInit odpala po kliknieciu na test dzwieku @todo
    void fakeInit(){
    	getUsosStage().setEnLanguage();
    	resetLanguage();
    	///tu niech ustawi jezyk na taki jaki byl wybrany w oknie logowania
    	///wczytanie danych do tabeli
    }
        
    private UsosStage getUsosStage() {
    	//FUSZERKA !!! @todo
    	return  (UsosStage) anchorPane.getScene().getWindow();
    }
    
    private UsosManager getUsosManager() {
    	//FUSZERKA !!! @todo
        return getUsosStage().getUsosManager();
    }
    
    void resetLanguage() {
    	loginAsLabel.setText(getUsosStage().getMsg("home.loginAsLabel"));
    	columnSubject.setText(getUsosStage().getMsg("home.column.subject"));
    	columnType.setText(getUsosStage().getMsg("home.column.type"));
    	columnMarks.setText(getUsosStage().getMsg("home.column.marks"));
    	getUsosStage().setTitle(getUsosStage().getMsg("home.title"));
    	
    }

    

    @FXML
    void testDzwiekuClick(MouseEvent event) throws IOException {
    	try{
    	 	Media sound = new Media(new File(soundPath).toURI().toString());
        	MediaPlayer mediaPlayer = new MediaPlayer(sound);
        	mediaPlayer.play();
        	testDzwiekuButton.setDisable(true);
        	
        	///fakeInit usun¹æ @todo
        	fakeInit();
        	
        	//Semester semester = getUsosManager().getMarksForLastSemester();
			//System.out.println(semester.getName());
        	
    	} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Nie znaleziono pliku");
			
			
			
    	}
    }
}