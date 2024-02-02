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
		return "¸Û¸Û~";
	}

	abstract public int getAverageWeight(); // ±¸Çö X!!
	
	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

}