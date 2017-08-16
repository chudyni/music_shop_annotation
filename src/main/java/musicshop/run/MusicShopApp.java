package musicshop.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import musicshop.domain.MusicItemsPackage;
import musicshop.domain.item.Amplifier;
import musicshop.domain.item.Guitar;
import musicshop.domain.item.GuitarMark;
import musicshop.endpoint.MusicItemsPackageGateway;

@EnableAutoConfiguration
public class MusicShopApp {

	public static void main(String [] args) {
		
		final ConfigurableApplicationContext context = SpringApplication.run(Config.class);
		
		final MusicItemsPackageGateway gateway = context.getBean(MusicItemsPackageGateway.class);
		
		final MusicItemsPackage musicItemPackage = prepareGuitarPackage();
//		final MusicItemsPackage musicItemPackage = prepareAmpPackage();
		
		gateway.gatherMusicItemPackage(musicItemPackage);

		context.close();
	}
	
	private static MusicItemsPackage prepareAmpPackage() {
		final Amplifier amp1 = new Amplifier();
		final MusicItemsPackage musicItemsPackage = new MusicItemsPackage();
		final List<Amplifier> amps = new ArrayList<Amplifier>(Arrays.asList(amp1));
		musicItemsPackage.setItems(amps);
		return musicItemsPackage;
	}
	
	private static MusicItemsPackage prepareGuitarPackage() {
		final Guitar guitar1 = new Guitar(GuitarMark.GIBSON, "SG 400");
		final Guitar guitar2 = new Guitar(GuitarMark.GIBSON, "Les Paul Classic");
		final Guitar guitar3 = new Guitar(GuitarMark.FENDER, "Telecaster");
		
		final List<Guitar> guitars = new ArrayList<Guitar>(Arrays.asList(guitar1, guitar2, guitar3));

		
		final MusicItemsPackage musicItemsPackage = new MusicItemsPackage();
		musicItemsPackage.setItems(guitars);
		
		return musicItemsPackage;
	}
}
