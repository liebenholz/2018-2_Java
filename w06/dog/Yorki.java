package w6.dog;

public class Yorki extends Dog {
	
	private static int averageWeight = 4;

	public Yorki(String name) {
		super(name);
	}

	public String speak() {
		return "²¤²¤~";
	}

	@Override
	public String toString() {
		return "Yorki [name=" + name + "]";
	}
	
	public int getAverageWeight() {
		return averageWeight;
	}
}