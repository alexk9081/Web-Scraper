
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScraper {
	public static void main(String[] args) {
		String source = "http://www.google.com";
		Document doc = null;
		Elements pictureClass = null;
		Elements googlePicture = null;
		String pictureSource = null;
		try {
			doc = Jsoup.connect(source).get();
			pictureClass = doc.select("div[class=\"k1zIA kKvsb\"]");
			googlePicture = pictureClass.select("img#hplogo");
			pictureSource = googlePicture.attr("src");
		} catch (IOException e) {
			System.out.print("Connection Error.");
			e.printStackTrace();
		}
		try {
		    Desktop.getDesktop().browse(new URL(source + pictureSource).toURI());
		} catch (Exception e) {}
//		System.out.print(pictureSource);
	}

}
