package tps.ws.reservation;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.sun.xml.internal.ws.api.message.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchAvailability extends ServerResource {
	
	private List<String> messages = new ArrayList<String>();

	@Get
	public List<String> main(Representation entity) {
		
		String date = (String) getRequestAttributes().get("date");
		String nights = (String) getRequestAttributes().get("nights");
		String rooms = (String) getRequestAttributes().get("rooms");
		String search = "?date="+date+"&nights="+nights+"&rooms="+rooms;
		System.out.println(search);
		
				
		try {
	       

	        URL url = new URL("http://localhost:8080/WS_Filtering/services/Availability/executerTests"+search);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        //conn.setRequestMethod("GET");
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
	            //System.out.println(output);
	            messages.add(output);
	        }

	        conn.disconnect();
	        
	        //for(int i = 0; i < messages.size(); i++) {
	        //    System.out.println(messages.get(i));
	        //}

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	      }
		return messages;

	    }
}  