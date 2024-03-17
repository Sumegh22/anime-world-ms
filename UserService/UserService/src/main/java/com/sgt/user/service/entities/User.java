package com.sgt.user.service.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name="name", length = 100)
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings;
}

