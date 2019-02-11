package com.cg.banking.daoservices;
import java.util.List;
import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InvalidPinNumberException;
public interface AccountDAO {
	Account save(Account account);
	boolean update(Account account);
	Account findOne(long accountNo);
	List<Account> findAll();
}
