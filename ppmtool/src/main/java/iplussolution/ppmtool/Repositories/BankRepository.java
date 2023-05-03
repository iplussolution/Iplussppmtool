package iplussolution.ppmtool.Repositories;

import iplussolution.ppmtool.Domain.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {

    Bank findBankByBankCode(String bankCode);

    Bank findBankByBankName(String bankName);

    @Override
    Iterable<Bank> findAll();
}
