package com.example.finalprojectspringboot.controller;

import com.example.finalprojectspringboot.entity.Company;
import com.example.finalprojectspringboot.response.CompanyResponse;
import com.example.finalprojectspringboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/companies")

public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping() //when empty it maps to the url above
    public List<CompanyResponse> getAllTeachers() {
        List<Company> companies = companyService.getAllCompanies();
        List<CompanyResponse> companyResponses = new ArrayList<>();
        companies.forEach(company -> {
            CompanyResponse t = new CompanyResponse(company);
            companyResponses.add(t);
        });
        return companyResponses;
    }
}