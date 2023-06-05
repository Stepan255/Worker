package Worker.Repository;

import Worker.Model.Worker;

import java.util.ArrayList;
import java.util.Collections;

// TODO 
public class WorkerRepository {
	private ArrayList<Worker> workerList;

	public WorkerRepository(ArrayList<Worker> workers) {
		this.workerList = workers;
	}

	public ArrayList<Worker> getAll() {
		return this.workerList;
	}

	public void create(Worker ... workers){
		Collections.addAll(this.workerList, workers);
	}

	public Worker getWorkerById(int id) {
		for (Worker worker:
			 workerList) {
			if (worker.getId() == id) {
				return worker;
			}
		}
		throw new RuntimeException("Don't Have worker with id:" + id);
	}

	public String read(){
		StringBuilder text = new StringBuilder("\n");
		if (this.workerList != null) {
			for (Worker worker : workerList) {
				text.append(worker.toString()).append("\n");
			}
		} else {
			return "Репозиторий пуст";
		}
		return text.toString();
	}
}
