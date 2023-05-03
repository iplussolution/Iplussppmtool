package iplussolution.ppmtool.Repositories;

import iplussolution.ppmtool.Domain.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Long> {

  //  Iterable<Configuration> findConfigurationByBankAndServiceName(String bankName, String serviceName);

  //  Configuration findConfigurationByBankName(String bankName);

    Iterable<Configuration> findConfigurationByBankName(String bankName);

    @Override
    Iterable<Configuration> findAll();
}
