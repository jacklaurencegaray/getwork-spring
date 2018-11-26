package com.springboot.getwork.service;

import java.util.Date;
import java.util.List;

import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.model.JobRequest.JobStatus;
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
    public boolean createContract(Contract contract, JobRequest jobRequest) {
        JobStatus jobRequestStatus = jobRequest.getStatus();
        Date jobRequestStartDate = jobRequest.getStartDate();
        Date jobRequestEndDate = jobRequest.getEndDate();
        Date contractStartDate = contract.getStartDate();
        Date contractEndDate = contract.getEndDate();

        if (jobRequestStatus != JobStatus.CLOSED && (!jobRequestStartDate.after(contractStartDate) &&
                !jobRequestEndDate.before(contractEndDate) && !contractStartDate.after(contractEndDate))) {
            contract.setJobRequest(jobRequest);
            contractRepository.save(contract);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Contract getContractInfo(Integer contract_id) {
        return contractRepository.findById(contract_id).get();
    }

    @Override
    public boolean updateContract(Contract newContract, JobRequest jobRequest) {
        Contract updatedContract = contractRepository.findById(newContract.getId()).get();
        ContractStatus updatedStatus = updatedContract.getStatus();
        Date jobRequestStartDate = jobRequest.getStartDate();
        Date jobRequestEndDate = jobRequest.getEndDate();
        Date newStartDate = newContract.getStartDate();
        Date newEndDate = newContract.getEndDate();

        if (updatedStatus != ContractStatus.CLOSED && (!jobRequestStartDate.after(newStartDate) &&
                !jobRequestEndDate.before(newEndDate) && !newStartDate.after(newEndDate))) {
            updatedContract.setCreationDate(newContract.getCreationDate());
            updatedContract.setModificationDate(newContract.getModificationDate());
            updatedContract.setType(newContract.getType());
            updatedContract.setContractorName(newContract.getContractorName());
            updatedContract.setStartDate(newContract.getStartDate());
            updatedContract.setEndDate(newContract.getEndDate());
            updatedContract.setClosedDate(newContract.getClosedDate());
            updatedContract.setStatus(newContract.getStatus());
            contractRepository.save(updatedContract);
            return true;
        } else {
            return false;
        }
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
