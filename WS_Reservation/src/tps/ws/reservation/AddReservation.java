package tps.ws.reservation;


import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AddReservation extends ServerResource {
	

	@Post
	public Representation main(Representation entity) {
		
		Representation result = null; 
		
		Form form = new Form(entity);  
        String id = form.getFirstValue("id");  
        String date = form.getFirstValue("date");
        String nights = form.getFirstValue("nights");
        String rooms = form.getFirstValue("rooms");
		
		String reservation = "?id="+id+"&date="+date+"&nights="+nights+"&rooms="+rooms;
		
		result = new StringRepresentation("reservation"+reservation,  
	            MediaType.TEXT_PLAIN);
		
		/*try {

		URL urlResevation = new URL("http://localhost:8080/WS_Filtering/services/Register/executerTests"+reservation);
	    HttpURLConnection connReservation = (HttpURLConnection) urlResevation.openConnection();
	    //connReservation.setDoOutput(true);
	    //connReservation.setRequestMethod("POST");
	    connReservation.setRequestMethod("GET");
	    connReservation.setRequestProperty("Accept", "application/json");

        //inserer donnee de requete precedente
        //String input = "{\"id\":3}";

        //OutputStream os = connReservation.getOutputStream();
        //os.write(input.getBytes());
        //os.flush();

	    if (connReservation.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            throw new RuntimeException("Failed : HTTP error code : "
                + connReservation.getResponseCode());
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connReservation.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        
        connReservation.disconnect();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();
	        

	     }*/
		return result;

	    }
} 

