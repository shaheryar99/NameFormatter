package assignment4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {

// Method to take in all the names
public static ArrayList<String> scanIn() {
	
	//New Array
	ArrayList<String> list = new ArrayList<String>();
	
		// Read file and store in Array
		try {
			Scanner scanner = new Scanner(new File("Names-Old.txt"));
			while (scanner.hasNext()) {
				list.add(scanner.next());
			}
			
			scanner.close();
		}
		catch(IOException e) {
			System.out.println("Something went wrong!");
			System.out.println(e);
		}
		
		// Return the array with all the names
		return (list);
		
	}

// Format the array to our liking, first name, last name.
public static ArrayList<String> arrayFormat() {
	
	// Grab Array from scanIn method
	ArrayList<String> array = scanIn();
	
	//Create new array where everything will be stored
	ArrayList<String> newArray = new ArrayList<String>();
	
	// Attach first and last name from old "array" and store in "newArray"
	for (int i = 0; i < array.size() - 1; i+=2) {
		newArray.add(array.get(i) + " " + array.get(i+1));
	}
	return newArray;
}

// Write everything to file
public static void writeToFile() {
	
	System.out.println("Working the magic...");
	
	// Grab newArray from arrayFormat method
	ArrayList<String> array1 = arrayFormat();
	
	// Try to write all names to file, please note: append is disabled on purpose, so the file will be overwritten with new data 
	try { 
		FileWriter main = new FileWriter("Names-New.txt");
		for (String text : array1) {
			main.write(text + System.lineSeparator());
		}
		System.out.println("Formatted names written to file Names-New.txt in root folder.");
		main.close();
	}
	catch (IOException e) {
		System.out.println("Something went wrong!");
		System.out.println(e);
	}
}

public static void main(String[] args) {
		
		// Call upon method
		writeToFile();
		
	}
	
}
