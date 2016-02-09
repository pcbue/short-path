package fr.shortpath.back.data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "producer", type = "producer", shards = 1, replicas = 0, refreshInterval = "-1")
public class Producer {

    @Id
    private String login;

    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String firstName;

    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String lastName;

    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String email;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time_no_millis)
    private Date created; // TODO jodaTime

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
