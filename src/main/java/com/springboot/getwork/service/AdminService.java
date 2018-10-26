package com.springboot.getwork.service;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.Contract;

import java.util.List;

public interface AdminService {

    List<Company> getAllCompanies();

    Company getCompany(Integer company_id);

//    Company getCompanyRequests(Integer company_id);
//
//    Company getRequest(Integer company_id, Integer request_id);
//
//    Company getRequestContracts(Integer company_id, Integer request_id);
//
//    Company getContract(Integer company_id, Integer request_id, Integer contract_id);
//
//    Company updateContract(Integer company_id, Integer request_id, Integer contract_id, Contract contract);
//
//    Company search(String key);

}
