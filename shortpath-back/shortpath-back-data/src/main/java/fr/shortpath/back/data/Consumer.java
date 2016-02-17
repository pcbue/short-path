package fr.shortpath.back.data;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "consumer", type = "consumer", shards = 1, replicas = 0, refreshInterval = "-1")
public class Consumer extends People {
}
