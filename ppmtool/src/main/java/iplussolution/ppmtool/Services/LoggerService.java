package iplussolution.ppmtool.Services;

import iplussolution.ppmtool.Domain.Logger;
import iplussolution.ppmtool.Repositories.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    LoggerRepository loggerRepository;

    public Logger saveOrUpdateLogger(Logger lg)
    {
        lg.setBankName(lg.getBankName().toUpperCase());
         return   loggerRepository.save(lg);
    }

    public Iterable<Logger> findLogs()
    {
      return loggerRepository.findAll();
    }

    public Iterable<Logger> findLogsByBank(String bankName)
    {
       return loggerRepository.findLoggerByBankName(bankName);
    }
}
