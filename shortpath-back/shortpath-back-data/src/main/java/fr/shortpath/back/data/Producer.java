package fr.shortpath.back.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "producer", type = "producer", shards = 1, replicas = 0, refreshInterval = "-1")
public class Producer {

    @Id
    private String login;
}
