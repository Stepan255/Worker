package Worker;

import Worker.Helper.FileManger;

public class Logger {
	
	private static Logger logger;
	
	private FileManger fm = null;
	private Logger() {
		fm = new FileManger("log.txt");
	}

	public static Logger getInstance() {
	if (logger == null) {
		logger = new Logger();
	}
	return logger;
	}

	public void log(String text) {
		fm.writeToFile(text, true);
	}
}
