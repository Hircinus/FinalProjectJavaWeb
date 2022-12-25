package com.example.finalprojectspringboot.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Getter
@Setter
public class CompanyRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}