package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.model.JobRequest.JobStatus;

public interface JobRequestService {

    List<JobRequest> getAllByCompanyId(Company company);
    void createJobRequest(JobRequest jobRequest);
    JobRequest getJobRequestInfo(Integer jobRequest_id);
    void updateJobRequest(JobRequest newJobRequest);
    List<JobRequest> getJobRequestsByNumberOrStatus(String numberKey, JobStatus statusKey, Integer company_id);

}
