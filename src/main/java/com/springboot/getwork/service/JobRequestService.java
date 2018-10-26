package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.model.JobRequest.JobStatus;

public interface JobRequestService {
    public JobRequest getJobRequestInfo(Integer jobRequest_Id);
    public List<JobRequest> getAllByCompanyId(Company company);
    public void createJobRequest(JobRequest jobRequest);
    public List<JobRequest> getJobRequestsByNumberOrStatus(String numberKey, JobStatus statusKey, Integer company_id);
    public void updateJobRequest(JobRequest newJobRequest);

}