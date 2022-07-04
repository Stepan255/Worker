package Worker;

import java.util.Scanner;

public class ConsoleScaner {
	
	// private static ConsoleScaner consoleScaner = null;

	// private Scanner console = null;
	// private ConsoleScaner(){
	// 	console = new Scanner(System.in);
	// }

	// public static ConsoleScaner getInstance() {
	// 	if (consoleScaner == null) {
	// 		consoleScaner = new ConsoleScaner();
	// 	}
	// 	return consoleScaner;
	// }

	Scanner console = null;

	public ConsoleScaner() {
		console = new Scanner(System.in);
	}


	public String getString(String textToDisplay){
		System.out.print(textToDisplay);
		while (!console.hasNextLine()){
			console = new Scanner(System.in);
		}
		String textOut = console.nextLine();
		return textOut;
	}

	// TODO унести отсюда
	public int getNumber(String fieldName, String textToDisplay, int max, int min){
		int number = -1;
		String text = "Введите " + fieldName + ": ";
		String str = getString(text);
		Boolean firstTry = true;
		do {
			if (!firstTry) {
				String stringFormat = "поле %s должно находиться в диапозоне: %d < %s < %d";
				System.out.println(String.format(stringFormat, fieldName, min, fieldName, max)); // todo др метод
			}
				// while (!isNumeric(str)){
				// 	if (!isInt(str)) {
				// 		System.out.print("Число не целое:");
				// 	} else {
				// 		System.out.print("Вы ввели не число"); // todo др метод
				// 	}
				// 	str =  getString(text);
				// };
			number = Integer.parseInt(str);
		} while (min < number || number < max);
		return number;
	}

	public void close() {
		console.close();
	}

	
}

/**
 * CS ex
 */
class CS extends ConsoleScaner {

	
}