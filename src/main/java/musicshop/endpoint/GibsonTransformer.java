package musicshop.endpoint;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import musicshop.domain.item.Gibson;
import musicshop.domain.item.Guitar;

@MessageEndpoint
public class GibsonTransformer {
	
	private static final Logger log = Logger.getLogger(GibsonTransformer.class);

	@Transformer(inputChannel = "gibsonChannel", outputChannel = "signedGibsonChannel")
//	@Transformer(inputChannel = "gibsonChannel", outputChannel = "aggregatorChannel")
	public Gibson signGibson(final Guitar guitar) {
		log.info("Transforming to Gibson");
		return new Gibson(guitar.getMark(), guitar.getName());
	}
}
