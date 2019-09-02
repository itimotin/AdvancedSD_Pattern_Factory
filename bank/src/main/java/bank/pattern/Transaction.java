package bank.pattern;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import bank.dao.*;
import bank.domain.Account;
import bank.mail.*;


public class Transaction {
    private IAccountDAO accountDAO;
    private IEmailSender mailSender;

    public Transaction() {
        try (InputStream input = new FileInputStream("/Users/teamoteen/eclipse-workspace/AdvancedSD_Pattern_Factory/bank/src/main/resources/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            if(prop.getProperty("environment").equalsIgnoreCase("production")){
                this.accountDAO = new AccountDAOLogger(new AccountDAO());
                this.mailSender = EmailSender.getInstance();
            }else{
                 this.accountDAO = new MockAccountDAO();
                this.mailSender = new MockEmailSender();
            }

        } catch (IOException ex) {
        }
    }
    
    public void saveAccount(Account account) {
        accountDAO.saveAccount(account);
        mailSender.notifyThroughMail(account);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
        mailSender.notifyThroughMail(account);
    }

    public Account loadAccount(long accountnumber) {
        return accountDAO.loadAccount(accountnumber);
    }

    public Collection<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

}
