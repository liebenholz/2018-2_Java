package w12.bankaccount_synch;

public class SynchronizedBankAccount {

	public static final double MAX_BALANCE = 100000;

	private double balance = 0.0;

	public synchronized void deposit(double amount) {
		System.out.println(amount + " ÀÔ±Ý");
		balance += amount;
		System.out.println("--> ÀÜ¾× : " + balance);
	}

	public synchronized void withdraw(double amount) {
		System.out.println(amount + " Ãâ±Ý");
		balance -= amount;
		System.out.println("--> ÀÜ¾×: " + balance);
	}

	public double getBalance() {
		return balance;
	}

}