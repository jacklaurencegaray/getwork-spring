package com.springboot.getwork.controller;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.Contract;
import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.service.CompanyServiceImpl;
import com.springboot.getwork.service.ContractServiceImpl;
import com.springboot.getwork.service.JobRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("getwork/admin")
@CrossOrigin(value = "http://localhost:4200/")
public class AdminController {

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private JobRequestServiceImpl jobRequestService;

    @Autowired
    private ContractServiceImpl contractService;

    @GetMapping("/companies")
    public @ResponseBody List<Company> getAllCompanies() {
        return companyService.getAll();
    }

    @GetMapping("/companies/{company_id}")
    public @ResponseBody Company getCompany(@PathVariable("company_id") Integer company_id) {
        return companyService.getCompanyInfo(company_id);
    }

//    @GetMapping("/companies/{company_name}")
//    public @ResponseBody Company getCompanyByName(@PathVariable("company_name") String companyName) {
//        return companyService.getCompanyByName(companyName);
//    }

    @PostMapping("/companies/{company_id}/update")
    public @ResponseBody String updateCompany(@PathVariable("company_id") Integer company_id,
                                                 @Valid @RequestBody Company newCompany) {
        companyService.updateCompany(newCompany);
        return "Updated company";
    }

    @PostMapping("/companies/search/{key}")
    public @ResponseBody List<Company> searchCompanies(@PathVariable("key") String key) {
        return companyService.search(key);
    }

    @GetMapping("/companies/{company_id}/requests")
    public @ResponseBody List<JobRequest> getCompanyRequests(@PathVariable("company_id") Integer company_id) {
        return jobRequestService.getAllByCompanyId(company_id);
    }

    @GetMapping("/companies/{company_id}/requests/{request_id}")
    public @ResponseBody JobRequest getRequest(@PathVariable("request_id") Integer request_id) {
        return jobRequestService.getJobRequestInfo(request_id);
    }

    @DeleteMapping("/companies/{company_id}/requests/{request_id}")
    public @ResponseBody String deleteRequest(@PathVariable("request_id") Integer request_id) {
        String ret;

        if (jobRequestService.deleteJobRequest(request_id)) {
            ret = "Job request deleted";
        } else {
            ret = "Delete was unsuccessful";
        }
        return ret;
    }

    @PostMapping(path = "/companies/{company_id}/requests/search/{key}")
    public @ResponseBody List<JobRequest> searchJobRequest(@PathVariable("company_id") Integer company_id,
                                                           @PathVariable("key") String key) {
        JobRequest.JobStatus statusKey = null;
        try {
            statusKey = JobRequest.JobStatus.valueOf(key);
        } catch(Exception e) {}
        return jobRequestService.getJobRequestsByNumberOrStatus(key, statusKey, company_id);
    }

    @GetMapping("/companies/{company_id}/requests/{request_id}/contracts")
    public @ResponseBody List<Contract> getRequestContracts(@PathVariable("request_id") Integer request_id) {
        return contractService.getAllByJobRequestId(request_id);
    }

    @GetMapping("/companies/{company_id}/requests/{request_id}/contracts/{contract_id}")
    public @ResponseBody Contract getContract(@PathVariable("contract_id") Integer contract_id) {
        return contractService.getContractInfo(contract_id);
    }

    @PostMapping(value = "/companies/{company_id}/requests/{request_id}/contracts/{contract_id}/update")
    public @ResponseBody String updateContract(@PathVariable("request_id") Integer request_id,
                                               @Valid @RequestBody Contract newContract) {
        JobRequest jobRequest = jobRequestService.getJobRequestInfo(request_id);
        newContract.setJobRequest(jobRequest);
        contractService.updateContract(newContract, jobRequest);
        return "Updated contract status";
    }

    @DeleteMapping("/companies/{company_id}/requests/{request_id}/contracts/{contract_id}")
    public @ResponseBody String deleteContract(@PathVariable("contract_id") Integer contract_id) {
        String ret;

        if (contractService.deleteContract(contract_id)) {
            ret = "Contract deleted";
        } else {
            ret = "Delete was unsuccessful";
        }
        return ret;
    }

    @PostMapping(path = "/companies/{company_id}/requests/{request_id}/contracts/search/{key}")
    public @ResponseBody List<Contract> searchContract(@PathVariable("request_id") Integer jobRequest_id,
                                                       @PathVariable("key") String key) {
        Contract.ContractStatus statusKey = null;
        try {
            statusKey = Contract.ContractStatus.valueOf(key);
        } catch(Exception e) {}
        return contractService.getContractsByNumberOrStatus(key, statusKey, jobRequest_id);
    }

}
