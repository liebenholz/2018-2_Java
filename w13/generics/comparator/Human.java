package w13.generics.comparator;

public class Human {
	
	public String name;
	public int num;
	
	public Human(String name, int num){
		this.name = name;
		this.num = num;
	}
	
	public String getName(){
		return name;
	}
	
	public int getNum(){
		return num;
	}
	
	public String toString() {
		return getName() + ":" + getNum();
	}
}
