package Worker;

import java.util.ArrayList;

// TODO 
public class Repository {
	private ArrayList<Worker> workerList;

	public Repository(ArrayList<Worker> workers) {
		this.workerList = workers;
	}

	public ArrayList<Worker> getDb() {
		return this.workerList;
	}

	public void create(Worker ... workers){
		for (Worker worker : workers) {
			this.workerList.add(worker);
		}
	}

	public String read(){
		String text = "\n";
		if (this.workerList != null) {
			for (Worker worker : workerList) {
				text += worker.toString() + "\n";
			}
		} else {
			return "Репозиторий пуст";
		}
		return text; 
	}

	public ArrayList<Worker> getData(){
		return this.workerList;
	}
}
