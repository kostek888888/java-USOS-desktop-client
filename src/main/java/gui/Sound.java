package gui;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sound {

	private String soundPath = "src/main/resources/sound.mp3";
	private Media sound = new Media(new File(soundPath).toURI().toString());
	private MediaPlayer mediaPlayer = new MediaPlayer(sound);
	
	
public void playSound(){
	try{
    		mediaPlayer.setOnEndOfMedia(new Runnable() 
    		{
				@Override
				public void run() {
					mediaPlayer.seek(Duration.ZERO);
				}
    		});
    	
    		mediaPlayer.play();    
		} catch(Exception e) {
		e.printStackTrace();
		System.out.println("Nie znaleziono pliku");
	}
}

public void stopSound(){
	mediaPlayer.stop();
}


}
