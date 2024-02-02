package w12.bankaccount_condition;

/**
 * �ݺ������� BankAccount�� �Ա��� �ϴ� ������ ���� ���� 
 * �ݺ������� BankAccount���� ����� �ϴ� ������ ���� ����
 * �����Ű�� ���α׷�.
 */
public class BankAccountThreadRunner {
	
	public static void main(String[] args) {
		
		BankAccountWithCondition account = new BankAccountWithCondition();
		
		final double AMOUNT = 100;	// �ŷ� �ݾ�.
		final int REPETITIONS = 10;	// �Ա� Ȥ�� ��� �ݺ� Ƚ��.
		
		final int DEPOSIT_THREADS = 10;	// �Ա� ������ ����.
		final int WITHDRAW_THREADS = 2;	// ��� ������ ����.

		for (int i = 0; i < DEPOSIT_THREADS; i++) {
			DepositRunnable d = new DepositRunnable(account, AMOUNT,
					REPETITIONS);
			Thread t = new Thread(d);
			t.start();
		}

		// �Ա� ������ ������ ��� ������ �������� 5�� ������
		// �� ��� �����尡 ����� �ݺ��ϴ� Ƚ���� 5�� ���� �Ͽ�
		// ��ü �Աݾװ� ��ݾ��� ���� ���� �� �ش�.
		for (int i = 0; i < WITHDRAW_THREADS; i++) {
			WithdrawRunnable d = new WithdrawRunnable(account, AMOUNT,
					REPETITIONS * DEPOSIT_THREADS / WITHDRAW_THREADS);
			Thread t = new Thread(d);
			t.start();
		}
	}
}