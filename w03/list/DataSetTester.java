package week3.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSetTester {

	public static void main(String[] args) {
		DataSetTester test = new DataSetTester();
		test.test();
	}
	
	private void test() {
		
		Random r = new Random();
		Rectangle rect;
		BankAccount account;
		DataSet data = new DataSet();
		
		// 2번
		for(int i = 0; i < 100; i++) {
			double w = r.nextDouble() * 100.0;
			double h = r.nextDouble() * 100.0;
			data.add(rect = new Rectangle(w, h));
		}
		
		System.out.print("면적이 가장 큰 Rectangle : ");
		System.out.println(data.getMaximum());
		
		System.out.printf("면적이 가장 큰 Rectangle의 면적 : %,.1f\n", data.getMaximum().getMeasure());
		
		System.out.printf("면적의 평균 : %,.1f\n", data.getAverage());
		System.out.println();
		
		// 3번
		data = new DataSet();
		for(int i = 0; i < 100; i++) {
			account = new BankAccount(r.nextDouble() * 10000.0);
			data.add(account);
		}
		
		System.out.print("가장 잔액이 많은 계좌 : ");
		System.out.println(data.getMaximum());
		
		System.out.print("가장 잔액이 적은 계좌 : ");
		System.out.println(data.getMinimum());
		
		System.out.printf("잔액의 평균 : %,.1f\n", data.getAverage());
		System.out.println();

	}

}