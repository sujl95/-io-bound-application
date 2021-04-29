package class101.foo.io;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Producer {

	private final RabbitTemplate rabbitTemplate;

	public void sendTo(String message) {
		rabbitTemplate.convertAndSend("CREATE_POST_QUEUE", message);
	}
}
