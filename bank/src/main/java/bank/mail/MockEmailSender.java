package bank.mail;

import bank.domain.Account;

public class MockEmailSender implements IEmailSender {

    @Override
    public void notifyThroughMail(Account account) {
        System.out.println("MockEmail => Hello " + account.getCustomer().getName() + ", Your new balance is : " + account.getBalance());
    }

}
