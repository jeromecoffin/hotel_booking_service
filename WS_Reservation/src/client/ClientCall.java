package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientCall {
	
	public static void main(String[] args) {
		
		String date="2020-11-21";
		int nights=8;
		int rooms=4;
		int id=0;
		
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
        
        URL urlResevation = new URL("http://localhost:8080/WS_Reservation/reservation/"+id+"/"+date+"/"+nights+"/"+rooms);
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

	      }
	}
}
