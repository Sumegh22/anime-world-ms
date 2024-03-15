package com.sgt.user.service.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name="user_id", length = 100)
    private String name;
    private String email;
    private String about;
}

