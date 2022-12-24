package com.example.finalprojectspringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {
    @Id @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @CreatedDate
    @Column(name = "createdDate")
    @GeneratedValue
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @LastModifiedDate
    @Column(name = "updatedDate")
    @GeneratedValue
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}
