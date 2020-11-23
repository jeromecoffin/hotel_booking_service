package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.restlet.data.Form;
import org.restlet.resource.ClientResource;

public class ClientCall {
	
	public static void main(String[] args) {
		
		String date="2020-11-21";
		int nights=8;
		int rooms=4;
		int id=3;
		
		try {
		URL urlSearch = new URL("http://localhost:8080/WS_Reservation/search/"+date+"/"+nights+"/"+rooms);
	    HttpURLConnection connSearch = (HttpURLConnection) urlSearch.openConnection();
	    connSearch.setRequestMethod("GET");
	    connSearch.setRequestProperty("Accept", "application/json");
	    
	    if (connSearch.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + connSearch.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
            (connSearch.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        
        connSearch.disconnect();
        
        //TODO: proposer une liste et mettre a jour les variables
        
        ClientResource resource = new ClientResource("http://localhost:8080/WS_Reservation/reservation");  
        
		Form form = new Form();  
		form.add("id", Integer.toString(id));  
		form.add("date", date);
		form.add("nights", Integer.toString(nights));
		form.add("rooms", Integer.toString(rooms));
 
		resource.post(form).write(System.out);
 
	    
		} catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	      }
	}
}
