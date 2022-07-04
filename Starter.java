package Worker;
public class Starter {
	
	public void start(){
		Interaction inter = new Interaction(new Parsere());
		Gui gui = new Gui(new ConsoleScaner(), inter);
		gui.start();
	}
}
