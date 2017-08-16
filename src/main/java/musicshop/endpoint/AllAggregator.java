package musicshop.endpoint;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.MessageEndpoint;

import musicshop.domain.MusicItemsPackage;
import musicshop.domain.item.Guitar;

//@MessageEndpoint
public class AllAggregator {
	
	private static final Logger log = Logger.getLogger(AllAggregator.class);

//	@Aggregator(inputChannel = "aggregatorChannel", outputChannel = "endChannel")
	public MusicItemsPackage collectGuitars(List<Guitar> guitars) {
		log.info("Completing all guitars");
		
		final MusicItemsPackage itemsPackage = new MusicItemsPackage();
		itemsPackage.setItems(guitars);
		itemsPackage.setName("All package");
		return itemsPackage;
	}
}
