package tps.ws.reservation;


import org.restlet.data.Form;
import org.restlet.representation.Representation;
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
	
	private List<String> messages = new ArrayList<String>();

	@Post
	public List<String> main(Representation entity) {
		
		Form form = new Form(entity);  
        String id = form.getFirstValue("id");  
        String date = form.getFirstValue("date");
        messages.add(id);
        messages.add(date);
		
		/*String date = (String) getRequestAttributes().get("date");
		String reservation = "?date="+date;
		messages.add(reservation);
		
		try {

		URL urlResevation = new URL("http://localhost:8080/WS_Filtering/services/Availability/executerTests"+reservation);
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

        if (connReservation.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                + connReservation.getResponseCode());
        }
        
        BufferedReader brr = new BufferedReader(new InputStreamReader(
                (connReservation.getInputStream())));

            String outputt;
            System.out.println("Output from Server .... \n");
            while ((outputt = brr.readLine()) != null) {
                System.out.println(outputt);
            }
        
        connReservation.disconnect();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();
	        

	     }*/
		return messages;

	    }
} 

