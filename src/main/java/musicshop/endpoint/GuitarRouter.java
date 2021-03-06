package musicshop.endpoint;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import musicshop.domain.item.Guitar;
import musicshop.domain.item.GuitarMark;

@MessageEndpoint
public class GuitarRouter {
	
	private static final Logger log = Logger.getLogger(GuitarRouter.class);

	@Router(inputChannel = "routingChannel")
	public String routeGuitar(final Guitar guitar) {
		log.info("---GuitarRouter---");
		return this.getChannel(guitar);
	}
	
	private String getChannel(final Guitar guitar) {
		String channel = "";
		if(guitar.getMark() == GuitarMark.FENDER) {
			channel = "fenderChannel";
		}
		if(guitar.getMark() == GuitarMark.GIBSON) {
			channel = "gibsonChannel";
		}
		log.info("Routed to " + channel);
		return channel;
	}
}
