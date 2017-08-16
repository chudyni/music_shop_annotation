package musicshop.run;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan(basePackages = "musicshop.endpoint")
@ComponentScan(basePackages = "musicshop.endpoint")
public class Config {
	
	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata poller() {
		return Pollers.fixedDelay(1000).get();
	}
	
	@Bean
	public MessageChannel endChannel() {
		return new PublishSubscribeChannel();
	}
	
	@Bean
	public MessageChannel musicItemsPackageChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel guitarsChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel routingChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel fenderChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel gibsonChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel signedFenderChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel signedGibsonChannel() {
		return new DirectChannel();
	}
	
	//TEST
//	@Bean
//	public MessageChannel aggregatorChannel() {
//		return new DirectChannel();
//	}
}
