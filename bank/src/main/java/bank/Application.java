package bank;

import java.util.Collection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Collection;
import java.util.Properties;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
	
		try (OutputStream output = new FileOutputStream("/Users/teamoteen/eclipse-workspace/AdvancedSD_Pattern_Factory/bank/src/main/resources/config.properties")) {
            Properties prop = new Properties();
            // set key and value
            prop.setProperty("environment", "production");
            //prop.setProperty("environment", "test");
            // save properties to project root folder
            prop.store(output, null);
        } catch (IOException io) {
        	System.out.println("Error ocurred: " + io.getLocalizedMessage());
        }
		
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdraw(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


