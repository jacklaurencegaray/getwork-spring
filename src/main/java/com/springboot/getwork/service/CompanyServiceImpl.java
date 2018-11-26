package com.springboot.getwork.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company getCompanyInfo(Integer company_id) {
        return companyRepository.findById(company_id).get();
    }

    @Override
    public List<Company> getAll() {
        List<Company> list = new ArrayList<>();
        companyRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Company> search(String key) {
        return companyRepository.getCompaniesByKey(key);
    }

    @Override
    public void updateCompany(Company newCompany){
        Company updatedCompany = companyRepository.findById(newCompany.getId()).orElse(null);
        updatedCompany.setCreationDate(newCompany.getCreationDate());
        updatedCompany.setModificationDate(newCompany.getModificationDate());
        updatedCompany.setCompanyName(newCompany.getCompanyName());
        updatedCompany.setAddress(newCompany.getAddress());
        updatedCompany.setCompanyUrl(newCompany.getCompanyUrl());
        updatedCompany.setTelephoneNumber(newCompany.getTelephoneNumber());
        updatedCompany.setEmail(newCompany.getEmail());
        updatedCompany.setPassword(newCompany.getPassword());
        companyRepository.save(updatedCompany);
    }
}
