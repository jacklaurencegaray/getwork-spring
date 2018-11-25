package com.springboot.getwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.getwork.model.Contract;
import com.springboot.getwork.repository.ContractRepository;
import com.springboot.getwork.model.Contract.ContractStatus;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> getAllByJobRequestId(Integer jobRequest_id){
        return contractRepository.findAllByJobRequestId(jobRequest_id);
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
        updatedContract.setStatus(newContract.getStatus());
        contractRepository.save(updatedContract);
    }

    public boolean deleteContract(Integer contract_id) {
        Contract contract = contractRepository.findById(contract_id).get();
        ContractStatus status = contract.getStatus();

        if (status != ContractStatus.CLOSED) {
            contractRepository.deleteById(contract_id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Contract> getContractsByNumberOrStatus(String numberKey, ContractStatus statusKey, Integer jobRequest_id){
        return contractRepository.findContractsByContractNumberOrStatus(numberKey, statusKey, jobRequest_id);
    }

}
