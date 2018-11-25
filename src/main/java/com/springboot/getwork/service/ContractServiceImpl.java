package com.springboot.getwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.model.Contract;
import com.springboot.getwork.repository.ContractRepository;
import com.springboot.getwork.model.Contract.ContractStatus;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> getAllByJobRequestId(JobRequest jobRequest){
        return contractRepository.findAllByJobRequestId(jobRequest.getId());
    }

    @Override
    public void createContract(Contract contract){
        contractRepository.save(contract);
    }

    @Override
    public Contract getContractInfo(Integer contract_id) {
        return contractRepository.findById(contract_id).get();
    }

    @Override
    public void updateContract(Contract newContract){
        Contract updatedContract = contractRepository.findById(newContract.getId()).get();
        updatedContract.setCreationDate(newContract.getCreationDate());
        updatedContract.setModificationDate(newContract.getModificationDate());
        updatedContract.setContractNumber(newContract.getContractNumber());
        updatedContract.setType(newContract.getType());
        updatedContract.setContractorName(newContract.getContractorName());
        updatedContract.setStartDate(newContract.getStartDate());
        updatedContract.setEndDate(newContract.getEndDate());
        updatedContract.setClosedDate(newContract.getClosedDate());
        updatedContract.setStatus(newContract.getStatus());
        contractRepository.save(updatedContract);
    }

    @Override
    public List<Contract> getContractsByNumberOrStatus(String numberKey, ContractStatus statusKey, Integer jobRequest_id){
        return contractRepository.findContractsByContractNumberOrStatus(numberKey, statusKey, jobRequest_id);
    }

}
