package client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientCall {
	
	public static void main(String[] args) {
		try {
		URL url = new URL("http://localhost:8080/WS_Reservation/search/2020-11-21/8/6");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");
	    conn.disconnect();
		} catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	      }
	}
}
