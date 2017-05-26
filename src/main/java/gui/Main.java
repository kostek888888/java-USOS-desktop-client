package gui;
	
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import usos.LogoutException;
import usos.UsosManager;
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
	
	private static UsosManager usosManager = new UsosManager();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("gui.fxml"));
			Scene scene = new Scene(root,400,400);
			
			UsosStage usosStage = new UsosStage();
			usosStage.setUsosManager(usosManager);
			usosStage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
			usosStage.setTitle(usosStage.getMsg("login.title"));
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			usosStage.setScene(scene);
			usosStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		launch(args);
		try {
			usosManager.logout();
		} catch (IOException | LogoutException e) {
			System.out.println("Logout error");
		}
	}
}
