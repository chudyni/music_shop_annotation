package musicshop.endpoint;

import java.util.List;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import musicshop.domain.MusicItemsPackage;
import musicshop.domain.item.Guitar;

@MessageEndpoint
public class GuitarSplitter {

	@Splitter(inputChannel = "guitarsChannel", outputChannel = "routingChannel")
	public List<Guitar> splitGuitars(final MusicItemsPackage musicItemsPackage) {
		return (List<Guitar>) musicItemsPackage.getItems();
	}
}
