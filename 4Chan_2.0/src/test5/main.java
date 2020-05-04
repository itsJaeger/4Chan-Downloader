package test5;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.swt.widgets.Display;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {
		public main(String aurl,String dir, window win) {
			
			Display display = Display.getDefault();
			String fileName = aurl.substring( aurl.lastIndexOf('/')+1, aurl.length() );
			System.out.println("urla : " + aurl);
			System.out.println("Fna : " + fileName);
			System.out.println("dira : " + dir);
			

			

			 Document doc;
			try {
				doc = Jsoup.connect(aurl).get();
			} catch (IOException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
				return;
			}  
			 win.addListItem(  doc.title());
			 Elements newsHeadlines = doc.select("a[href*=i.4cdn.org]");
			 int i = 0;
			 ExecutorService pool = Executors.newFixedThreadPool(5); 
			 
			 for (Element headline : newsHeadlines) {
				 
				 
				 System.out.println(" hmm " + headline.html());
				
				 if(headline.html().contains("img")) {
					
					 	  
						  Runnable r1 = new theThread("Thread name",headline.absUrl("href"),dir + "\\" + doc.title().replace("\\", "").replace("-", "").replace("/", "").replace("?", "").replace(":", ""), win,display); 
						  pool.execute(r1); 
				 }

			 }
			 
			 
			
			
			
		}
}


class theThread implements Runnable  {
	   private Thread t;
	   private String threadName;
	   private String aurl;
	   private String dir;
	   private window win;
	   private Display display;
	   
	   theThread( String name, String aurl, String dir, window win, Display display) {
		      System.out.println("Starting " +  threadName );
		      this.aurl = aurl;
		      this.dir = dir;
		      this.win = win;
		      this.display = display;
		      threadName = name;
		      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
		   System.out.println("Running " +  threadName );
		   
           display.asyncExec(new Runnable() {
               public void run() {
            	   win.addListItem("  File downloading: " + aurl);
               }
            });
		   
		   
	       
			
			//tx.setText(textPane.getText() + "\n" + " Folder created?" + f + " - " +  "c:\\Users\\charl\\Documents\\4chanDownload\\" + doc.title().replace("\\", "").replace("/", ""));
			download d = new download(aurl,dir, win);
			long threadId = Thread.currentThread().getId()%5 +1;

	        System.out.println("Thread - " + threadId + " exiting.");
	   }
	   


	   
	}
