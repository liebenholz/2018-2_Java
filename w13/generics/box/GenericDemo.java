package w13.generics.box;

/**
 * Ư�� Ÿ�� ��ü�� ������ �� �ִ� Ŭ����.
 * �ùٸ� Ÿ���� ���Ǵ��� �����Ϸ��� ��������
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
		
		container.set("�ܿ�");
		String str = container.get();	// ����ȯ
		System.out.println(str);

//		container.set(3);	// ������ ����!!
	}

}
