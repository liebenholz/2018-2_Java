package w12.bankaccount;
/**
 * �ݺ������� BankAccount���� ����� �ϴ� Runnable Ŭ����.
 */
public class WithdrawRunnable implements Runnable {
	
	private static final int DELAY = 1;
	private BankAccount account;
	private double amount;
	private int count;

	public WithdrawRunnable(BankAccount anAccount, double anAmount, int c) {
		account = anAccount;
		amount = anAmount;
		this.count = c;
	}

	public void run() {
		try {
			for (int i = 1; i <= count; i++) {
				account.withdraw(amount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {
		}
	}
}