package iplussolution.ppmtool.Repositories;

import iplussolution.ppmtool.Domain.ServiceModule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceModule, Long> {

   // Iterable<ServiceModule> findAllBy(Iterable<Long> Iterable);

    ServiceModule findServiceModulesByServiceIdentifier(String serviceIdentifier);

    @Override
    Iterable<ServiceModule> findAll();
}
