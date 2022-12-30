package com.yeahbutstill.photoapp.api.gateway;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class GlobalFiltersConfiguration {

	@Order(1)
	@Bean
	public GlobalFilter secondPreFilter() {
		
		return (exchange, chain) -> {
			
			log.info("My second global pre-filter is executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("Third post-filter executed...");
			}));
		};
	}
	
	@Order(2)
	@Bean
	public GlobalFilter thirdPreFilter() {
		
		return (exchange, chain) -> {
			
			log.info("My third global pre-filter is executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("My second post-filter is executed...");
			}));
		};
		
	}
	
	@Order(3)
	@Bean
	public GlobalFilter fourthPreFilter() {
		
		return (exchange, chain) -> {
			
			log.info("My fourth global pre-filter is executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("My first post-filter is executed");
			}));
		};
		
	}

}
