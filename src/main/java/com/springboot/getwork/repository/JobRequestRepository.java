package com.springboot.getwork.repository;

import javafx.print.PrinterJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.JobRequest;

import java.util.List;

@Repository
public interface JobRequestRepository extends JpaRepository<JobRequest, Integer> {
    List<JobRequest> findAllByCompanyId(Integer companyId);

    @Query("SELECT j FROM JobRequest j WHERE j.status =(:findkey) OR j.jobRequestNumber like %:findkey%")
    List<JobRequest> findJobRequestsByJobRequestNumberOrStatus(@Param("key") String findkey);
}
