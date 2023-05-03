package iplussolution.ppmtool.Services;

import iplussolution.ppmtool.Domain.Bank;
import iplussolution.ppmtool.Repositories.BankRepository;
import iplussolution.ppmtool.exception.ServiceIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankrepository;

    public Bank saveOrUpdate(Bank bk)
    {
        try{
            bk.setBankName(bk.getBankName().toUpperCase());
        return bankrepository.save(bk);
            }
        catch(Exception e)
        {
            throw new ServiceIdException("Bank '"+bk.getBankName().toUpperCase()+"'already exist");
        }
    }

    public Bank findbankByName(String bankName)
    {
        Bank bk = bankrepository.findBankByBankName(bankName);
        if (bk == null)
        {
            throw new ServiceIdException("No record matches bank with name "+bankName);
        }
    return bk;
    }

    public Iterable<Bank> findAllBank()
    {
     return bankrepository.findAll();
    }

    public void deleteBank(String bankName)
    {
        Bank bk = bankrepository.findBankByBankName(bankName);
        if (bk == null)
        {
            throw new ServiceIdException("You can not delete bank with name '"+bankName+"', because it does not exist");

        }
        bankrepository.delete(bk);
    }
}

