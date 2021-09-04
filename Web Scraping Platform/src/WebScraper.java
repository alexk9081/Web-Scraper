
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScraper {
	public static void main(String[] args) {
		String source = "http://www.google.com";
		String pictureSource = null;
		
		try {
			Document doc = null;
			Elements pictureClass = null;
			
			//Connect to Google.com
			doc = Jsoup.connect(source).get();
			
			//Navigate to get picture source
			pictureClass = doc.select("img:not([aria-hidden])");
			pictureSource = pictureClass.attr("src");
		} catch (IOException e) {
			System.out.print("Connection Error.");
			e.printStackTrace();
		}
		
		//Open picture source on desktop browser
		try {
		    Desktop.getDesktop().browse(new URL(source + pictureSource).toURI());
		} catch (Exception e) {}
	}
}
