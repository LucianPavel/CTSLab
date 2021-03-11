package ro.ase.cts.seminar2;

public class Main {
	
	public static void main(String[] args) {
		CurrentAccount acc = new CurrentAccount(300, "IBAN1");
		CurrentAccount acc2 = new CurrentAccount(200, "IBAN2");
		SavingsAccount acc3 = new SavingsAccount(300, "IBAN3");
		System.out.println("Creditul maxim pentru contul curent este " + CurrentAccount.MAX_CREDIT + " RON");
		System.out.println("Suma disponibila este: " + acc.getBalance() + " RON");
		acc.deposit(200);
		System.out.println("Suma disponibila este: " + acc.getBalance() + " RON");
		try {
			acc.withdraw(600);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Suma disponibila este: " + acc.getBalance() + " RON");
		try {
			acc.transfer(200, acc);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		try {
			acc.transfer(200, acc2);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Suma disponibila in contul 1 este: " + acc.getBalance() + " RON");
		System.out.println("Suma disponibila in contul 2 este: " + acc2.getBalance() + " RON");
		System.out.println("Suma disponibila in contul 3 este: " + acc3.getBalance() + " RON");
		acc3.addInterest(10);
		System.out.println("Suma disponibila in contul 3 este: " + acc3.getBalance() + " RON");
		Bank banca = new Bank();
		BankAccount acc4 = banca.openBankAccount(AccountType.CURRENT);
		
		System.out.println((float)15/100);
	}
	
}
