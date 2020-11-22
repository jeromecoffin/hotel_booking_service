package tps.ws.reservation;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SearchAvailability extends ServerResource {
	
	@Get  
	public String toString() {
		String date = (String) getRequestAttributes().get("date");
		String nights = (String) getRequestAttributes().get("nights");
		String rooms = (String) getRequestAttributes().get("rooms");
		
		return "Information about user \"" + date + nights + rooms + "\" is: <nothing>";  
	}  
}  