package com.springboot.getwork.service;

import com.springboot.getwork.model.Contract;
import com.springboot.getwork.model.JobRequest;

public interface AdminService {

    void updateContract(Contract newContract, JobRequest jobRequest);

}
