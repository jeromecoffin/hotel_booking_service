package tps.ws.reservation;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchAvailability extends ServerResource {

	@Get
	public void main(String[] args) {
		
		String date = (String) getRequestAttributes().get("date");
		String nights = (String) getRequestAttributes().get("nights");
		String rooms = (String) getRequestAttributes().get("rooms");
		String search = "?date="+date+"&nights="+nights+"&rooms="+rooms;
		System.out.println(search);
				
		try {

	        URL url = new URL("http://localhost:8080/WS_Filtering/services/Availability/executerTests"+search);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");

	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + conn.getResponseCode());
	        }

	        BufferedReader br = new BufferedReader(new InputStreamReader(
	            (conn.getInputStream())));

	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	        }

	        conn.disconnect();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	      }

	    }
}  