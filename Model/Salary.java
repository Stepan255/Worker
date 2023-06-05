package Worker.Model;

public record Salary(double salary, Period period) {
    public static Salary zeroSalary() {
        return new Salary(0.0, Period.NOT_INSTALLED);
    }
}
