package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.model.JobRequest.JobStatus;

public interface JobRequestService {

    List<JobRequest> getAllByCompanyId(Integer company_id);
    boolean createJobRequest(JobRequest jobRequest);
    JobRequest getJobRequestInfo(Integer jobRequest_id);
    boolean updateJobRequest(JobRequest newJobRequest);
    boolean deleteJobRequest(Integer request_id);
    List<JobRequest> getJobRequestsByNumberOrStatus(String numberKey, JobStatus statusKey, Integer company_id);

}
