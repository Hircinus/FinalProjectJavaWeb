package com.example.finalprojectspringboot.controller;

import com.example.finalprojectspringboot.entity.Company;
import com.example.finalprojectspringboot.request.CompanyRequest;
import com.example.finalprojectspringboot.response.CompanyResponse;
import com.example.finalprojectspringboot.service.CompanyService;
import jakarta.validation.Valid;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins="*")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping() //when empty it maps to the url above
    @CrossOrigin(origins="*")
    public List<CompanyResponse> getAllTeachers() {
        List<Company> companies = companyService.getAllCompanies();
        List<CompanyResponse> companyResponses = new ArrayList<>();
        companies.forEach(company -> {
            CompanyResponse t = new CompanyResponse(company);
            companyResponses.add(t);
        });
        return companyResponses;
    }
    @GetMapping("/{id}") //when empty it maps to the url above
    @CrossOrigin(origins="*")
    public CompanyResponse getTeacherById(@PathVariable long id) {
        Company company = companyService.getCompanyById(id);
        return new CompanyResponse(company);
    }
    @PostMapping()
    @CrossOrigin(origins="*")
    public CompanyResponse addCompany(@Valid @RequestBody CompanyRequest companyRequest)
    {

        Company savedCompany = companyService.addCompany(companyRequest);

        return new CompanyResponse(savedCompany);

    }
    @PutMapping("/{id}")
    @CrossOrigin(origins="*")
    public CompanyResponse updateCompany
            (@PathVariable long id,
             @Valid @RequestBody CompanyRequest companyRequest){

        Company updatedCompany = companyService.updateCompany(id, companyRequest);
        return new CompanyResponse(updatedCompany);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins="*")
    public void deleteTeacher(@PathVariable long id)
    {
        companyService.deleteCompany(id);
    }
}