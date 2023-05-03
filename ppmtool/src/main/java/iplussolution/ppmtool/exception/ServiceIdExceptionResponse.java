package iplussolution.ppmtool.exception;

public class ServiceIdExceptionResponse {
    private String serviceIdentifier;

    public ServiceIdExceptionResponse(String serviceIdentifier)
    {
        this.serviceIdentifier = serviceIdentifier;
    }

    public String getServiceIdentifier() {
        return serviceIdentifier;
    }

    public void setServiceIdentifier(String serviceIdentifier) {
        this.serviceIdentifier = serviceIdentifier;
    }
}
