package Worker.Interface;

import java.util.Scanner;

public class consoleScanner {

	Scanner console;

	public consoleScanner() {
		console = new Scanner(System.in);
	}


	public String getString(String textToDisplay){
		System.out.print(textToDisplay);
		while (!console.hasNextLine()){
			console = new Scanner(System.in);
		}
		return console.nextLine();
	}

	public int getNumber(String fieldName, String textToDisplay, int max, int min){
		int number = -1;
		String text = "Введите " + fieldName + ": ";
		String str = getString(text);
		boolean firstTry = true;
		do {
			if (!firstTry) {
				String stringFormat = "поле %s должно находиться в диапозоне: %d < %s < %d";
				System.out.println(String.format(stringFormat, fieldName, min, fieldName, max)); // todo др метод
			}
			number = Integer.parseInt(str);
		} while (min < number || number < max);
		return number;
	}

	public void close() {
		console.close();
	}

	
}