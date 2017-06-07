package gui;
	
import java.io.IOException;

import javafx.application.Application;
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.imageio.ImageIO;
import usos.LogoutException;
import usos.UsosManager;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;


/**
 * Stage - cos ala sesja
 * Scene - Dane okienko
 * AnchorPane - dziedziczy po "Parent" okienko kotwicy. Zawiera w sobie plik fxml z rozkladem okna
 */

	
public class Main extends Application {

	
	static private UsosManager usosManager;
	static private UsosStage usosStage = new UsosStage();
	static private double width = 400, height = 400;	// rozmiar okna
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			usosManager = new UsosManager();
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("gui.fxml"));
			Scene scene = new Scene(root,width,height);
			
			usosStage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
			usosStage.setTitle(usosStage.getMsg("login.title"));
			usosStage.setUsosManager(usosManager);
			usosStage.setResizable(false);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			usosStage.setScene(scene);

			Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
			usosStage.setX((primaryScreenBounds.getMaxX() - scene.getWidth()) / 2);
			usosStage.setY((primaryScreenBounds.getMaxY() - scene.getHeight()) / 2);
			
			usosStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		Main.logout();
	}
	
	// potrzebne do wylogowania sie w Home bo musimy miec dostep do obiektu usosManager z tego tez powodu jest static
	public static void logout() {
		try {
			usosManager.logout();
		} catch (IOException | LogoutException e) {
			System.out.println("Logout error");
			e.printStackTrace();
		}
	}
	
	public static double getDialogX() {
		return usosStage.getX();
	}
	
	public static double getDialogY() {
		return (usosStage.getY() + height / 2);
	}
	
}
