package w13.generics.box;

class Old {
	private Object t;
	
	public Object get() {
		return t;
	}
	
	public void set(Object t) {
		this.t = t;
	}
}

public class OldDemo {

	public static void main(String[] args) {

		Old container = new Old();
		
		container.set("겨울");
		String str = (String) container.get();	// 형변환
		System.out.println(str);
		
		container.set(3);
		Integer i = (Integer) container.get();
		System.out.println(i);
	}

}
