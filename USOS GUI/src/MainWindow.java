import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;

import java.awt.event.KeyEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class MainWindow {
	private Text text;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	MainWindow()
	{
		runMainWindow();
	}
	
	public void runMainWindow()
	{
		Display display = Display.getDefault();

		Monitor primary = display.getPrimaryMonitor ();
		Rectangle bounds = primary.getBounds ();		

		Shell shell = new Shell();
		shell.setSize(bounds.width, bounds.height-100);
		shell.setText("USOS Manager");
		

		Rectangle rect = shell.getBounds ();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
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
			int height = bounds.height-100;
			
			CTabFolder tabFolder = new CTabFolder(shell, SWT.BORDER);
			tabFolder.setBounds(0, 0, width,height);
			tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

			CTabItem UsosTabItem = new CTabItem(tabFolder, SWT.NONE);
			UsosTabItem.setText("Your USOS");
			
			CTabItem planTabItem = new CTabItem(tabFolder, SWT.NONE);
			planTabItem.setText("Your Plan");
			
			
			Composite planComposite = new Composite(tabFolder, SWT.NONE);
			planTabItem.setControl(planComposite);
			
			
			///napis adres
			Label addressL = new Label(planComposite, SWT.NONE);
			addressL.setBounds(10, 8, 51, 18);
			addressL.setText("Address");
			
			///pasek adresu
			text = new Text(planComposite, SWT.BORDER);
			text.setBounds(65, 5, rect.width-75-20-75-75-5, 21); ///width_adresB+, szerokosc textu = szerokosc formatki - szerokosc gobutton - szerokosc refresh button - odstep 
			
			
			
			
			///okno przegladarki
			
			final Browser browser = new Browser(planComposite, SWT.NONE);
			browser.setBounds(1, 44, rect.width-20, rect.height-44-60);
			browser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					///odswiezanie adresu po kliknieciu gdzies na stronie
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
			

		shell.open();
		
		browser.setUrl("plany.tu.kielce.pl"); ///strona startowa
		text.setText("www.plany.tu.kielce.pl");
				
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
