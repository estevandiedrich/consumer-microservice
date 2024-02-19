package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	@Autowired
	private UserRepository userRepository;
	private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receivegMessage(QueueUser user) {
		QueueUser save = userRepository.save(user);
		logger.info("persisted " + save);
		logger.info("User received is " + user);
	}
}
