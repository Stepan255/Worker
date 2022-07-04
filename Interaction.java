package Worker;

public class Interaction {
	
	Parsere parse;
	Repository repository;

	public Interaction(Parsere parse) {
		this.parse = parse;
	}
	
	// TODO Что делать если файл уже открыт
	public void openFile(String name){
		if (this.repository == null){
			String rawData = new FileManger(name).readFile();
			this.repository = new Repository(parse.ParseCsv(rawData));
			System.out.println("Файл успешно прочитан");
		}else {
			System.out.println("У вас уже открыт файл");
			Logger.getInstance().log("Попытка открыть файл при уже открытом файле");
		}
	}

	public void printData() {
		System.out.println(repository.read());
	}

	public void addWorker(Worker ... workers) {
		repository.create(workers);
	}
}
