package gui;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


/**
 * Stage - cos ala sesja
 * Scene - Dane okienko
 * AnchorPane - dziedziczy po "Parent" okienko kotwicy. Zawiera w sobie plik fxml z rozkladem okna
 */

	
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("gui.fxml"));
			Scene scene = new Scene(root,400,400);
			
			UsosStage usosStage = new UsosStage();
			usosStage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
			usosStage.setTitle(usosStage.getMsg("login.title"));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			usosStage.setScene(scene);
			
			usosStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
