package tps.ws.reservation;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class Main extends Application{
	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a new respective instance of resource.
		Router router = new Router(getContext());
		// Defines routes
		router.attach("/filter/{date}/{nights}/{rooms}", Random.class);
		router.attach("/reservation/{id}", Random.class);
		return router;
	}
}

