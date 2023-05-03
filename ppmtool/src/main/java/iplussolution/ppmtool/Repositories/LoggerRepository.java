package iplussolution.ppmtool.Repositories;

import iplussolution.ppmtool.Domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends CrudRepository<Logger, Long> {

    Logger findLoggerByTransactionId(String transactionID);
    Iterable<Logger> findLoggerByBankName(String bankName);

    @Override
    Iterable<Logger> findAll();
}
