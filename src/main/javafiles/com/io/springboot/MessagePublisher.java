package com.io.springboot;


import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@EnableBinding(Source.class)
public class MessagePublisher {
	@Autowired
	Source source;
	
	@PostMapping(path="/txn")
	public String sendMessage(@RequestBody String payLoad) throws JsonMappingException, JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		Transaction tx = ob.readValue(payLoad, Transaction.class);
		source.output().send(org.springframework.messaging.support.MessageBuilder.withPayload(tx).setHeader("myheader", "myheadervalue").build());
		return "success";
	}

}
