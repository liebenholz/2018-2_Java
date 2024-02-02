package w6.dog;

public class Jindo extends Dog {
	
	private String color; // ����, �Ͼ�, ����
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
		return "����~";
	}

	public int getAverageWeight() {
		return averageWeight;
	}

}