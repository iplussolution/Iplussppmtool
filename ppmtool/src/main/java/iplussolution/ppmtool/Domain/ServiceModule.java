package iplussolution.ppmtool.Domain;

//import com.sun.istack.internal.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.aspectj.bridge.Message;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class ServiceModule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long ID;

    @NotBlank(message = "Service Name is required")
    @Column(unique = true)
    private String serviceName;
    @NotBlank(message = "Service Type is required")
    private String serviceType;
    @NotBlank(message = "Service description is required")
    private String serviceDescription;
    @NotBlank(message = "Service identifier is required")
    @Size(min=4, max = 5,message = "Please use 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String serviceIdentifier;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;
    private Date updated_At;

    public ServiceModule()
    {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceIdentifier() {
        return serviceIdentifier;
    }

    public void setServiceIdentifier(String serviceIdentifier) {
        this.serviceIdentifier = serviceIdentifier;
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
