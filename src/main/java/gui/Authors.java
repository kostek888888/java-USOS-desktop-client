package gui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


	
public class Authors extends Application {



	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Authors.fxml"));
			Scene scene = new Scene(root,400,300);
			UsosStage usosStage = new UsosStage();
	
			usosStage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
			
			///Ustawia jezyk domyslny czyli angielski a powinien ten wybrany w oknie logowania @todo
			usosStage.setTitle(usosStage.getMsg("authors.title"));
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			usosStage.setScene(scene);
			usosStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Dla testow, potem do usuniecia
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
