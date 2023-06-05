package Worker;

import Worker.Model.Worker;
import Worker.Model.WorkerHourlyPayment;
import Worker.Model.WorkerMonthlyPayment;

import java.util.ArrayList;

public class Parser {

	public ArrayList<Worker> parseCsv(String rawData){
		ArrayList<Worker> temp = new ArrayList<>();
		String[] tempRawData = rawData.split("\n");
		for (String line : tempRawData) {
			String[] elements = line.split(";");
			if (elements[3].equals("M")) {
				temp.add(new WorkerMonthlyPayment(elements[1], elements[2], Integer.parseInt(elements[0])));
			}else if (elements[3].equals("H")) {
				temp.add(new WorkerHourlyPayment(elements[1], elements[2], Integer.parseInt(elements[0])));
			}
		}
		return temp;
	}

	public String getCSV(ArrayList<Worker> workers) {
		StringBuilder csvFormat = new StringBuilder("\n");
		for (Worker worker :
				workers) {
			csvFormat.append(worker.getId()).append(";")
					.append(worker.getFirstName()).append(";")
					.append(worker.getLastName()).append(";");

		}
		return csvFormat.toString();
	}
	
}
