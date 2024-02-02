package w13.generics;

import java.util.Arrays;

class ArrayReverser {
	public static void reverse(Number[] array) {
		Number[] b = new Number[5];
		for(int i = 0; i < 5; i++)
			b[i] = array[i];
		for(int i = 4; i >= 0; i--)
			array[i] = b[4-i];
	}
}

public class ArrayReverserTest {

	public static void main(String[] args) {
		Number[] a = new Number[5];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = -1;
		a[4] = 3;
		System.out.println(Arrays.toString(a));
		
		ArrayReverser.reverse(a);
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		// ArrayReverser.reverse 메소드를 이용하여
		// Double[]의 원소 순서를 바꿀 수 있나?
		
		// Double은 Number에 포함되어있기 때문에 가능하다
	}

}
