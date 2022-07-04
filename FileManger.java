package Worker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileReader;
import java.io.FileWriter;


public class FileManger {

	private String path = "";

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public FileManger(String nameFile) {
		path = getPathFileInDir(nameFile);
	}

	public static String getPathFileInDir(String name) {
		String pathProject = System.getProperty("user.dir");
		String pathFile = pathProject.concat("\\" + name);
		return pathFile;
	}


	private FileReader tryOpenFileToRead(){
		try {
			FileReader file = new FileReader(this.path);
			if (file.ready()){
				return file;
			}else {
				System.out.println("файл: " + this.path + " - не готов к чтению");
			}
		} catch (FileNotFoundException e) {
			System.out.println("файл с путем:" + this.path + "не существует");
		} catch (IOException e) {
			System.out.println("Ошибка ввода/вывода при проверке на чтение");
		}
		return null;
	}

	public String readFile(){
		FileReader file = tryOpenFileToRead();
		String rawData = "";
		if (file != null) {
			int c = 0;
			try {
				while ((c = file.read()) != -1) {
					char ch = (char) c;
					rawData += ch;
				}
				file.close();
			} catch (IOException e) {
				System.out.println("Ошибка ввода/вывода при чтении");
			}
		} else{
			System.out.println("Ошибка при открытии файла для чтения");
		}
		return rawData;
	}

	private Boolean doesTheFileExist(){
		File file = new File(this.path);
		try{
			if (file.createNewFile())
				System.out.println("файл '" + this.path + "' создан");
			return true;
		} catch (Exception e){
			System.out.println("ошибка при создании файла: '" + this.path + "'");
		}
		return false;
	}

	private FileWriter tryFileToRead(Boolean append){
		if (doesTheFileExist()){
			try {
				FileWriter file = new FileWriter(this.path, true);
				return file;
			} catch (IOException e) {
				System.out.println("Ошибка ввода/вывода при проверке на чтение");
			}
		}
		return null;
	}

	public void writeToFile(String text, Boolean append){
		FileWriter file = tryFileToRead(append);
		if (file != null){
			try {
				for (int i = 0; i < text.length(); i++) {
					file.append(text.charAt(i));
				}
			} catch (IOException e) {
				System.out.println("Ошибка при добавлении записи");
			} finally{
				try {
					file.close();
				} catch (IOException e) {
					System.out.println("Ошибка при закрытии");
				}
			}
		}else{
			System.out.println("Ошибка при открытии файла для записи");
		}
		
	}
}
