package com.springboot.getwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

import com.springboot.getwork.model.Company;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "jobrequest") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class JobRequest {

    public enum JobStatus{
        NEW, INPROGRESS, CLOSED
    }

    public JobRequest() {
    };

    public JobRequest(Integer id,
                      Company company,
                      @NotNull @NotEmpty Date creationDate,
                      @NotNull @NotEmpty Date modificationDate,
                      @NotNull @NotEmpty @Size(min = 11, message = "Key must exactly contain 11 characters.") @Size(max = 11, message = "Key must exactly contain 11 characters.") String jobRequestNumber,
                      @Size(max = 254, message = "Description should not exceed 254 characters.") String description,
                      @NotNull @NotEmpty Date startDate,
                      @NotNull @NotEmpty Date endDate,
                      @NotNull @NotEmpty Date closedDate,
                      @NotNull @NotEmpty JobStatus status
                      ){
        this.id = id;
        this.company = company;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.jobRequestNumber = jobRequestNumber;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.closedDate = closedDate;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotEmpty
    @Basic
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @NotNull
    @NotEmpty
    @Basic
    @Temporal(TemporalType.DATE)
    private Date modificationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @NotNull
    @NotEmpty
    @Column(unique=true)
    @Size(min = 11, message = "Job Request number must exactly contain 11 characters.")
    @Size(max = 11, message = "Job Request number must exactly contain 11 characters.")
    private String jobRequestNumber;


    @Size(max = 254, message = "Description should not exceed 254 characters.")
    private String description;

    @NotNull
    @NotEmpty
    @Basic
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @NotNull
    @NotEmpty
    @Basic
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date closedDate;

    @NotNull
    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private JobStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobRequestNumber() {
        return jobRequestNumber;
    }

    public void setJobRequestNumber(String jobRequestNumber) {
        this.jobRequestNumber = jobRequestNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

}
