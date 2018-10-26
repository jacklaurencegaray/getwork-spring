package com.springboot.getwork.controller;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/companies")
    public @ResponseBody List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @GetMapping("/companies/{company_id}")
    public @ResponseBody Company getCompany(@PathVariable("company_id") Integer company_id) {
        return adminService.getCompany(company_id);
    }

    @GetMapping("/companies/{company_id}/requests")
    public @ResponseBody Company getCompanyRequests(@PathVariable("company_id") Integer company_id) {
        return adminService.getCompanyRequests(company_id);
    }

    @GetMapping("/companies/{company_id}/requests/{request_id}")
    public @ResponseBody Company getRequest(@PathVariable("company_id") Integer company_id,
                                            @PathVariable("request_id") Integer request_id) {
        return adminService.getRequest(company_id, request_id);
    }

    @GetMapping("/companies/{company_id}/requests/{request_id}/contracts")
    public @ResponseBody Company getRequestContracts(@PathVariable("company_id") Integer company_id,
                                                     @PathVariable("request_id") Integer request_id) {
        return adminService.getRequestContracts(company_id, request_id);
    }

    @GetMapping("/companies/{company_id}/requests/{request_id}/contracts/{contract_id}")
    public @ResponseBody Company getContract(@PathVariable("company_id") Integer company_id,
                                             @PathVariable("request_id") Integer request_id,
                                             @PathVariable("contract_id") Integer contract_id) {
        return adminService.getContract(company_id, request_id, contract_id);
    }

    @GetMapping("/companies/{company_id}/requests/{request_id}/contracts/{contract_id}")
    public @ResponseBody Company getContract(@PathVariable("company_id") Integer company_id,
                                             @PathVariable("request_id") Integer request_id,
                                             @PathVariable("contract_id") Integer contract_id) {
        return adminService.getContract(company_id, request_id, contract_id);
    }

    @PostMapping("/companies/{company_id}/requests/{request_id}/contracts/{contract_id}/update")
    public @ResponseBody Company updateContract(@PathVariable("company_id") Integer company_id,
                                                @PathVariable("request_id") Integer request_id,
                                                @PathVariable("contract_id") Integer contract_id,
                                                @RequestBody Contract contract) {
        return adminService.updateContract(company_id, request_id, contract_id, contract);
    }

    @PostMapping("/search/{key}")
    public @ResponseBody Company search(@PathVariable("key") String key) {
        return adminService.search(key);
    }

}
