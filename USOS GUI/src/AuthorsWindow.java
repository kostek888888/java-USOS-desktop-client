import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;


public class AuthorsWindow {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	AuthorsWindow()
	{
		runAuthorsWindow();
	}
	

	public int runAuthorsWindow()
	{
		
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(298, 300);
		shell.setText("Authors");
		 final Cursor cursor = new Cursor(display, SWT.CURSOR_HAND); ///zmiana kursora przy najechaniu na link
		
		///apka odpali sie na pierwszym monitorze na srodku ekranu
		Monitor primary = display.getPrimaryMonitor ();
		Rectangle bounds = primary.getBounds ();
		Rectangle rect = shell.getBounds ();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shell.setLocation (x, y);
		
		Label lblAuthors = new Label(shell, SWT.NONE);
		lblAuthors.setBounds(41, 25, 55, 15);
		lblAuthors.setText("Authors:");
		
		
		///przyciski i linki
		
		///dominik
		Label lblDominikKlarkowski = new Label(shell, SWT.NONE);
		lblDominikKlarkowski.setBounds(41, 55, 113, 15);
		lblDominikKlarkowski.setText("Dominik Klarkowski");

		Label dominik_link = new Label(shell, SWT.NONE);
		dominik_link.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		dominik_link.setBounds(180, 55, 55, 15);
		dominik_link.setText("Github");
		dominik_link.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				dominik_link.setCursor(cursor);
			}
		});
		dominik_link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				org.eclipse.swt.program.Program.launch("https://github.com/TheMrDraven");
			}
		});

		
		
		
		
		///wojtek
		Label lblWojciechKusek = new Label(shell, SWT.NONE);
		lblWojciechKusek.setBounds(41, 76, 113, 15);
		lblWojciechKusek.setText("Wojciech K\u0142usek");
		
		Label wojtek_link = new Label(shell, SWT.NONE);
		wojtek_link.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		wojtek_link.setBounds(180, 76, 55, 15);
		wojtek_link.setText("Github");
		wojtek_link.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				wojtek_link.setCursor(cursor);
			}
		});
		wojtek_link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				org.eclipse.swt.program.Program.launch("https://github.com/wojtek9502");
			}
		});

		
		
		
		
		///michal
		Label lblMichaKostecki = new Label(shell, SWT.NONE);
		lblMichaKostecki.setBounds(41, 97, 113, 15);
		lblMichaKostecki.setText("Micha\u0142 Kostecki");
		
		Label michal_link = new Label(shell, SWT.NONE);
		michal_link.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		michal_link.setBounds(180, 97, 55, 15);
		michal_link.setText("Github");
		michal_link.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				michal_link.setCursor(cursor);
			}
		});
		michal_link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				org.eclipse.swt.program.Program.launch("https://github.com/kostek888888");
			}
		});

		
		
		
		
		///tomek
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(41, 118, 113, 15);
		lblNewLabel.setText("Tomasz Kowalczyk");

		Label tomek_link = new Label(shell, SWT.NONE);
		tomek_link.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		tomek_link.setBounds(180, 118, 55, 15);
		tomek_link.setText("Github");
				
		tomek_link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				org.eclipse.swt.program.Program.launch("https://github.com/tomaszkowalczyk94");
			}
		});
		tomek_link.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				tomek_link.setCursor(cursor);
			}
		});
		
		
		///projekt link
		Label lblUsosMagnagerOn = new Label(shell, SWT.NONE);
		lblUsosMagnagerOn.setBounds(24, 178, 195, 15);
		lblUsosMagnagerOn.setText("Visit USOS Manager Project site on");
		
		Label project_link = new Label(shell, SWT.NONE);
		project_link.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		project_link.setBounds(225, 178, 47, 15);
		project_link.setText("Github");
		project_link.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				project_link.setCursor(cursor);
			}
		});
		project_link.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				org.eclipse.swt.program.Program.launch("https://github.com/kostek888888/java-USOS-desktop-client");
			}
		});


		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}

		}
		return 1;
	}
	

}
