package com.springboot.getwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "contract") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contract {

    public enum ContractType{
        BILLBOARD, COMMERCIAL, RADIOAD, POSTER
    }

    public enum ContractStatus{
        NEW, INPROGRESS, CLOSED
    }

    public Contract() {
    };

    public Contract(Integer id,
                    JobRequest jobRequest,
                    @NotNull @NotEmpty Date creationDate,
                    @NotNull @NotEmpty Date modificationDate,
                    @NotNull @NotEmpty @Size(min = 11, message = "Contract number must exactly contain 11 characters.") @Size(max = 11, message = "Contract number must exactly contain 11 characters.") String contractNumber,
                    @NotNull @NotEmpty ContractType type,
                    @NotNull @NotEmpty String contractorName,
                    @NotNull @NotEmpty Date startDate,
                    @NotNull @NotEmpty Date endDate,
                    @NotNull @NotEmpty ContractStatus status){
        this.id = id;
        this.jobRequest = jobRequest;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.contractNumber = contractNumber;
        this.type = type;
        this.contractorName = contractorName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private Integer id;

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    private Date modificationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jobRequest_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private JobRequest jobRequest;

    @NotNull
    @NotEmpty
    @Column(unique=true)
    @Size(min = 11, message = "Contract number must exactly contain 11 characters.")
    @Size(max = 11, message = "Contract number must exactly contain 11 characters.")
    private String contractNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private ContractType type;

    @NotNull
    @NotEmpty
    private String contractorName;

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date closedDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private ContractStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobRequest getJobRequest() {
        return jobRequest;
    }

    public void setJobRequest(JobRequest jobRequest) {
        this.jobRequest = jobRequest;
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

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public ContractType getType() {
        return type;
    }

    public void setType(ContractType type) {
        this.type = type;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
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

    public ContractStatus getStatus() {
        return status;
    }

    public void setStatus(ContractStatus status) {
        this.status = status;
    }


}
