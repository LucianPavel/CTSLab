package ro.ase.cts.seminar2;

import ro.ase.cts.seminar2.exceptii.IllegalTransferException;
import ro.ase.cts.seminar2.exceptii.InsufficientFundsException;
import ro.ase.cts.seminar2.interfaces.Depositable;
import ro.ase.cts.seminar2.interfaces.NotificationService;
import ro.ase.cts.seminar2.interfaces.Transferable;
import ro.ase.cts.seminar2.interfaces.Withdrawable;

public class CurrentAccount extends BankAccount implements Depositable, Withdrawable, Transferable {
	
	public static double MAX_CREDIT = 5000;
	private NotificationService notificationService;
	
	public CurrentAccount() {
		super();
	}

	public CurrentAccount(double balance, String iban) {
		super(balance, iban);
	}

	public NotificationService getNotificationService() {
		return notificationService;
	}
	
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientFundsException {
		if (this.balance >= amount) this.balance -= amount;
		else throw new InsufficientFundsException("Fonduri insuficiente");
		if (this.notificationService != null) this.notificationService.sendNotification("s-a extras suma de " + amount);
	}

	@Override
	public void transfer(double amount, Depositable destination) throws IllegalTransferException, InsufficientFundsException {
		if (((BankAccount)destination).iban.equals(this.iban)) throw new IllegalTransferException("Conturile coincid");
		else {
			this.withdraw(amount);
			((Depositable)destination).deposit(amount);
		}
	}

}
