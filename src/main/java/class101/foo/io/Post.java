package class101.foo.io;

import lombok.Data;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "post")
public class Post {
    @Id
    private String id;
    private String content;
}
