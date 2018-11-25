package com.springboot.getwork.service;

import java.util.ArrayList;
import java.util.List;

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

}
