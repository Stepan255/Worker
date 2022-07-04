package Worker;

import java.util.ArrayList;

public class Worker {
	ArrayList<Worker> listWorkers;
	private int id;
	private int salary = 0;
	private String firstName = "";
	private String lastName = "";

	private Worker(String firstNameWorker, String lastNameWorker, int salary, int id) {
		firstName = firstNameWorker;
		lastName = lastNameWorker;
		this.salary = salary;
		this.id = id;
	}

	public Worker(String firstNameWorker, String lastNameWorker, int id) {
		this(firstNameWorker, lastNameWorker, 0, id);
	}

	public Worker(String firstNameWorker, String lastNameWorker) {
		this(firstNameWorker, lastNameWorker, new IdGenerator().getId());
	}

	public void setSalary(int salary, String password) {
		if (password == "true password")
			this.salary = salary;
	}

	public void setFirstName(String firstName, String password) {
		if (password == "true password")
			this.firstName = firstName;
	}

	public void setLastName(String lastName, String password) {
		if (password == "true password")
			this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		StringBuilder bilder = new StringBuilder();
		bilder.append("(").append(id).append(",").append(firstName).append(",")
		.append(lastName).append(",").append(salary).append(")");
		return bilder.toString();
	}

}