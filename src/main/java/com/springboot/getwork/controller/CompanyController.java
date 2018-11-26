package com.springboot.getwork.controller;

import java.util.List;

import com.springboot.getwork.model.*;
import com.springboot.getwork.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/getwork/{company_id}")
@CrossOrigin(value = "http://localhost:4200/")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private JobRequestServiceImpl jobRequestService;

    @Autowired
    private ContractServiceImpl contractService;

    @GetMapping
    public @ResponseBody Company getCompanyInfo(@PathVariable("company_id") Integer company_id) {
        return companyService.getCompanyInfo(company_id);
    }

    @GetMapping(path = "/jobrequests")
    public @ResponseBody List<JobRequest> getAllJobRequests(@PathVariable("company_id") Integer company_id) {
        return jobRequestService.getAllByCompanyId(company_id);
    }

    @PostMapping(value = "/jobrequests/create")
    public @ResponseBody String createJobRequest(@PathVariable("company_id") Integer company_id,
                                                 @Valid @RequestBody JobRequest jobRequest) {
        Company company = companyService.getCompanyInfo(company_id);
        jobRequest.setCompany(company);
        if (jobRequestService.createJobRequest(jobRequest)) {
            return "Saved job request";
        } else {
            return "Job request not saved";
        }
    }

    @GetMapping(path = "/jobrequests/{jobrequest_id}")
    public @ResponseBody JobRequest getJobRequestInfo(@PathVariable("jobrequest_id") Integer jobrequest_id) {
        return jobRequestService.getJobRequestInfo(jobrequest_id);
    }

    @PostMapping(value = "/jobrequests/{jobrequest_id}/update")
    public @ResponseBody String updateJobRequest(@PathVariable("company_id") Integer company_id,
                                                 @Valid @RequestBody JobRequest newJobRequest) {
        Company company = companyService.getCompanyInfo(company_id);
        if (jobRequestService.updateJobRequest(newJobRequest)) {
            return "Updated job request";
        } else {
            return "Job request not updated";
        }
    }

    @GetMapping(path = "/jobrequests/search/{key}")
    public @ResponseBody List<JobRequest> searchJobRequest(@PathVariable("company_id") Integer company_id,
                                                           @PathVariable("key") String key) {
        JobRequest.JobStatus statusKey = null;
        try {
            statusKey = JobRequest.JobStatus.valueOf(key);
        } catch(Exception e) {}
        return jobRequestService.getJobRequestsByNumberOrStatus(key, statusKey, company_id);
    }

    @DeleteMapping("/jobrequests/{request_id}")
    public @ResponseBody String deleteRequest(@PathVariable("request_id") Integer request_id) {
        String ret;

        if (jobRequestService.deleteJobRequest(request_id)) {
            ret = "Job request deleted";
        } else {
            ret = "Delete was unsuccessful";
        }
        return ret;
    }

    @GetMapping(path = "/jobrequests/{jobrequest_id}/contracts")
    public @ResponseBody List<Contract> getAllContracts(@PathVariable("jobrequest_id") Integer jobRequest_id) {
        return contractService.getAllByJobRequestId(jobRequest_id);
    }

    @PostMapping(value = "/jobrequests/{jobrequest_id}/contracts/create")
    public @ResponseBody String createContract(@PathVariable("jobrequest_id") Integer jobRequest_id,
                                               @Valid @RequestBody Contract contract) {
        JobRequest jobRequest = jobRequestService.getJobRequestInfo(jobRequest_id);
        if (contractService.createContract(contract, jobRequest)) {
            return "Contract saved";
        } else {
            return "Contract not saved";
        }
    }

    @GetMapping(path = "/jobrequests/{jobrequest_id}/contracts/{contract_id}")
    public @ResponseBody Contract getContractInfo(@PathVariable("contract_id") Integer contract_id) {
        return contractService.getContractInfo(contract_id);
    }

    @PostMapping(value = "/jobrequests/{jobrequest_id}/contracts/{contract_id}/update")
    public @ResponseBody String updateContract(@PathVariable("jobrequest_id") Integer jobrequest_id,
                                               @Valid @RequestBody Contract newContract) {
        JobRequest jobRequest = jobRequestService.getJobRequestInfo(jobrequest_id);
        if (contractService.updateContract(newContract, jobRequest)) {
            return "Updated contract";
        } else {
            return "Contract not updated";
        }
    }

    @GetMapping(path = "/jobrequests/{jobrequest_id}/contracts/search/{key}")
    public @ResponseBody List<Contract> searchContract(@PathVariable("jobrequest_id") Integer jobRequest_id,
                                                       @PathVariable("key") String key) {
        Contract.ContractStatus statusKey = null;
        try {
            statusKey = Contract.ContractStatus.valueOf(key);
        } catch(Exception e) {}
        return contractService.getContractsByNumberOrStatus(key, statusKey, jobRequest_id);
    }

    @DeleteMapping("/jobrequests/{request_id}/contracts/{contract_id}")
    public @ResponseBody String deleteContract(@PathVariable("contract_id") Integer contract_id) {
        String ret;

        if (contractService.deleteContract(contract_id)) {
            ret = "Contract deleted";
        } else {
            ret = "Delete was unsuccessful";
        }
        return ret;
    }

}
