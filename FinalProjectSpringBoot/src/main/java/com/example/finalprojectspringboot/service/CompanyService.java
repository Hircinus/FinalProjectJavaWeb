package com.example.finalprojectspringboot.service;

import com.example.finalprojectspringboot.entity.Company;
import com.example.finalprojectspringboot.exception.ResourceNotFoundException;
import com.example.finalprojectspringboot.repository.CompanyRepository;
import com.example.finalprojectspringboot.request.CompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
    public Company getCompanyById(long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()->new ResourceNotFoundException("company id is not found"));
        return company;
    }
    public Company addCompany(CompanyRequest companyRequest)
    {
        Company company = new Company(companyRequest);

        return companyRepository.save(company);
    }
    public Company updateCompany(long companyId, CompanyRequest companyRequest)
    {
        companyRepository.findById(companyId)
                .orElseThrow(()->new ResourceNotFoundException("company id is not found"));

        Company companyToBeUpdated = new Company(companyRequest);
        companyToBeUpdated.setId(companyId);

        return companyRepository.save(companyToBeUpdated);

    }

    public void deleteCompany(long companyId){
        if(companyRepository.existsById(companyId)){
            companyRepository.deleteById(companyId);
        }
        else{
            throw new ResourceNotFoundException("company id not found");
        }
    }
}