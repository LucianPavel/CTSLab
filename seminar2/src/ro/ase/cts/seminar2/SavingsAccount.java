package ro.ase.cts.seminar2;

import ro.ase.cts.seminar2.exceptii.IllegalTransferException;
import ro.ase.cts.seminar2.exceptii.InsufficientFundsException;
import ro.ase.cts.seminar2.interfaces.Depositable;
import ro.ase.cts.seminar2.interfaces.Transferable;
import ro.ase.cts.seminar2.interfaces.Withdrawable;

public class SavingsAccount extends BankAccount implements Depositable, Withdrawable, Transferable {

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(double balance, String iban) {
		super(balance, iban);
	}

	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientFundsException {
		if (this.balance >= amount)
			this.balance -= amount;
		else throw new InsufficientFundsException("Fonduri insuficiente");
	}

	@Override
	public void transfer(double amount, Depositable destination) throws IllegalTransferException, InsufficientFundsException {
		if (((BankAccount)destination).iban.equals(this.iban))
			throw new IllegalTransferException("Conturile coincid");
		else {
			this.withdraw(amount);
			((Depositable)destination).deposit(amount);
		}
	}
	
	public void addInterest(double amount) {
		this.deposit(amount);
	}

}
