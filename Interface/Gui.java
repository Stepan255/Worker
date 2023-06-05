package Worker.Interface;

import Worker.Controller.Controller;
import Worker.TestingData;
import Worker.Model.WorkerHourlyPayment;
import Worker.Model.WorkerMonthlyPayment;

import java.util.Objects;

public class Gui {

	Boolean power = false;
	Controller controller;
	consoleScanner scanner;

	public Gui(consoleScanner consoleScanner, Controller controller){
		scanner = consoleScanner;
		power = true;
		this.controller = controller;
	}

	public void start(){
		while (power) {
			String command = scanner.getString("Доступные команды: test, add, read, print, setSalaryPerPeriod, stop\nВведите команду: ");
			switch (command) {
				case "add" -> commandAddWorker();
				case "test" -> {
					controller.addWorker(TestingData.getTestDataWorkers());
					this.controller.printData();
				}
				case "read" -> {
					String name = scanner.getString("Текущая дирректория:" + System.getProperty("user.dir") + "\nВведите имя файла: ");
					this.controller.openFile(name);
				}
				case "print" -> this.controller.printData();
				case "setSalaryPerPeriod" -> addSalary();
				case "stop" -> this.power = false;
				default -> {
				}
			}
		}	
	}

	private void addSalary() {
		String password = scanner.getString("Пароль: ");
		String id = scanner.getString("Айди пользователя: ");
		String salary = scanner.getString("Зарплата за период: ");
		try {
			controller.getWorkerById(Integer.parseInt(id))
					.setSalaryPerPeriod(Double.parseDouble(salary), password);
		} catch (Exception e) {
			throw new RuntimeException("Illegal data");
		}
	}

	public void commandAddWorker(){
		String firstName = scanner.getString("Введите имя: ");
		String lastName = scanner.getString("Введите фамилию:");
		String typeSalary;
		do {
			typeSalary = scanner.getString("Тип оплаты сотрудника:");
		} while (!(Objects.equals(typeSalary, "M") || Objects.equals(typeSalary, "H")));
		if (typeSalary.equals("M")) {
			controller.addWorker(new WorkerMonthlyPayment(firstName, lastName));
		}else if (typeSalary.equals("H")) {
			controller.addWorker(new WorkerHourlyPayment(firstName, lastName));
		}
	}
}