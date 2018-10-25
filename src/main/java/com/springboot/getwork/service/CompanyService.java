package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.Company;

public interface CompanyService {
    public Company getCompanyInfo(Integer company_id);
    public List<Company> getAll();
    public void registerCompany(Company company);
    public Company getCompanyByEmailPassword(String email,String password);
}
