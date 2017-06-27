package gui;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import usos.UsosManager;

public class NewMarksThread implements Runnable {

	UsosManager usosManager;
	int sleepMiliseconds;
	Home home;
	HomeController homeController;

	NewMarksThread(UsosManager usosManager, Home home, HomeController homeController, int sleepMiliseconds) {
		this.usosManager = usosManager;
		this.sleepMiliseconds = sleepMiliseconds;
		this.home = home;
		this.homeController = homeController;
	}

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(this.sleepMiliseconds);
				if (usosManager.checkChangesInMarks()) {
					this.home.showNotice();
					homeController.fillTable();
				}
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
