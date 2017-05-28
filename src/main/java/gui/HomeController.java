package gui;

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
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import usos.UsosManager;
import usos.helper.Semester;
import usos.helper.Subject;
import usos.helper.TypeOfClass;
import usos.helper.TypeOfClass.type;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;



public class HomeController {
	

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
    private TableColumn<TableRow, String> columnType;

    @FXML
    private TableColumn<TableRow, String> columnMarks;
    
    @FXML
    private Button tableTestButton;
    
    @FXML
    private Button alarmStopButton;
    
    private Sound sound = new Sound();
    
    @FXML
    private Slider slider;

    @FXML
    private Label sliderValueLabel;


    @FXML
    private Label refreshLabel;

    @FXML
    private Label minLabel;
    
    



 
    

    @FXML
    private void initialize() {
    	columnSubject.setCellValueFactory(cellData -> cellData.getValue().subjectProperty());
    	columnType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
    	columnMarks.setCellValueFactory(cellData -> cellData.getValue().marksProperty());
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
    private ObservableList<TableRow> subjectData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public HomeController() {
    	
    }
    
    
    void fillTable() throws IOException
    {
    	tableView.setItems(subjectData);
    	
    	try{
    		dataDownloadStatusLabel.setText(getUsosStage().getMsg("home.statusLabel.success"));
    		
    	 	Semester lastSemester = getUsosManager().getMarksForLastSemester();
    	 	
    	 	///semestr
    	 	subjectData.add(new TableRow(lastSemester.getName(), "", ""));
    		
    		
    		///przedmioty
    		List<Subject> subjects = lastSemester.getSubjects();
    		for(Subject it : subjects){;
    			Map<type, TypeOfClass> typesOfClass = it.getTypesOfClass();
        		for(Map.Entry<type, TypeOfClass> entry : typesOfClass.entrySet()) {
        										//nazwa         ///typ						///ocena
        			subjectData.add(new TableRow(it.getName()  , entry.getValue().getName() , entry.getValue().getMainMark().getStringMark()));
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
    	alarmStopButton.setText(getUsosStage().getMsg("home.alarmStopButton"));
    	refreshLabel.setText(getUsosStage().getMsg("home.slider.refreshLabel"));
    }

    

    @FXML
    void testDzwiekuClick(MouseEvent event) throws IOException {
    		///pojawia sie przycisk "Wyłącz alarm"
    	alarmStopButton.setVisible(true);
    	sound.playSound();  	
    }
    
    
    @FXML
    void alarmStopButtonClicked(MouseEvent event) {
    	sound.stopSound();
    	
    	///znika przycisk "Wylącz alarm"
    	alarmStopButton.setVisible(false);

    }

    ////////////////SLIDER
    
    private int sliderValue;
    
    
    public int getSliderValue() {
		return sliderValue;
	}

	public void setSliderValue(int sliderValue) {
		this.sliderValue = sliderValue;
	}

	@FXML
    void sliderChangeValue(MouseEvent event) {
    	slider.valueProperty().addListener(new ChangeListener<Number>() {
             public void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
            	 sliderValueLabel.setText(String.format("%d", new_val.intValue()));
            	 setSliderValue(new_val.intValue());
            	 
            	 System.out.println(getSliderValue());
             }
         });
    }

    
}