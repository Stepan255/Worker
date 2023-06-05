package Worker;

import Worker.Interface.consoleScanner;
import Worker.Controller.Controller;
import Worker.Interface.Gui;
import Worker.Repository.WorkerRepository;

import java.util.ArrayList;

public class App {
	
	public void start(){
		Controller inter = new Controller(new Parser(), new WorkerRepository(new ArrayList<>()));
		Gui gui = new Gui(new consoleScanner(), inter);
		gui.start();
	}
}
