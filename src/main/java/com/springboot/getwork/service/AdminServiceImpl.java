package com.springboot.getwork.service;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.Contract;
import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.repository.CompanyRepository;
import com.springboot.getwork.repository.ContractRepository;
import com.springboot.getwork.repository.JobRequestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private CompanyRepository companyRepository;
    private JobRequestRepository jobRequestRepository;
    private ContractRepository contractRepository;

    public List<Company> getAllCompanies() {
        List<Company> list = new ArrayList<>();
        companyRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Company getCompany(Integer company_id) {
        return companyRepository.findById(company_id).get();
    }

    public List<JobRequest> getCompanyRequests(Integer company_id) {
        return jobRequestRepository.findAllByCompanyId(company_id);
    }

    public JobRequest getRequest(Integer company_id, Integer request_id) {
        return jobRequestRepository.findJobRequestByCompanyIdAndId(company_id, request_id);
    }

    public List<Contract> getRequestContracts(Integer company_id, Integer request_id) {
        return contractRepository.findAllByJobRequestId(request_id);
    }

    public Contract getContract(Integer company_id, Integer request_id, Integer contract_id) {
//        return contractRepository.findContractByJobRequestIdAndId(request_id, contract_id);
        return null;
    }

//    public Company updateContract(Integer company_id, Integer request_id, Integer contract_id, Contract contract) {
//    }
//
//    public Company search(String key) {
//    }

}
