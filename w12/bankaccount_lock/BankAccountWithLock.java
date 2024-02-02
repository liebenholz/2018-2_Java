package w12.bankaccount_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountWithLock {

	public static final double MAX_BALANCE = 100000;

	private double balance = 0.0;
	
	private Lock balanceLock = new ReentrantLock();

	public void deposit(double amount) {
		balanceLock.lock();
		try {
			balance += amount;
			System.out.println("�Ա� �� �ܾ�: " + balance);
		} finally {
			balanceLock.unlock();
		}
	}

	public void withdraw(double amount) {
		balanceLock.lock();
		try {
			balance -= amount;
			System.out.println("��� �� �ܾ�: " + balance);
		} finally {
			balanceLock.unlock();
		}
	}

	public double getBalance() {
		return balance;
	}

}