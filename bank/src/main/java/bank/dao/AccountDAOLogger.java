package bank.dao;

import java.util.Collection;
import bank.domain.Account;

public class AccountDAOLogger implements IAccountDAO{
    
    private final IAccountDAO accountDAO;

    public AccountDAOLogger(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void saveAccount(Account account) {
        accountDAO.saveAccount(account);
        System.out.println("Account DAO Logger => saveAccount");
    }

    @Override
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
        System.out.println("Account DAO Logger => updateAccount");
    }
    
    @Override
    public Account loadAccount(long accountnumber) {
        System.out.println("Account DAO Logger => loadAccount");
        return accountDAO.loadAccount(accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        System.out.println("Account DAO Logger => getAccounts");
        return accountDAO.getAccounts();
    }
    
}
