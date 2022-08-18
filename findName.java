import duke.*;
import csv.*;

public class findName {
	public static int getRank(int year, String name, String gender) {
		int rank = 0;
		int toReturn = 0;
		FileResource fr = new FileResource("data/yob" + year + ".csv");
		for (CSVRecord currentRow : fr.getCSVParser()) {
			if (currentRow.get(1).equals(gender)) {
				rank++;
			}
			if (currentRow.get(0).equals(name) && currentRow.get(1).equals(gender)) {
				toReturn = rank;
				break;
			}
		}
		if (toReturn != 0) {
			return toReturn;
		} else {
			return -1;
		}
	}

	public static String getName(int year, int rank, String gender) {
		int count = 0;
		String x = null;
		FileResource fr = new FileResource("data/yob" + year + ".csv");
		for (CSVRecord currentRow : fr.getCSVParser()) {
			if (currentRow.get(1).equals(gender)) {
				count++;
			}
			if (currentRow.get(1).equals(gender) && count == rank) {
				x = currentRow.get(0);
			}
		}
		if (x != null) {
			return x;
		} else {
			return "NO NAME";
		}
	}

	public static String whatIsNameInYear(String name, int year, int newYear, String gender) {
		int rank = getRank(year, name, gender);
		String newName = getName(newYear, rank, gender);
		if (newName != null) {
			return newName;
		} else {
			return "No name found";
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
		System.out.println("Your name would be: " + whatIsNameInYear("Piyush", 2007, 2010, "M"));
	}
}