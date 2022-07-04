package Worker;

public class Gui {

	Boolean power = false;
	Interaction interaction;
	ConsoleScaner scaner;

	public Gui(ConsoleScaner consoleScaner, Interaction interaction){
		scaner = consoleScaner;
		power = true;
		this.interaction = interaction;
	}

	public void start(){
		while (power) {
			String command = scaner.getString("Доступные команды: add, read, print, stop\nВведите команду: ");
			switch (command) {
				case "add":
					commandAddWorker();
					break;
				case "read":
					String name = scaner.getString("Текущая дирректория:" + System.getProperty("user.dir") + "\nВведите имя файла: ");
					this.interaction.openFile(name);
					break;
				case "print":
					this.interaction.printData();
					break;
				case "stop":
					this.power = false;
					break;
				default:
					break;
			}
		}	
	}

	public void commandAddWorker(){
		String firstName = scaner.getString("Введите имя: ");
		String lastName = scaner.getString("Введите фамилию:");
		interaction.addWorker(new Worker(firstName, lastName));
	}
}