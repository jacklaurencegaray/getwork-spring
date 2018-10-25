package com.springboot.getwork.repository;

import javafx.print.PrinterJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.Contract;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findAllByJobRequestId(Integer jobRequestId);

    //@Query("SELECT c FROM Contract c WHERE c.status =(:findkey) OR c.contractNumber like %:findkey% AND c.jobRequest.jobRequest_id = (:jobRequest_id)")
    @Query("SELECT c FROM Contract c LEFT JOIN c.jobRequest j WHERE j.id = (:jobRequest_id) AND c.status = (:findkey) OR c.contractNumber like %:findkey%")
    List<Contract> findContractsByContractNumberOrStatus(@Param("findkey") String findkey, @Param("jobRequest_id") Integer jobRequest_id);
}
