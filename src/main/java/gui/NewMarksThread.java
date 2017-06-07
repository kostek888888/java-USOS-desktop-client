package gui;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import usos.UsosManager;

public class NewMarksThread implements Runnable {

	UsosManager usosManager;
	int sleepMiliseconds;
	Home home;

	NewMarksThread(UsosManager usosManager, Home home, int sleepMiliseconds) {
		this.usosManager = usosManager;
		this.sleepMiliseconds = sleepMiliseconds;
		this.home = home;
	}

	@Override
	public void run() {
		System.out.println("thread init");

		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(this.sleepMiliseconds);
				if (usosManager.checkChangesInMarks()) {
					System.out.println("Nowa ocena !");
					this.home.showNotice();
				}

			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}

			System.out.println("watek cos robi");
		}
	}

}
