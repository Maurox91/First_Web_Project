package Object;

public class Department {
	private String ndep;
	private String name;
	
	public Department(String ndep, String name) {
		super();
		this.ndep = ndep;
		this.name = name;
	}

	public String getNdep() {
		return ndep;
	}

	public void setNdep(String ndep) {
		this.ndep = ndep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [ndep=" + ndep + ", name=" + name + "]";
	}
	
}
