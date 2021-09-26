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

/**
 * This class represents kafka consumer which will be used to consume daily feed messages.
 * Assumption is configuration are already defined. 
 * @author abc
 *
 */
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
		String messageObj = getMessageObject(message) ;
		try {
			
			/*
			 * Once we will be able to save the message successfully then we will provide the acknowledgement 
			 * and will be able to move to next offset.*/
			kafkaService.saveConsumerMessage(messageObj, message);
		} catch(Exception e) {
			//Logging
			// NOTE: Failed messages will be sent to dead letter queue.
			kafkaTemplate.send(errorTopic, 0, message);
		} finally {
			acknowledgment.acknowledge();
		}
		
		/* Once a message is read, it will be furthur processed to calculate daily interest.
		 * TODO: to make the following call in async mode. */
		kafkaService.processDailyFeeds(messageObj, message);
		return messageObj;
	}


	//TODO: logic to create message object from message needs to be defined.
	private String getMessageObject(String message) {
		return null;
	}

}
