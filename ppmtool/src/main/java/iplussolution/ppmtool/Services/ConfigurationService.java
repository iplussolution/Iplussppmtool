package iplussolution.ppmtool.Services;

import iplussolution.ppmtool.Domain.Configuration;
import iplussolution.ppmtool.Repositories.ConfigurationRepository;
import iplussolution.ppmtool.exception.ServiceIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    @Autowired
    ConfigurationRepository configurationRepository;

    public Iterable<Configuration> findConfigurationByBankName(String bankName){
        Iterable<Configuration> cf = configurationRepository.findConfigurationByBankName(bankName);

        if (cf == null)
        {
            throw new ServiceIdException("No configuration for '"+bankName+"' yet");
        }
    return configurationRepository.findConfigurationByBankName(bankName);
    }

    public Configuration saveOrUpdateConfiguration(Configuration cf)
    {
        try {
            cf.setBankName(cf.getBankName().toUpperCase());
            return configurationRepository.save(cf);
        }
       catch(Exception e)
            {
                throw new ServiceIdException("Configuration for '"+cf.getBankName().toUpperCase()+"'already exist");
            }
    }

    public Iterable<Configuration> findAllConfiguration()
    {
        return configurationRepository.findAll();
    }

    public void deleteConfiguration(String bankName)
    {
        Iterable<Configuration> cf = findConfigurationByBankName(bankName);
        if(cf == null)
        {
            throw new ServiceIdException("You can not delete configuration with name '"+bankName+"', because it does not exist");

        }
        configurationRepository.deleteAll(cf);
    }
}
