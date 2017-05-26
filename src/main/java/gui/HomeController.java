package gui;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import usos.helper.Subject;
import usos.helper.TypeOfClass;
import usos.helper.TypeOfClass.type;

public class HomeController {
	
	String soundPath = "src/main/resources/sound.mp3";

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label loginAsLabel;
    
    @FXML
    private Label dataDownloadStatusLabel;
    
    @FXML
    private Label recentlyCheckedLabel;
    
    @FXML
    private Button testDzwiekuButton;
    
    @FXML
    private TableView<TableRow> tableView;
    
    @FXML
    private TableColumn<TableRow, String> columnSubject;

    @FXML
    private TableColumn<?, ?> columnType;

    @FXML
    private TableColumn<?, ?> columnMarks;
    
    @FXML
    private Button tableTestButton;

    @FXML
    private void initialize() {
    	///columnSubject.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    }
    
    @FXML
    void tableTestButtonClick(MouseEvent event) throws IOException {
    	fakeInit();
    	fillTable();
    }

    
    ///fakeInit odpala po kliknieciu na test tabeli @todo
    void fakeInit() throws IOException{
    	///tu niech ustawi jezyk na taki jaki byl wybrany w oknie logowania
    	resetLanguage();
    }
    
 // ... AFTER THE OTHER VARIABLES ...

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<TableRow> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public HomeController() {
        // Add some sample data
    	
    }
    
    //==============
    
    void fillTable() throws IOException
    {
    	tableView.setItems(personData);
    	
    	try{
    		dataDownloadStatusLabel.setText(getUsosStage().getMsg("home.statusLabel.success"));
    		
    	 	Semester lastSemester = getUsosManager().getMarksForLastSemester();
    		System.out.println("semestr: "+lastSemester.getName()); 
    		
    		
    		List<Subject> subjects = lastSemester.getSubjects();
    		for(Subject it : subjects){
    			System.out.println(it.getName());
    			Map<type, TypeOfClass> typesOfClass = it.getTypesOfClass();
        		for(Map.Entry<type, TypeOfClass> entry : typesOfClass.entrySet()) {
        			
        			//wyswietlanie po kolei ocen z każdych zajęć (ćwiczeń, labolatoriów itp)
        			System.out.println(entry.getValue().getName()+" : "+entry.getValue().getMainMark().getStringMark()); 
    		}
        	
    		}  
    		dataDownloadStatusLabel.setText(getUsosStage().getMsg("home.statusLabel.success"));
    		

    		
    	}catch(Exception e){
    		e.printStackTrace();
    		dataDownloadStatusLabel.setText(getUsosStage().getMsg("home.statusLabel.error"));
    	} finally{
        	///pobranie daty
        	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        	Date date = new Date();
        	recentlyCheckedLabel.setText(getUsosStage().getMsg("home.recentlyCheckedLabel") + " " + dateFormat.format(date));
    	} 
   		
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
    	dataDownloadStatusLabel.setText(getUsosStage().getMsg("home.statusLabel.none"));
    	recentlyCheckedLabel.setText(getUsosStage().getMsg("home.recentlyCheckedLabel"));
    	
    	
    }

    

    @FXML
    void testDzwiekuClick(MouseEvent event) throws IOException {
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