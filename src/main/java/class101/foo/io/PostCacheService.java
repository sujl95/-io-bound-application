package class101.foo.io;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PostCacheService {

	private final PostRepository postRepository;
	private Page<Post> firstPostPage;

	public void updateFirstPostPage() {
		postRepository.findAll(
				PageRequest.of(0, 20, Sort.by("id").descending())
		);
	}

	public Page<Post> getFirstPostPage() {
		return firstPostPage;
	}

}
