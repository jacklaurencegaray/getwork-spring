package com.springboot.getwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.service.CompanyServiceImpl;

@RestController
@CrossOrigin(value = "http://localhost:4200/")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @GetMapping(path = "/getAll")
    public @ResponseBody List<Company> getAllCompanies() {
        // This returns a JSON or XML with the users
        return companyService.getAll();
    }

    @GetMapping(path = "/{company_name}/{company_id}")
    public @ResponseBody Company getCompanyInfo(@PathVariable("company_id") Integer company_id) {
        // This returns a JSON or XML with the users
        return companyService.getCompanyInfo(company_id);
    }

}
