package Worker.Model;

public class WorkerMonthlyPayment extends Worker{
    public WorkerMonthlyPayment(String firstNameWorker, String lastNameWorker, int id) {
        super(firstNameWorker, lastNameWorker, id);
    }

    public WorkerMonthlyPayment(String firstNameWorker, String lastNameWorker) {
        super(firstNameWorker, lastNameWorker);
    }

    @Override
    public void calculateBasicSalaryPerMonth() {
        this.baseMonthlySalary = this.salaryPerPeriod;
    }


}
