package com.pek.ttlivescoreapi.user.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.hibernate.annotations.Type;
import org.hibernate.usertype.UserType;

public class UserImage {

    @Id
    private long id;

    @Lob
    @Column()
    private byte[] byteArray;
}
