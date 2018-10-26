package com.springboot.getwork.repository;

import javafx.print.PrinterJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.JobRequest;
import com.springboot.getwork.model.JobRequest.JobStatus;

import java.util.List;

@Repository
public interface JobRequestRepository extends JpaRepository<JobRequest, Integer> {
    List<JobRequest> findAllByCompanyId(Integer companyId);

    //@Query("SELECT j FROM JobRequest j WHERE j.status =(:findkey) OR j.jobRequestNumber like %:findkey% AND j.company_id = (:comp_id)")
    @Query("SELECT j FROM JobRequest j LEFT JOIN j.company c WHERE c.id = (:comp_id) AND j.status = (:statusKey) OR j.jobRequestNumber like %:numberKey%")
    List<JobRequest> findJobRequestsByJobRequestNumberOrStatus(@Param("numberKey") String numberKey, @Param("statusKey") JobStatus statusKey, @Param("comp_id") Integer company_id);
}
