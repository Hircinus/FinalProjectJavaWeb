package com.example.finalprojectspringboot.request;

import com.example.finalprojectspringboot.entity.Company;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    @NotBlank
    private String clientName;
    @NotBlank
    private String description;
    @NotNull
    private long companyId;
}
