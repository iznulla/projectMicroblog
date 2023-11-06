package com.merylpor.microblog.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@ToString(exclude = "posts")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String name;

    @Column(name = "create_date")
    private Instant createDate;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Posts> posts = new ArrayList<>();
}
