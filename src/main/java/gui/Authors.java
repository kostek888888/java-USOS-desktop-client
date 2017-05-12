package gui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


	
public class Authors extends Application {

	public static String language;

	public static String getLanguage() {
		return language;
	}

	public static void setLanguage(String language) {
		Authors.language = language;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Authors.fxml"));
			Scene scene = new Scene(root,400,300);

			primaryStage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
			primaryStage.setTitle("USOS CLIENT Authors");
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
