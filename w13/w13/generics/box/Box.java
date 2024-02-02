package w13.generics.box;

public class Box<T> {
	
	public Box(T t) {
		this.t = t; 
	}
	
	private T t;

	public T getContents() {
		return this.t;
	}

	public void setContents(T t) {
		this.t = t;
	}
}
