package com.springboot.getwork.service;

import com.springboot.getwork.model.Company;

public interface HomeService {

    Company getCompanyByEmailPassword(String email,String password);
    void registerCompany(Company company);

}
