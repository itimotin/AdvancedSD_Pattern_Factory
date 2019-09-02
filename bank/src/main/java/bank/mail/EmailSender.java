package bank.mail;

import bank.domain.Account;

public class EmailSender implements IEmailSender {
    private static final EmailSender emailSender = new EmailSender();
    
    private EmailSender() {
    }

    public static EmailSender getInstance(){
        return emailSender;
    }
    
    @Override
    public void notifyThroughMail(Account account) {
        System.out.println("Email => Hello " + account.getCustomer().getName() + ", Your new balance is : " + account.getBalance());
    }

}