package w13.generics.box;

/**
 * 특정 타입 객체만 저장할 수 있는 클래스.
 * 올바른 타입이 사용되는지 컴파일러가 감시해줌
 */
class Generic<T> {
	private T t;
	
	public T get() {
		return this.t;
	}
	
	public void set(T t) {
		this.t = t;
	}
}

public class GenericDemo {

	public static void main(String[] args) {

		Generic<String> container = new Generic<>();
		
		container.set("겨울");
		String str = container.get();	// 형변환
		System.out.println(str);

//		container.set(3);	// 컴파일 에러!!
	}

}
