package w6.dog;

abstract public class Dog {

	protected String name;

	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String speak() {
		return "�۸�~";
	}

	abstract public int getAverageWeight(); // ���� X!!
	
	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

}