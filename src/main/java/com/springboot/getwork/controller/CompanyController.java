package com.springboot.getwork.controller;

import java.util.List;

import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.service.JobRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.service.CompanyServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/getwork/{company_id}")
@CrossOrigin(value = "http://localhost:4200/")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private JobRequestServiceImpl jobRequestService;

    @GetMapping(path = "/")
    public @ResponseBody Company getCompanyInfo(@PathVariable("company_id") Integer company_id) {
        return companyService.getCompanyInfo(company_id);
    }

    @GetMapping(path = "/jobrequests")
    public @ResponseBody List<JobRequest> getAllJobRequests(@PathVariable("company_id") Integer company_id) {
        Company company = companyService.getCompanyInfo(company_id);
        return jobRequestService.getAllByCompanyId(company);
    }

    @PostMapping(value = "/jobrequests/create")
    public @ResponseBody String createJobRequest(@PathVariable("company_id") Integer company_id,
                                                 @Valid @RequestBody JobRequest jobRequest) {
        Company company = companyService.getCompanyInfo(company_id);
        jobRequest.setCompany(company);
        jobRequestService.createJobRequest(jobRequest);
        return "Saved job request";
    }

    @GetMapping(path = "/jobrequests/{jobrequest_id}")
    public @ResponseBody JobRequest getJobRequestInfo(@PathVariable("jobrequest_id") Integer jobrequest_id) {
        return jobRequestService.getJobRequestInfo(jobrequest_id);
    }

    @PostMapping(value = "/jobrequests/{jobrequest_id}/update")
    public @ResponseBody String updateJobRequest(@PathVariable("company_id") Integer company_id,
                                                 @Valid @RequestBody JobRequest newJobRequest) {
        Company company = companyService.getCompanyInfo(company_id);
        newJobRequest.setCompany(company);
        jobRequestService.updateJobRequest(newJobRequest);
        return "Updated job request";
    }

    @GetMapping(path = "/jobrequests/search/{key}")
    public @ResponseBody List<JobRequest> search(@PathVariable("company_id") Integer company_id,
                                                 @PathVariable("key") String key) {
        JobRequest.JobStatus statusKey = null;
        try {
            statusKey = JobRequest.JobStatus.valueOf(key);
        } catch(Exception e) {}
        return jobRequestService.getJobRequestsByNumberOrStatus(key, statusKey, company_id);
    }

}
