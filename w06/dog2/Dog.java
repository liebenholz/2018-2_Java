package w6.dog2;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	abstract public int getAverageWeight(); // ���� X!!
	
	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

}