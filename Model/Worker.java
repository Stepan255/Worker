package Worker.Model;

import Worker.Helper.IdGenerator;

import java.util.Objects;

public abstract class Worker implements Comparable<Worker> {
    protected int id;
    protected double salaryPerPeriod;
    protected double baseMonthlySalary;
    protected String firstName;
    protected String lastName;

    private Worker(String firstNameWorker, String lastNameWorker, double salaryPerPeriod, int id) {
        firstName = firstNameWorker;
        lastName = lastNameWorker;
        this.salaryPerPeriod = salaryPerPeriod;
        this.id = id;
    }

    public Worker(String firstNameWorker, String lastNameWorker, int id) {
        this(firstNameWorker, lastNameWorker, 0.0, id);
    }

    public Worker(String firstNameWorker, String lastNameWorker) {
        this(firstNameWorker, lastNameWorker, new IdGenerator().getId());
    }

    public abstract void calculateBasicSalaryPerMonth();

    public void setSalaryPerPeriod(double salary, String password) {
        if (Objects.equals(password, "password"))
            this.salaryPerPeriod = salary;
    }

    public void setFirstName(String firstName, String password) {
        if (Objects.equals(password, "password"))
            this.firstName = firstName;
    }

    public void setLastName(String lastName, String password) {
        if (Objects.equals(password, "password"))
            this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public double getBaseMonthlySalary() {
        return baseMonthlySalary;
    }

    public double getSalaryPerPeriod() {
        return salaryPerPeriod;
    }

    public double getBaseMonthlySalary(String password) {
        if (baseMonthlySalary == 0) {
            calculateBasicSalaryPerMonth();
        }
        return baseMonthlySalary;
    }

    @Override
    public String toString() {
        return "[id-" + id + ": firstName-" + firstName + ", lastName-" +
                lastName + ", salaryPerPeriod-" + salaryPerPeriod + ", Salary-" + baseMonthlySalary +"]";
    }

    @Override
    public int compareTo(Worker other) {
        return (int) (this.baseMonthlySalary - other.baseMonthlySalary);
    }

}