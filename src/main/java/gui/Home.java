package gui;
	
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import usos.LogoutException;
import usos.UsosManager;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;


	
public class Home extends Application {
	
    private boolean firstTime;
    private TrayIcon trayIcon;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.hide();	// trzeba ukryc okno po zalogowaniu bo inaczej bedzie widac jak sie zmienia
			createTrayIcon(primaryStage);
	        firstTime = false;	// wlaczenie powiadomien
	        
	        createStage(primaryStage);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	        
	}
		
	public void createStage(Stage primaryStage) {
		
		
		try {
			Platform.setImplicitExit(false);
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root,1280,600);
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
			primaryStage.setX((primaryScreenBounds.getMaxX() - scene.getWidth()) / 2);
			primaryStage.setY((primaryScreenBounds.getMaxY() - scene.getHeight()) / 2);
			primaryStage.setResizable(true);
			
			
			primaryStage.setTitle("USOS CLIENT Home");
	
			primaryStage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createTrayIcon(final Stage primaryStage) {
        if (SystemTray.isSupported()) {
            // get the SystemTray instance
            SystemTray tray = SystemTray.getSystemTray();
            // load an image
            
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("file:@../../icon/favicon-3.png"));
            } catch (IOException e) {
            	System.out.println(e);
            }
            
            /* bylo domyslnie jako czytanie ikony jak to wyzej bedzie ciagle dzialac to usunac zakomentowane ponizej
            java.awt.Image image = null;
            try {
                image = ImageIO.read(getClass().getResourceAsStream("file:@../../icon/favicon-3.jpg"));
            } catch (IOException ex) {
                System.out.println(ex);
            }*/

            primaryStage.iconifiedProperty().addListener(new ChangeListener<Boolean>() {
            	
				@Override
			    public void changed(ObservableValue<? extends Boolean> ov, Boolean oldVal, Boolean newVal) {
					//System.out.println("oldVal: " + oldVal + " newVal: " + newVal);
			        if (newVal.equals(new Boolean(true)))
			        {
			        	primaryStage.hide();
			        	showProgramIsMinimizedMsg();
			        	//System.out.println("IF");
			        } else {
			        	//createStage(primaryStage);
			        	primaryStage.show();
			        	//System.out.println("ELSE");
			        }
			    }
			});

            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent t) {
                    hide(primaryStage);
                }
            });
            // create a action listener to listen for default action executed on the tray icon
            final ActionListener closeListener = new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
            		Main.logout();
                    System.exit(0);
                }
            };

            ActionListener showListener = new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                        	if (!primaryStage.isShowing()) {
                        		createStage(primaryStage);
                        		primaryStage.setIconified(false);
                        		//System.out.println("showListener");
                        	}
                        	else if (primaryStage.isIconified())
                        		primaryStage.setIconified(false);
                        	else hide(primaryStage);
                        }
                    });
                }
            };
            // create a popup menu
            PopupMenu popup = new PopupMenu();

            MenuItem showItem = new MenuItem("Pokaż");
            showItem.addActionListener(showListener);
            popup.add(showItem);

            MenuItem closeItem = new MenuItem("Wyjdź");
            closeItem.addActionListener(closeListener);
            popup.add(closeItem);
            /// ... add other items
            // construct a TrayIcon
            trayIcon = new TrayIcon(img, "USOS Klient", popup);
            // set the TrayIcon properties
            trayIcon.addActionListener(showListener);
            // ...
            // add the tray image
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
            // ...
        }
    }
    
	// na razie bezuzyteczne ale przyda sie do timera czytajacego oceny chyba ze znajdziemy jak pokazac dymek
    public void showProgramIsMinimizedMsg() {
        if (firstTime) {
            trayIcon.displayMessage("New mark!",
                    "AMiA Lecture 3",
                    TrayIcon.MessageType.INFO);
            //firstTime = false;
        }
    }

    private void hide(final Stage primaryStage) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (SystemTray.isSupported()) {
                    primaryStage.hide();
                    showProgramIsMinimizedMsg();
                } else {
            		Main.logout();
                    System.exit(0);
                }
            }
        });
    }
    
    

}
