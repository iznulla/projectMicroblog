package com.merylpor.microblog.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Data
@Entity
//@ToString(exclude = "user")
@Table(name = "posts")
public class PostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    private Instant timestamp;


    @Override
    public String toString() {
        return "PostsEntity{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", timestamp=" + timestamp +
                ", user=" + user +
                '}';
    }
}
