package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.model.Contract;
import com.springboot.getwork.model.Contract.ContractStatus;

public interface ContractService {

    List<Contract> getAllByJobRequestId(JobRequest jobRequest);
    void createContract(Contract contract);
    Contract getContractInfo(Integer contract_Id);
    void updateContract(Contract newContract);
    List<Contract> getContractsByNumberOrStatus(String numberKey, ContractStatus statusKey, Integer jobRequest_id);

}
