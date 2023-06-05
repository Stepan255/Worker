package Worker;

import Worker.Model.Worker;
import Worker.Model.WorkerHourlyPayment;
import Worker.Model.WorkerMonthlyPayment;

import java.util.Arrays;

public class TestingData {
    public static Worker[] getTestDataWorkers() {
        Worker worker1 = new WorkerHourlyPayment("Boris", "Godunov");
        worker1.setSalaryPerPeriod(1000, "password");
        Worker worker2 = new WorkerMonthlyPayment("Masha", "Oreshkina");
        worker2.setSalaryPerPeriod(50000, "password");
        Worker worker3 = new WorkerHourlyPayment("Kiril", "Dunkin");
        worker3.setSalaryPerPeriod(2000, "password");
        Worker worker4 = new WorkerMonthlyPayment("Rita", "Ostapina");
        worker4.setSalaryPerPeriod(100000, "password");
        Worker worker5 = new WorkerHourlyPayment("Olga", "Rastigay");
        worker5.setSalaryPerPeriod(5000, "password");
        worker1.calculateBasicSalaryPerMonth();
        worker2.calculateBasicSalaryPerMonth();
        worker3.calculateBasicSalaryPerMonth();
        worker4.calculateBasicSalaryPerMonth();
        worker5.calculateBasicSalaryPerMonth();
        Worker[] workers = new Worker[]{worker1, worker2, worker3, worker4, worker5};
        Arrays.sort(workers);
        return workers;
    }
}
