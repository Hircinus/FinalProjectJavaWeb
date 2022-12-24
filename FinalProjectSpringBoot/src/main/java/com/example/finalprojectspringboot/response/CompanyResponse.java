package com.example.finalprojectspringboot.response;

import com.example.finalprojectspringboot.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {
    private long id;
    private String name;
    private String description;
    private Date createdDate;
    private Date updatedDate;
    public CompanyResponse(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.description = company.getDescription();
        this.createdDate = company.getCreatedDate();
        this.updatedDate = company.getUpdatedDate();
    }
}
