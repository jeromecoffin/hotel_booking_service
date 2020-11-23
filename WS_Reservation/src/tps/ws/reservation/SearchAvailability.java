package tps.ws.reservation;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
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
	public void main(Representation entity) {
		
				
		try {
			Form form = new Form(entity);  
	        String date = form.getFirstValue("date");
	        String nights = form.getFirstValue("nights");
	        String rooms = form.getFirstValue("rooms");
	        
	        System.out.println("Output "+date);


	        URL url = new URL("http://localhost:8080/WS_Filtering/services/Availability/executerTests"+"?date="+date+"&nights="+nights+"&rooms="+rooms);
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