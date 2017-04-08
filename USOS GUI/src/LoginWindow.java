import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class LoginWindow {
	private Text loginText;
	private Text passText;
	
	LoginWindow()
	{
		runLoginWindow();
	}


	
	public void runLoginWindow()
	{
		
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(355, 526);
		shell.setText("USOS Manager Login");

		///apka odpali sie na pierwszym monitorze na srodku ekranu
		Monitor primary = display.getPrimaryMonitor ();
		Rectangle bounds = primary.getBounds ();
		Rectangle rect = shell.getBounds ();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shell.setLocation (x, y);

		
		loginText = new Text(shell, SWT.BORDER);
		loginText.setBounds(103, 336, 173, 21);
		
		passText = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		passText.setBounds(103, 373, 173, 21);
		
		Label loginLabel = new Label(shell, SWT.NONE);
		loginLabel.setAlignment(SWT.CENTER);
		loginLabel.setBounds(42, 339, 55, 15);
		loginLabel.setText("Login");
		
		Label passLabel = new Label(shell, SWT.NONE);
		passLabel.setBounds(42, 376, 55, 15);
		passLabel.setText("Password");
		
		///przycisk zaloguj
			Button signInButton = new Button(shell, SWT.NONE);
			signInButton.setBounds(103, 412, 106, 25);
			signInButton.setText("Sign in");
			///akcja dla wcisniecia przycisku
			signInButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					String login = loginText.getText();
					String pass = passText.getText();
					if(login.length()>0 && pass.length()>0 && login.compareTo("login")==0 && pass.compareTo("pass")==0 )   ///zwraca 0 jak takie same <>0 jak rozne
					{
						signInButton.setEnabled(false);   ///dezaktywuj przycisk
						  MessageBox msgBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
					      String msg = "Zalogowany";
					      msgBox.setMessage(msg);
					      msgBox.open();
					      shell.dispose();   ///zalogowano wy³¹cz okno Logowania
					      
					      ///przejdz do MainWindow
					      MainWindow mainWindowObj = new MainWindow();
					}
					else
					{
						 MessageBox msgBox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
						 String msg = "login: login \n"
				      		+ "pass: pass";
						 msgBox.setMessage(msg);
						 msgBox.open();
					}
				}
			});

		
		///obrazek dolana
		Image dolanjpg = new Image(display, "img/dolan.jpg");
		Label dolanImage = new Label(shell, SWT.NONE);
		dolanImage.setText("dolan image");
		dolanImage.setImage(dolanjpg);
		dolanImage.setBounds(52, 23, 224, 280);
		
		///menu
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		///przycisk menu 1 poziomu 'Info'
		MenuItem infoMenu = new MenuItem(menu, SWT.CASCADE);
		infoMenu.setText("Info");
		
				///podmenu dla menu Info
				Menu infoSubmenu = new Menu(infoMenu);
				infoMenu.setMenu(infoSubmenu);
		
				///Autorzy
				MenuItem authors = new MenuItem(infoSubmenu, SWT.NONE);
				authors.setText("Authors");
				///akcja po wcisnieciu Autorzy w menu
				authors.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
					      AuthorsWindow authorsObj = new AuthorsWindow();    
						
					}
				});
				
		
		
				///Exit
				MenuItem exit = new MenuItem(infoSubmenu, SWT.NONE);
				exit.setText("Exit");
				///zdarzenie po kliknieciu Exit w menu
				exit.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						System.exit(0);
					}
				});
				
				///koniec podmenu Info
				

		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}


	public static void main(String[] args) {
		LoginWindow loginObj = new LoginWindow();
		
	}
}
