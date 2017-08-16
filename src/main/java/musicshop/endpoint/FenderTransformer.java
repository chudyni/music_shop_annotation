package musicshop.endpoint;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import musicshop.domain.item.Fender;
import musicshop.domain.item.Guitar;

@MessageEndpoint
public class FenderTransformer {
	
	private static final Logger log = Logger.getLogger(FenderTransformer.class);

	@Transformer(inputChannel = "fenderChannel", outputChannel = "signedFenderChannel")
//	@Transformer(inputChannel = "fenderChannel", outputChannel = "aggregatorChannel")
	public Fender signFender(final Guitar guitar) {
		log.info("Transforming to Fender");
		return new Fender(guitar.getMark(), guitar.getName());
	}
}
