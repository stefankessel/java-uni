package uni;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMaker {
	
	static Scanner scIn = new Scanner(System.in);
	
	public static File makeFile(String name) throws IOException{
		File datei = new File(name + ".txt");
		
		if(!datei.exists()) {
			datei.createNewFile();
		}
		return datei;
	}
	public static void writeFile(File datei) throws IOException{
		FileWriter myWriter = new FileWriter(datei);
		System.out.println("Schreib was :)");
		String input = scIn.next();
		myWriter.write(input + " ");
		System.out.println("Wieviele Lieblingsessen hast du?");
		int anzahl = scIn.nextInt();
		
		String [] lieblingsessen = new String[anzahl];
		
		for(int i = 0; i < lieblingsessen.length; i++) {
			System.out.println("Gebe Lieblingsessen Nr. " + (i + 1) + " ein");
			lieblingsessen[i] = scIn.next();
			myWriter.write(lieblingsessen[i] + " ");
		}
		myWriter.close();
	}
	public static void readFile(File datei) throws FileNotFoundException{
		Scanner myReader = new Scanner(datei);
		while(myReader.hasNextLine()) {
			System.out.println(myReader.nextLine());
		}
		myReader.close();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter File name");
		String name = scIn.next();
		try {
			File datei = makeFile(name);
			writeFile(datei);
			readFile(datei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		finally {
			scIn.close();
		}

	}

}
