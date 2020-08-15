package com.example.taskmanager.profile;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name ="email")
    String email;
    @Column(name = "password")
    String password;
    @Lob
    @Column(name = "pic")
    private byte[] pic;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;
}
