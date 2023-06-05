package Worker.Model;

public class WorkerHourlyPayment extends Worker{
    public WorkerHourlyPayment(String firstNameWorker, String lastNameWorker, int id) {
        super(firstNameWorker, lastNameWorker, id);
    }

    public WorkerHourlyPayment(String firstNameWorker, String lastNameWorker) {
        super(firstNameWorker, lastNameWorker);
    }

    @Override
    public void calculateBasicSalaryPerMonth() {
        this.baseMonthlySalary = 20.8 * 8.0 * this.salaryPerPeriod;
    }
}
