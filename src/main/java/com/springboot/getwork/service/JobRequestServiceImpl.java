package com.springboot.getwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.repository.JobRequestRepository;
import com.springboot.getwork.model.JobRequest.JobStatus;

@Service
public class JobRequestServiceImpl implements JobRequestService {

    @Autowired
    private JobRequestRepository jobRequestRepository;

    @Override
    public List<JobRequest> getAllByCompanyId(Company company){
        return jobRequestRepository.findAllByCompanyId(company.getId());
    }

    @Override
    public void createJobRequest(JobRequest jobRequest){
        jobRequestRepository.save(jobRequest);
    }

    @Override
    public JobRequest getJobRequestInfo(Integer jobRequest_id) {
        return jobRequestRepository.findById(jobRequest_id).get();
    }

    @Override
    public void updateJobRequest(JobRequest newJobRequest){
        JobRequest updatedJobRequest = jobRequestRepository.findById(newJobRequest.getId()).get();
        updatedJobRequest.setCreationDate(newJobRequest.getCreationDate());
        updatedJobRequest.setModificationDate(newJobRequest.getModificationDate());
        updatedJobRequest.setDescription(newJobRequest.getDescription());
        updatedJobRequest.setStartDate(newJobRequest.getStartDate());
        updatedJobRequest.setEndDate(newJobRequest.getEndDate());
        updatedJobRequest.setClosedDate(newJobRequest.getClosedDate());
        updatedJobRequest.setStatus(newJobRequest.getStatus());
        jobRequestRepository.save(updatedJobRequest);
    }

    @Override
    public List<JobRequest> getJobRequestsByNumberOrStatus(String numberKey, JobStatus statusKey, Integer company_id){
        return jobRequestRepository.findJobRequestsByJobRequestNumberOrStatus(numberKey, statusKey, company_id);
    }

}