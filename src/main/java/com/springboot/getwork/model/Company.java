package com.springboot.getwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "company") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company {

    public Company() {
    };

    public Company(Integer id,
                   @NotNull @NotEmpty Date creationDate,
                   @NotNull @NotEmpty Date modificationDate,
                   @NotNull @NotEmpty @Size(min = 1, message = "Company name is required.") @Size(max = 254, message = "Company name should not exceed 254 characters.") String companyName,
                   @NotNull @NotEmpty @Size(min = 1, message = "Company address is required.") @Size(max = 254, message = "Company address should not exceed 254 characters.") String address,
                   @NotNull @NotEmpty String companyUrl,
                   @NotNull @NotEmpty String telephoneNumber,
                   @NotNull @NotEmpty @Email(message = "Please provide a valid email") @Size(min = 1, message = "Company email is required.") @Size(max = 254, message = "Company email should not exceed 254 characters.") String email,
                   @NotNull @NotEmpty @Size(min = 1, message = "Password is required.") @Size(max = 16, message = "Password should not exceed 16 characters.") String password
                   ) {
        super();
        this.id = id;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.companyName = companyName;
        this.address = address;
        this.companyUrl = companyUrl;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Integer id;

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    private Date modificationDate;

    @NotNull
    @NotEmpty
    @Column(unique=true)
    @Size(min = 1, message = "Company name is required.")
    @Size(max = 254, message = "Company name should not exceed 254 characters.")
    private String companyName;

    @NotNull
    @NotEmpty
    @Size(min = 1, message = "Company address is required.")
    @Size(max = 254, message = "Company address should not exceed 254 characters.")
    private String address;

    @NotNull
    @NotEmpty
    private String companyUrl;

    @NotNull
    @NotEmpty
    private String telephoneNumber;

    @NotNull
    @NotEmpty
    @Column(unique=true)
    @Email(message = "Please provide a valid email")
    @Size(min = 1, message = "Company email is required.")
    @Size(max = 254, message = "Company email should not exceed 254 characters.")
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 1, message = "Password is required.")
    @Size(max = 16, message = "Password should not exceed 16 characters.")
    private String password;

    public Integer getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
