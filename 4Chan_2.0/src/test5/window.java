package test5;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;

import java.io.File;

import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class window {

	protected Shell shlchanDownloader;
	private Text text;
	private Button btnNewButton;
	private Text text_1;
	private List list;
	static window window;
	download Download = new download();
	Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			window = new window();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlchanDownloader.open();
		shlchanDownloader.layout();
		while (!shlchanDownloader.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlchanDownloader = new Shell();
		shlchanDownloader.setSize(528, 509);
		shlchanDownloader.setText("4Chan Downloader");
		shlchanDownloader.setLayout(new FormLayout());
		
		text = new Text(shlchanDownloader, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(0, 23);
		fd_text.left = new FormAttachment(0, 8);
		text.setLayoutData(fd_text);
		
		btnNewButton = new Button(shlchanDownloader, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				
				
				
				
				DirectoryDialog dialog = new DirectoryDialog(shlchanDownloader);
			    dialog.setFilterPath("c:\\"); // Windows specific
			    //System.out.println("RESULT=" + dialog.open());
			    text.setText(dialog.open() + "");
			    while (!shlchanDownloader.isDisposed()) {
			        if (!display.readAndDispatch())
			            display.sleep();
			    }
			    display.dispose();
				
				
				if(true == true) { return; }
				
				 File file = null;
				 JFileChooser chooser = new JFileChooser();
				 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 int returnValue = chooser.showOpenDialog( null ) ;
				 
				 
				 String filePath = null;
				if( returnValue == JFileChooser.APPROVE_OPTION ) {
				        
						file = chooser.getSelectedFile();
				 }
				 if(file != null)
				 {
					 filePath = file.getPath();
				 } 
				 
				 text.setText(filePath);
				
			}
		});
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				
			}
		});
		fd_text.right = new FormAttachment(btnNewButton, -6);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(0, 19);
		fd_btnNewButton.right = new FormAttachment(100, -10);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Search");
		
		list = new List(shlchanDownloader, SWT.BORDER | SWT.V_SCROLL);
		FormData fd_list = new FormData();
		fd_list.top = new FormAttachment(text, 76);
		fd_list.right = new FormAttachment(btnNewButton, 0, SWT.RIGHT);
		fd_list.left = new FormAttachment(0, 8);
		list.setLayoutData(fd_list);
		
		Button btnNewButton_1 = new Button(shlchanDownloader, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				main Main = new main(text_1.getText(),text.getText(),window);
				
				
			}
		});
		fd_list.bottom = new FormAttachment(btnNewButton_1, -6);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.bottom = new FormAttachment(100, -33);
		fd_btnNewButton_1.right = new FormAttachment(btnNewButton, 0, SWT.RIGHT);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("Start");
		
		text_1 = new Text(shlchanDownloader, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.bottom = new FormAttachment(list, -27);
		fd_text_1.right = new FormAttachment(btnNewButton, 0, SWT.RIGHT);
		fd_text_1.left = new FormAttachment(0, 8);
		text_1.setLayoutData(fd_text_1);
		
		Label lblNewLabel = new Label(shlchanDownloader, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.bottom = new FormAttachment(text_1, -6);
		fd_lblNewLabel.left = new FormAttachment(text, 0, SWT.LEFT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("Url:");

	}
	
	public void addListItem(String string) {
		
		this.list.add(string);
		
	}
}
