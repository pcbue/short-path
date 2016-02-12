package fr.shortpath.frontal.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class Producer {

    @JsonProperty(value = "login", required = true)
    public String login;

    // TODO link to other rest resources
}
