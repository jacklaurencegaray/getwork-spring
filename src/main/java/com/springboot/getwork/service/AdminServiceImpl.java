package com.springboot.getwork.service;

import com.springboot.getwork.model.Contract;
import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.repository.ContractRepository;
import com.springboot.getwork.repository.JobRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private JobRequestRepository jobRequestRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public void updateContract(Contract newContract, JobRequest jobRequest) {
        Contract updatedContract = contractRepository.findById(newContract.getId()).get();
        JobRequest updatedJobRequest = jobRequestRepository.findById(jobRequest.getId()).get();
        updatedContract.setStatus(newContract.getStatus());
        switch (newContract.getStatus()) {
            case NEW:
                updatedJobRequest.setStatus(JobRequest.JobStatus.NEW);
                break;
            case INPROGRESS:
                updatedJobRequest.setStatus(JobRequest.JobStatus.INPROGRESS);
                break;
            case CLOSED:
                updatedJobRequest.setStatus(JobRequest.JobStatus.CLOSED);
                break;
        }
        contractRepository.save(updatedContract);
        jobRequestRepository.save(updatedJobRequest);
    }

}
