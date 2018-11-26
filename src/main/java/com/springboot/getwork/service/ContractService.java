package com.springboot.getwork.service;

import java.util.List;

import com.springboot.getwork.model.Contract;
import com.springboot.getwork.model.Contract.ContractStatus;
import com.springboot.getwork.model.JobRequest;

public interface ContractService {

    List<Contract> getAllByJobRequestId(Integer jobRequest_id);
    boolean createContract(Contract contract, JobRequest jobRequest);
    Contract getContractInfo(Integer contract_Id);
    boolean updateContract(Contract newContract, JobRequest jobRequest);
    boolean deleteContract(Integer contract_id);
    List<Contract> getContractsByNumberOrStatus(String numberKey, ContractStatus statusKey, Integer jobRequest_id);

}
