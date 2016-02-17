package fr.shortpath.back.data;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName = "producer", type = "producer", shards = 1, replicas = 0, refreshInterval = "-1")
public class Producer extends People {

    @GeoPointField
    private GeoPoint location; // TODO geopoint

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }
}
