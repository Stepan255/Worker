package Worker.Controller;

import Worker.Helper.FileManger;
import Worker.Model.Worker;
import Worker.Repository.WorkerRepository;
import Worker.Parser;
import Worker.Logger;

public class Controller {
	
	Parser parse;
	WorkerRepository workerRepository;

	public Controller(Parser parse, WorkerRepository workerRepository) {
		this.parse = parse;
		this.workerRepository = workerRepository;
	}

	public Worker getWorkerById(int id){
		return workerRepository.getWorkerById(id);
	}

	public void openFile(String name){
		if (this.workerRepository == null){
			String rawData = new FileManger(name).readFile();
			this.workerRepository = new WorkerRepository(parse.parseCsv(rawData));
			System.out.println("Файл успешно прочитан");
		}else {
			System.out.println("У вас уже открыт файл");
			Logger.getInstance().log("Попытка открыть файл при уже открытом файле");
		}
	}

	public void printData() {
		System.out.println(workerRepository.read());
	}

	public void addWorker(Worker... workers) {
		workerRepository.create(workers);
	}

	public void saveRepository(String name){
		new FileManger(name).writeToFile(parse.getCSV(workerRepository.getAll()), false);
	}
}
