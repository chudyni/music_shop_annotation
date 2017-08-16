package musicshop.endpoint;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

import musicshop.domain.MusicItemsPackage;
import musicshop.domain.item.Guitar;
import musicshop.domain.item.MusicItem;

@MessageEndpoint
public class PrintServiceActivator {
	
	private static final Logger log = Logger.getLogger(PrintServiceActivator.class);

	@ServiceActivator(inputChannel = "endChannel", outputChannel = "nullChannel")
	public void print(final Message<MusicItemsPackage> message) {
		log.info("---PrintServiceActivator---");
		
		final MusicItemsPackage itemsPackage = (MusicItemsPackage) message.getPayload();
		log.info(itemsPackage.getName() + " delivered!" + " Size: " + itemsPackage.getItems().size());
		for(MusicItem item : itemsPackage.getItems()) {
			Guitar guitar = (Guitar) item;
			log.info("Guitar " + guitar.getMark().name() + " " + guitar.getName());
		}
	}
}
