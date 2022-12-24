package com.example.finalprojectspringboot.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}