package w9.zuul12;

public class Item {
	private String name;
	private String description;
	private int weight;
	
	public Item(String name, String description, int weight) {
		this.name = name;
		this.description = description;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public String getLongDescription() {
		return name + "(weight " + weight + ", " + description + ")";
	}
	
	public int getWeight() {
		return this.weight;
	}
}
