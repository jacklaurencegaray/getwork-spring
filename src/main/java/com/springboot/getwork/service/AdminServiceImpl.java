package com.springboot.getwork.service;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.Contract;
import com.springboot.getwork.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        List<Company> list = new ArrayList<>();
        companyRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Company getCompany(Integer company_id) {
        return companyRepository.findById(company_id).get();
    }

    public Company getCompanyRequests(Integer company_id) {
    }

    public Company getRequest(Integer company_id, Integer request_id) {
    }

    public Company getRequestContracts(Integer company_id, Integer request_id) {
    }

    public Company getContract(Integer company_id, Integer request_id, Integer contract_id) {
    }

    public Company updateContract(Integer company_id, Integer request_id, Integer contract_id, Contract contract) {
    }

    public Company search(String key) {
    }

}
