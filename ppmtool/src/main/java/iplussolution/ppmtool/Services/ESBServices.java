package iplussolution.ppmtool.Services;

import iplussolution.ppmtool.Domain.ServiceModule;
import iplussolution.ppmtool.Repositories.ServiceRepository;
import iplussolution.ppmtool.exception.ServiceIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ESBServices {

    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceModule saveOrUpdate(ServiceModule ser){
    try {
        ser.setServiceIdentifier(ser.getServiceIdentifier().toUpperCase());
        return serviceRepository.save(ser);
    }
    catch (Exception e){
        throw new ServiceIdException("Service ID Identifier '"+ser.getServiceIdentifier().toUpperCase()+"'already exist");
    }
    }

    public ServiceModule findServiceByID(String serviceID)
    {
        ServiceModule sm = serviceRepository.findServiceModulesByServiceIdentifier(serviceID.toUpperCase());
        if(sm == null)
        {
            throw new ServiceIdException("No record matches the ID "+serviceID);
                    }

            return  sm;
    }

    public Iterable<ServiceModule> findAllService()
    {
        return serviceRepository.findAll();
    }

    public void deleteServiceByID(String serviceID)
    {
        ServiceModule serviceModule = serviceRepository.findServiceModulesByServiceIdentifier(serviceID);
        if(serviceModule == null)
        {
            throw new ServiceIdException("You can not delete project with ID '"+serviceID+"', because it does not exist");
        }
        serviceRepository.delete(serviceModule);
    }
}
