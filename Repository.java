package Worker;

import java.util.ArrayList;

// create read update delete (CRUD) repository
/**
 * 
 */
// TODO 
public class Repository {
	private ArrayList<Worker> workerList;

	// new Repository(parser.parse(rawData))
	public Repository(ArrayList<Worker> workers) {
		this.workerList = workers;
	}

	public ArrayList<Worker> getDb() {
		return this.workerList;
	}
	// TODO 
	public void create(Worker ... workers){
		for (Worker worker : workers) {
			this.workerList.add(worker);
		}
	}

	// TODO 
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

	// TODO 
	public void update(int id){
		
	}

	// TODO 
	public void delete(int ... id){
		
	}

	// TODO
	public void saveReposytory(String path, Boolean add){
		
	}

	// parser.createRawData(getData)
	public ArrayList<Worker> getData(){
		return this.workerList;
	}
}
