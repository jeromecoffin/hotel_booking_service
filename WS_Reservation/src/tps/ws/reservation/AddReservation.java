package tps.ws.reservation;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class AddReservation extends ServerResource {
	
	@Get  
	public String toString() {
		String id = (String) getRequestAttributes().get("id");
		return "Information about user \"" + id + "\" is: <nothing>";  
	}
	
	@Post
    public Representation acceptItem(Representation entity) {  
		Representation result = null;  
        // Parse the given representation and retrieve data
        Form form = new Form(entity);  
        String uid = form.getFirstValue("uid");  
 
        if(uid.equals("123")){ // Assume that user id 123 is existed
        result = new StringRepresentation("User whose uid="+ uid +" is updated",  
            MediaType.TEXT_PLAIN);
        } 

 
        return result;  
    } 
} 

