package w13.generics.comparator;

public class Student extends Human {
	
	public int studentNum;
	
	public Student(String name, int num, int studentNum) {
		super(name, num);
		this.studentNum = studentNum;
	}
	
	public int getStudentNum(){
		return studentNum;
	}
	
	public String toString() {
		return getName() + ":" + getNum() + ":" + getStudentNum();
	}
	
}
