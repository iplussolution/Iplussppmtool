package iplussolution.ppmtool.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Logger {


    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long ID;

    @NotBlank(message = "Bank Name is required")
    private String bankName;

    @Id
    @NotBlank(message = "Transaction ID is required")
    @Column(unique = true)
    private String transactionId;

    private String request;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column()
    private Date updated_At;
    @Column()
    private String status;
    @Column()
    private String response;
    @Column()
    private String transactionType;
    @Column()
    private String system;

    public Logger(){

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @PrePersist
    protected void onCreate()
    {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate()
    {
        this.updated_At = new Date();
    }

}
