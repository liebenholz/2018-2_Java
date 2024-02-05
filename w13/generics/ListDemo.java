package w13.generics;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List<Number> list = new ArrayList<Number>();
		list.add(new Integer(10));   // OK
		list.add(new Double(10.1));  // OK

		for(Number n : list) 
			System.out.println(n);
	}

}
