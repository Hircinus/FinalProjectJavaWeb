package com.example.finalprojectspringboot.entity;

import com.example.finalprojectspringboot.request.CompanyRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "companies")
@NoArgsConstructor
public class Company {
    @Id @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    public Company(CompanyRequest companyRequest) {
        this.name = companyRequest.getName();
        this.description = companyRequest.getDescription();
    }
}
