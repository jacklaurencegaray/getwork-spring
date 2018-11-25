package com.springboot.getwork.service;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    @Transactional(rollbackOn = Exception.class)
    public Company getCompanyByEmailPassword(String email, String password){
        Company company =  companyRepository.findCompanyByEmailPassword(email,password);
        return company;
    }

    @Override
    public void registerCompany(Company company) {
        companyRepository.save(company);
    }

}
