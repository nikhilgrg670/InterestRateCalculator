package com.macquarie.niks.kafka.listener;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.macquarie.niks.kafka.service.KafkaService;
import com.macquarie.niks.kafka.util.KafkaUtil;

@Service
@EnableKafka
public class KakfaConsumer {
	
	@Autowired
	private KafkaUtil kafkaUtil;
	
	@Autowired
	private KafkaService kafkaService;
	
	@Autowired
	private KafkaTemplate<Object, Object> kafkaTemplate;
	
	@Value("${kafka.error.topic.name}")
	private String errorTopic;
	private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	
	@KafkaListener(topics = "${kafka.consumer.topic.name}" ,
					groupId = "${kafka.consumer.group.id}",
					containerFactory = "ircMessageConcurrentKafkaListenerConfiguration")
	public String consumeDailyFeed( String message, Acknowledgment acknowledgment) {
		
		//TODO: will create messageObject from message
		String messageObj = null ;
		try {
			kafkaService.saveConsumerMessage(messageObj, message);
		} catch(Exception e) {
			//Logging
			kafkaTemplate.send(errorTopic, 0, message);
		} finally {
			acknowledgment.acknowledge();
		}
		
		kafkaService.processDailyFeeds(messageObj, message);
		return messageObj;
	}

}
