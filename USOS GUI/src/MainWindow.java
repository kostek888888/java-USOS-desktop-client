import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.browser.ProgressAdapter;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.wb.swt.SWTResourceManager;


public class MainWindow {
	private Table table;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	MainWindow(String login)
	{
		runMainWindow(login);
	}
	
	public void runMainWindow(String login)
	{
		Display display = Display.getDefault();

		Monitor primary = display.getPrimaryMonitor ();
		Rectangle bounds = primary.getBounds ();		

		Shell shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setSize(bounds.width, bounds.height-40);  ///to odkomentowac jak sie chce rozdzialke w zaleznosci od rozdzielczosci monitora
		shell.setMinimumSize(bounds.width, bounds.height-40);
		shell.setText("USOS Manager");
		shell.setImage(new Image(display, "icon/favicon-0.png"));
		

		Rectangle rect = shell.getBounds ();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = 0;
		shell.setLocation (x, y);

/*
		
		///Menu
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		///Session
		MenuItem mntmSession = new MenuItem(menu, SWT.CASCADE);
		mntmSession.setText("Session");
		
		Menu menu_1 = new Menu(mntmSession);
		mntmSession.setMenu(menu_1);
			///Sign Out
			MenuItem mntmSignOut = new MenuItem(menu_1, SWT.NONE);
			mntmSignOut.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					///Successful logout
					MessageBox msgBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
					 String msg = "Successful logout";
					 msgBox.setMessage(msg);
					 msgBox.open();
					shell.dispose();
					LoginWindow loginWindowobj1 = new LoginWindow();
				}
			});
			mntmSignOut.setText("Sign Out");
		
			
			
		///Settings
		MenuItem mntmSettings = new MenuItem(menu, SWT.CASCADE);
		mntmSettings.setText("Settings");
		
		Menu menu_2 = new Menu(mntmSettings);
		mntmSettings.setMenu(menu_2);
		
		
		///Info
		MenuItem mntmInfo = new MenuItem(menu, SWT.CASCADE);
		mntmInfo.setText("Info");
		
		Menu menu_3 = new Menu(mntmInfo);
		mntmInfo.setMenu(menu_3);
			
			///Authors
			MenuItem mntmAuthors = new MenuItem(menu_3, SWT.NONE);
			mntmAuthors.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					 AuthorsWindow authorsObj = new AuthorsWindow(); 
				}
			});
			mntmAuthors.setText("Authors");
*/			

		
			int width = bounds.width;
			int height = bounds.height-40;
			
			CTabFolder tabFolder = new CTabFolder(shell, SWT.BORDER);
			tabFolder.setBounds(0, 0, width,height);
			tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
			
			
			
			///Your USOS
			CTabItem usosItem = new CTabItem(tabFolder, SWT.NONE);
			usosItem.setText("Your USOS");
			
			Composite usosComposite = new Composite(tabFolder, SWT.NONE);
			usosItem.setControl(usosComposite);
			
			table = new Table(usosComposite, SWT.BORDER | SWT.FULL_SELECTION);
			table.setBounds(323, 10, 808, 570);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			
			TableColumn tblclmnPrzedmoit = new TableColumn(table, SWT.NONE);
			tblclmnPrzedmoit.setWidth(500);
			tblclmnPrzedmoit.setText("Subject");
			
			TableColumn termin1col = new TableColumn(table, SWT.NONE);
			termin1col.setToolTipText("");
			termin1col.setWidth(75);
			termin1col.setText("Termin 1");
			
			TableColumn termin2col = new TableColumn(table, SWT.NONE);
			termin2col.setWidth(75);
			termin2col.setText("Termin 2");
			
			TableColumn termin3col = new TableColumn(table, SWT.NONE);
			termin3col.setWidth(75);
			termin3col.setText("Termin 3");
			
			TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
			tblclmnNewColumn.setWidth(75);
			tblclmnNewColumn.setText("Srednia");
			
			///Powitanie
			Label welcomeLabel = new Label(usosComposite, SWT.NONE);
			welcomeLabel.setBounds(10, 10, 240, 46);
			
			
			welcomeLabel.setText("Welcome \n" + "Login: " + login + "\n"
					+ "Status: Connected");
			
			Button btnSignOut = new Button(usosComposite, SWT.NONE);
			btnSignOut.setBounds(10, 305, 240, 25);
			btnSignOut.setText("Sign Out");
			
			Label lblTuSieJebnie = new Label(usosComposite, SWT.NONE);
			lblTuSieJebnie.setBounds(74, 169, 227, 15);
			lblTuSieJebnie.setText("tu sie jebnie kalendarz");
			
			Button btnAuthors = new Button(usosComposite, SWT.NONE);
			btnAuthors.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					AuthorsWindow authorsWindowObj1 = new AuthorsWindow();
				}
			});
			btnAuthors.setBounds(10, 387, 240, 25);
			btnAuthors.setText("Authors");
			
			Button btnSettings = new Button(usosComposite, SWT.NONE);
			btnSettings.setBounds(10, 356, 240, 25);
			btnSettings.setText("Settings");
			
			btnSignOut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					shell.dispose();
					LoginWindow loginWindowObj = new LoginWindow();
				}
			});
	

			
			
			
			
			
			

			
			///YOUR PLAN
			CTabItem planTabItem = new CTabItem(tabFolder, SWT.NONE);
			planTabItem.setText("Your Plan");
			
			
			Composite planComposite = new Composite(tabFolder, SWT.NONE);
			planTabItem.setControl(planComposite);
			
			///	Wersja 1: z ladna przegladarka z paskiem i reszta
			/*
			///napis adres
			Label addressL = new Label(planComposite, SWT.NONE);
			addressL.setBounds(10, 8, 51, 18);
			addressL.setText("Address");
			
			///pasek adresu
			text = new Text(planComposite, SWT.BORDER);
			text.setBounds(65, 5, rect.width-75-20-75-75-5, 21); ///width_adresB+, szerokosc textu = szerokosc formatki - szerokosc gobutton - szerokosc refresh button - odstep 
			

			
			final Browser browser = new Browser(planComposite, SWT.NONE);
			browser.setBounds(1, 44, rect.width-20, rect.height-44-60-30);
			
			
					   ///napis informacyjny po lewej pod przegladarka
						Label browserInfoLabel = new Label(planComposite, SWT.NONE);
						browserInfoLabel.setText("browserInfoLabel");
						browserInfoLabel.setBounds(10, rect.height-80, 280, 15);
						
						///pasek postepu ladowanie strony, na dole po prawej
						ProgressBar browserProgressBar = new ProgressBar(planComposite, SWT.NONE);
						browserProgressBar.setBounds(rect.width-530, rect.height-85, 500, 17);
						
			
			///pobieranie ingformacji o pobieraniu sie strony
			browser.addProgressListener(new ProgressAdapter() {
				@Override
				public void changed(ProgressEvent event) {
					if (event.total == 0) return;
					int ratio = event.current * 100 / event.total;
					browserProgressBar.setSelection(ratio);	
					browserInfoLabel.setText("Please wait. The web page is loaded");
				}
			});
			
			browser.addProgressListener(new ProgressAdapter() {
				@Override
				public void completed(ProgressEvent event) {
					browserProgressBar.setSelection(0);	
					browserInfoLabel.setText("Conplete");
				}
			});
			
			///odswiezanie adresu na pasku tekstowym po kliknieciu gdzies na stronie
			browser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					
					String address = browser.getUrl();
					text.setText(address);
				}
			});
			
			
			///przejscie do adresu po wcisnieciu enter z kliknietym polem do wpisywania
			text.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent arg0) {
					if(arg0.detail == SWT.TRAVERSE_RETURN)
					{
						String go_address = text.getText();
						if(!go_address.isEmpty()) ///jesli pole adresu nie jest puste	
								browser.setUrl(go_address);	
					}
				}
			});
		
	       
			
			
			///przejscie pod podany adres po wcisnieciu przycisku go
			Button goB = new Button(planComposite, SWT.NONE);
			goB.setBounds((rect.width)-175, 3, 75, 25);
			goB.setText("Go");
			goB.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					String go_address = text.getText();
					if(!go_address.isEmpty()) ///jesli pole adresu nie jest puste
					{		
							browser.setUrl(go_address);
					}			
				}
			});
				
			///odswiezanie po wcisnieciu przycisku refresh
			Button refreshB = new Button(planComposite, SWT.NONE);
			refreshB.setBounds((rect.width)-75-23, 3, 75, 25);
			refreshB.setText("Refresh");
			refreshB.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					String go_address = text.getText();
					if(!go_address.isEmpty()) ///jesli pole adresu nie jest puste
					{		
							browser.setUrl(go_address);
					}		
				}
			});
			
			*/
			
			
			
			
			///wersja 2 wyswietla tylko okna planu i kalendarza. nie da sie samemu nigdzie wchodzic poza tym co zdefiniowane w przyciskach
			final Browser browser = new Browser(planComposite, SWT.NONE);
			browser.setBounds(100, 1, rect.width-110, rect.height-50); ///bylo 110
			
			Button btnPlan = new Button(planComposite, SWT.NONE);
			btnPlan.setBounds(10, 10, 75, 25);
			btnPlan.setText("Plan");
			btnPlan.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					browser.setUrl("plany.tu.kielce.pl");
				}
			});

			
			Button btnCalendar = new Button(planComposite, SWT.FLAT);
			btnCalendar.setBounds(10, 41, 75, 31);
			btnCalendar.setText("Calendar");
			btnCalendar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					browser.setUrl("http://www.tu.kielce.pl/files/r-szczebel/kalendarz201617");
				}
			});
			
			
		
		
		
		shell.open();
		
		browser.setUrl("plany.tu.kielce.pl"); ///strona startowa
		
		
		
		
				
		///text.setText("www.plany.tu.kielce.pl");
		///browserInfoLabel.setText("Conplete"); ///to dla 1 wersji
		

		

				
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
