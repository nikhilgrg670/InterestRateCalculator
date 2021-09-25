package com.macquarie.niks.kafka.config;

import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
@EnableKafka
public class ConsumerConfiguration {
	
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String> 
	
	ircMessageConcurrentKafkaListenerConfiguration(
			ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
			ConsumerFactory<String,String> consumerFactory,
			KafkaTemplate<Object, Object> deadLetterTopicTemplate) {
		
		
	ConcurrentKafkaListenerContainerFactory<String, String> 
		ircConcurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
				return ircConcurrentKafkaListenerContainerFactory;
		
	}

}
