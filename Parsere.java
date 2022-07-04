package Worker;

import java.util.ArrayList;

public class Parsere {

	// TODO добавить проверку на валидность данных 
	public ArrayList<Worker> ParseCsv(String rawData){
		ArrayList<Worker> temp = new ArrayList<>();
		String[] tempRawData = rawData.split("\n");
		for (String line : tempRawData) {
			String[] elements = line.split(";");
			// System.out.println(elements[0]);
			temp.add(new Worker(elements[1], elements[2], Integer.parseInt(elements[0])));
		}
		return temp;
	}
	
}
