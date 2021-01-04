package fileReadWriteAppend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class App {

	static Path path = Paths.get("src/main/java/fileReadWriteAppend/test.txt");

	public static void main(String[] args) throws IOException {

		CreateFileIfNotExist();
		
		Append("Line 1 \n");
		Append("Line 2 \n");
		Append("Line 3 \n");
		Append("Line 4 \n");
		Append("Line 5 \n");

		ReadFile();

	}

	static void Append(String messageToWrite) throws IOException {

		Files.write(path, messageToWrite.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	}

	static void CreateFileIfNotExist() throws IOException {
		if (!Files.exists(path)) {
			Path filePath = Files.createFile(path);
			System.out.println("Created a file at: " + filePath);
		} else {
			System.out.println("File already exist!");
		}
	}

	static void ReadFile() throws IOException {

		String filePath = "src/main/java/fileReadWriteAppend/test.txt";
		Scanner in = new Scanner(new File(filePath));
		String lineReader;

		while (in.hasNextLine() && !((lineReader = in.nextLine()).equals(null))) {
			System.out.println(lineReader);
		}
		
		in.close();

	}

}
