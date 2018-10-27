package com.springboot.getwork.repository;

import javafx.print.PrinterJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.Contract;
import com.springboot.getwork.model.Contract.ContractStatus;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    List<Contract> findAllByJobRequestId(Integer jobRequestId);

//    to be continued
    Contract findContractByJobRequestIdAndId(Integer jobRequestId, Integer id);

    //@Query("SELECT c FROM Contract c WHERE c.status =(:findkey) OR c.contractNumber like %:findkey% AND c.jobRequest.jobRequest_id = (:jobRequest_id)")
    @Query("SELECT c FROM Contract c LEFT JOIN c.jobRequest j WHERE j.id = (:jobRequest_id) AND c.status = (:statusKey) OR c.contractNumber like %:numberKey%")
    List<Contract> findContractsByContractNumberOrStatus(@Param("numberKey") String numberKey,  @Param("statusKey") ContractStatus statusKey, @Param("jobRequest_id") Integer jobRequest_id);

}
