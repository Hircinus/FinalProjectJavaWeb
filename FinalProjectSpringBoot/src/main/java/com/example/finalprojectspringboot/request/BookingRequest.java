package com.example.finalprojectspringboot.request;

import com.example.finalprojectspringboot.entity.Company;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    @NotBlank
    private String clientName;
    @NotBlank
    private String description;
    @NotBlank
    private Company company;
}
