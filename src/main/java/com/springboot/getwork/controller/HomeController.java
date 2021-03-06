package com.springboot.getwork.controller;

import javax.validation.Valid;

import com.springboot.getwork.model.Company;
import com.springboot.getwork.service.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.getwork.model.LoginModel;

/**
 * @author Anthony
 *
 */
@RestController
@RequestMapping("/getwork")
@CrossOrigin(value = "http://localhost:4200/")
public class HomeController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private HomeServiceImpl homeService;

    @GetMapping
    public String home() {
        return "forward:/index.html";
    }

    @PostMapping("/login") // Map ONLY POST Requests
    public @ResponseBody Company login(@RequestParam("email") String email,
                                       @RequestParam("password") String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return homeService.getCompanyByEmailPassword(email, password);
    }

    @PostMapping("/authenticate") // Map ONLY POST Requests
    public @ResponseBody Company authenticate(@RequestBody LoginModel loginCredentials) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return homeService.getCompanyByEmailPassword(loginCredentials.getUsername(), loginCredentials.getPassword());
    }

    @PostMapping(value = "/register") // Map ONLY POST Requests
    public @ResponseBody String register(@Valid @RequestBody Company company) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        homeService.registerCompany(company);
        return "Saved company";
    }

}
