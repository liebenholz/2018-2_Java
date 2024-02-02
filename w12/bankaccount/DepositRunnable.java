package w12.bankaccount;
/**
 * �ݺ������� BankAccount�� �Ա��� �ϴ� Runnable Ŭ����.
 */
public class DepositRunnable implements Runnable {

	private static final int DELAY = 1;
	private BankAccount account;
	private double amount;
	private int count;

	public DepositRunnable(BankAccount anAccount, double anAmount, int c) {
		account = anAccount;
		amount = anAmount;
		count = c;
	}

	public void run() {
		try {
			for (int i = 1; i <= count; i++) {
				account.deposit(amount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {
		}
	}
}