package musicshop.endpoint;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import musicshop.domain.MusicItemsPackage;

@MessagingGateway(defaultRequestChannel = "musicItemsPackageChannel")
public interface MusicItemsPackageGateway {

	@Gateway
	void gatherMusicItemPackage(final MusicItemsPackage musicItemPakcage);
}
