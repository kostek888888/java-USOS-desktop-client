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
    private Label loginLabel;
    
    @FXML
    private Button testDzwiekuButton;
    
    private TableView<?> tableView;
    
    @FXML
    private TableColumn<?, ?> columnSubject;

    @FXML
    private TableColumn<?, ?> columnType;

    @FXML
    private TableColumn<?, ?> columnDate1;

    @FXML
    private TableColumn<?, ?> columnDate2;

    @FXML
    private TableColumn<?, ?> columnDate3;
    
    private UsosStage getUsosStage() {
    	//FUSZERKA !!! @todo
    	return  (UsosStage) anchorPane.getScene().getWindow();
    }
    
    private UsosManager getUsosManager() {
    	//FUSZERKA !!! @todo
        return getUsosStage().getUsosManager();
    }
    
    
    @FXML
    void testDzwiekuClick(MouseEvent event) throws IOException {
    	try{
    	 	Media sound = new Media(new File(soundPath).toURI().toString());
        	MediaPlayer mediaPlayer = new MediaPlayer(sound);
        	mediaPlayer.play();
        	testDzwiekuButton.setDisable(true);
        	
        	//Semester semester = getUsosManager().getMarksForLastSemester();
			//System.out.println(semester.getName());
        	
    	} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Nie znaleziono pliku");
			
			
			
    	}
    }
   

}