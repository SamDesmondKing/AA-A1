package datageneration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DataGenerator {

	public static void main(String[] args) {

		runqueueGenerator(10000, "L3");

	}

	public static void runqueueGenerator(int length, String filename) {
		String fileLine = "";
		ArrayList<Integer> values = new ArrayList<Integer>();

		// Create a shuffled list of specified range
		// Each list contains only unique values.
		for (int i = 1; i <= length; i++) {
			values.add(new Integer(i));
		}
		Collections.shuffle(values);

		// Create output file and FileWriter
		try {
			File myFile = new File(filename + ".txt");
			if (myFile.createNewFile()) {
				System.out.println("File created successfully: " + myFile.getName());
			} else {
				System.out.println("File name already exists.");
				throw new IOException();
			}
			FileWriter output = new FileWriter(myFile);

			// Write to file
			for (int i = 0; i < length; i++) {
				// No new line at end of file.
				if (i == length - 1) {
					fileLine += "EN " + "P" + values.get(i) + " " + values.get(i);
					output.write(fileLine);
				} else {
					fileLine += "EN " + "P" + values.get(i) + " " + values.get(i) + "\n";
					output.write(fileLine);
					fileLine = "";
				}
			}
			output.close();

		} catch (IOException e) {
			System.out.println("Error: IO Exception.");
			e.printStackTrace();
		}
	}

	public static void dataForEnqueue(String filename) {

		// Create output file
		try {
			File myObj = new File(filename + ".txt");
			if (myObj.createNewFile()) {
				System.out.println("File created successfully: " + myObj.getName());
			} else {
				System.out.println("File name already exists.");
			}
		} catch (IOException e) {
			System.out.println("Error: IO Exception.");
			e.printStackTrace();
		}
	}

	public static void dataForDelete(String filename) {

		// Create output file
		try {
			File myObj = new File(filename + ".txt");
			if (myObj.createNewFile()) {
				System.out.println("File created successfully: " + myObj.getName());
			} else {
				System.out.println("File name already exists.");
			}
		} catch (IOException e) {
			System.out.println("Error: IO Exception.");
			e.printStackTrace();
		}
	}

	public static void dataForPrecedingTime(String filename) {

		// Create output file
		try {
			File myObj = new File(filename + ".txt");
			if (myObj.createNewFile()) {
				System.out.println("File created successfully: " + myObj.getName());
			} else {
				System.out.println("File name already exists.");
			}
		} catch (IOException e) {
			System.out.println("Error: IO Exception.");
			e.printStackTrace();
		}
	}
}
