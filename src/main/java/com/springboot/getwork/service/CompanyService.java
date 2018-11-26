package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.Company;

public interface CompanyService {

    Company getCompanyInfo(Integer company_id);
    List<Company> getAll();
    List<Company> search(String key);
    void updateCompany(Company company);

}
