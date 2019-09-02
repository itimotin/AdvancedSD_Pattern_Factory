package bank.mail;

import bank.domain.Account;

public interface IEmailSender {
	void notifyThroughMail(Account account);
}