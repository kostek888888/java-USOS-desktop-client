package gui;

import java.io.File;
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
    
    
    
    @FXML
    void testDzwiekuClick(MouseEvent event) {
    	try{
    	 	Media sound = new Media(new File(soundPath).toURI().toString());
        	MediaPlayer mediaPlayer = new MediaPlayer(sound);
        	mediaPlayer.play();
        	testDzwiekuButton.setDisable(true);
        	
      
        	
    	} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Nie znaleziono pliku");
    	}
    }
   

}