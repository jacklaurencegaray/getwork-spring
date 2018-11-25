package com.springboot.getwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.getwork.model.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("SELECT c FROM Company c  WHERE c.email=(:email) AND c.password= (:password)")
    Company findCompanyByEmailPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT c FROM Company c WHERE c.companyName like %:key%")
    List<Company> getCompaniesByKey(@Param("key") String key);

}
