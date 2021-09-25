package com.macquarie.niks.kafka.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaPublisher {
	
	@Autowired
	private KafkaTemplate<Object, Object> kafkaTemplate;
	
	public void publishMessage(String messageDTO, String messageHeaders) {
		
		//TODO: some logic to prepare proper message structure
		
		String topicName = null;
		Integer partitionNumber = null;
		String key = null;
		ListenableFuture<SendResult<Object, Object>> future = kafkaTemplate.send(topicName, partitionNumber, key, (Object)messageDTO);
		future.addCallback( new ListenableFutureCallback<SendResult<Object,Object>>() {

			@Override
			public void onFailure(Throwable ex) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(SendResult<Object, Object> result) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	

}
