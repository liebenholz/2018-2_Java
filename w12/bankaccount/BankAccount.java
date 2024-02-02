package w12.bankaccount;

public class BankAccount {

	public static final double MAX_BALANCE = 100000;

	private double balance = 0.0;

	public void deposit(double amount) {
		balance += amount;
		System.out.println("�Ա� �� �ܾ�: " + balance);
	}

	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("��� �� �ܾ�: " + balance);
	}

	public double getBalance() {
		return balance;
	}

}