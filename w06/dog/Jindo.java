package w6.dog;

public class Jindo extends Dog {
	
	private String color; // °ËÁ¤, ÇÏ¾ç, °¥»ö
	private static int averageWeight = 45;

	public Jindo(String name, String color) {
		super(name);
		this.color = color;
	}

	@Override
	public String toString() {
		return "Jindo [color=" + color + ", name=" + name + "]";
	}

	public String speak() {
		return "ÄÈÄÈ~";
	}

	public int getAverageWeight() {
		return averageWeight;
	}

}