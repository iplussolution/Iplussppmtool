package iplussolution.ppmtool.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Configuration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long ID;
    @NotBlank(message = "Bank Name is required")
    @Column(unique = true)
    private String bankName;
    @NotBlank(message = "Service Name is required")
    @Column(unique = true)
    private String serviceName;
    @NotBlank(message = "Service Description is required")
    @Column(unique = true)
    private String serviceDescription;
    @NotBlank(message = "Massage Type is required")
    @Column(unique = true)
    private String messageType;
    private String channel;
    private boolean synchronous;

    @NotBlank(message = "Massage Type is required")
    private String status;

    private String inQueue;

    private String outQueue;

    private String webServiceURL;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;

    public Configuration(){

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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public boolean isSynchronous() {
        return synchronous;
    }

    public void setSynchronous(boolean synchronous) {
        this.synchronous = synchronous;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInQueue() {
        return inQueue;
    }

    public void setInQueue(String inQueue) {
        this.inQueue = inQueue;
    }

    public String getOutQueue() {
        return outQueue;
    }

    public void setOutQueue(String outQueue) {
        this.outQueue = outQueue;
    }

    public String getWebServiceURL() {
        return webServiceURL;
    }

    public void setWebServiceURL(String webServiceURL) {
        this.webServiceURL = webServiceURL;
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
