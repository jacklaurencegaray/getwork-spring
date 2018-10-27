package com.springboot.getwork.service;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.Contract;
import com.springboot.getwork.model.JobRequest;

import java.util.List;

public interface AdminService {

    List<Company> getAllCompanies();

    Company getCompany(Integer company_id);

    List<JobRequest> getCompanyRequests(Integer company_id);

    JobRequest getRequest(Integer company_id, Integer request_id);

    List<Contract> getRequestContracts(Integer company_id, Integer request_id);

    Contract getContract(Integer company_id, Integer request_id, Integer contract_id);

//    Company updateContract(Integer company_id, Integer request_id, Integer contract_id, Contract contract);
//
//    Company search(String key);

}
