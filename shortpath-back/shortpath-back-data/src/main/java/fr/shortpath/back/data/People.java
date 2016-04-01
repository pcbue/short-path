package fr.shortpath.back.data;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

public abstract class People {

    @Id
    private String login;

    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String denomination;

    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String email;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time_no_millis)
    private LocalDateTime created;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
