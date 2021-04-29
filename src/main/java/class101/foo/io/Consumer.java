package class101.foo.io;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Consumer {

	private final ObjectMapper objectMapper;

	private final PostRepository postRepository;

	@RabbitListener(queues = "CREATE_POST_QUEUE")
	public void handler(String message) throws JsonProcessingException {
		Post post = objectMapper.readValue(message, Post.class);
		postRepository.save(post);
	}

}
