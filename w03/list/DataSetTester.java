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
		
		// 2¹ø
		for(int i = 0; i < 100; i++) {
			double w = r.nextDouble() * 100.0;
			double h = r.nextDouble() * 100.0;
			data.add(rect = new Rectangle(w, h));
		}
		
		System.out.print("¸éÀûÀÌ °¡Àå Å« Rectangle : ");
		System.out.println(data.getMaximum());
		
		System.out.printf("¸éÀûÀÌ °¡Àå Å« RectangleÀÇ ¸éÀû : %,.1f\n", data.getMaximum().getMeasure());
		
		System.out.printf("¸éÀûÀÇ Æò±Õ : %,.1f\n", data.getAverage());
		System.out.println();
		
		// 3¹ø
		data = new DataSet();
		for(int i = 0; i < 100; i++) {
			account = new BankAccount(r.nextDouble() * 10000.0);
			data.add(account);
		}
		
		System.out.print("°¡Àå ÀÜ¾×ÀÌ ¸¹Àº °èÁÂ : ");
		System.out.println(data.getMaximum());
		
		System.out.print("°¡Àå ÀÜ¾×ÀÌ ÀûÀº °èÁÂ : ");
		System.out.println(data.getMinimum());
		
		System.out.printf("ÀÜ¾×ÀÇ Æò±Õ : %,.1f\n", data.getAverage());
		System.out.println();

	}

}