package w14.lambda;

import java.util.function.Consumer;

public class LambdaScopeTest {
	public int x = 0;

	class FirstLevel {
		public int x = 1;
		void methodInFirstLevel(int x) {
			// 아래 문장이 들어가면 컴파일 에러가 납니다.
			// 에러 메시지: “람다식에서 사용하는 지역변수는 final이거나
			//			  effectively final이어야 합니다.”
			// x = 99;

			Consumer<Integer> myConsumer = (y) -> {
				System.out.println("x = " + x); // Statement A
				System.out.println("y = " + y);
				System.out.println("this.x = " + this.x);
				System.out.println("LambdaScopeTest.this.x = " +
						LambdaScopeTest.this.x);
			};

			myConsumer.accept(x);
		}
	}

	public static void main(String[] args) {

		LambdaScopeTest st = new LambdaScopeTest();
		LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
} 
