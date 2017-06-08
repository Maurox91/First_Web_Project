package Object;

import java.sql.Date;

public class Employee {
	private Integer nEmp;
	private Date date;
	private String fName;
	private String lName;
	private Gender gen;
	private Date hireDate;

	public static enum Gender {
		M, F
	}

	public Employee(Integer nEmp, Date date, String fName, String lName, Gender gen, Date hireDate) {
		this.nEmp = nEmp;
		this.date = date;
		this.fName = fName;
		this.lName = lName;
		this.gen = gen;
		this.hireDate = hireDate;
	}

	public Integer getnEmp() {
		return nEmp;
	}

	public void setnEmp(Integer nEmp) {
		this.nEmp = nEmp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Gender getGen() {
		return gen;
	}

	public void setGen(Gender gen) {
		this.gen = gen;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return date + " " + fName + " " + lName + " " + gen + " " + hireDate;
	}
}