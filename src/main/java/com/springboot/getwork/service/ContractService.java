package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.model.Contract;

public interface ContractService {

    public List<Contract> getAllByJobRequestId(JobRequest jobRequest);
    public void createContract(Contract contract);
    public List<Contract> getContractsByNumberOrStatus(String key, Integer jobRequest_id);

}