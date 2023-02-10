import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);                    // Scanner object.
		System.out.print("Enter Data (Seperated by Spaces): ");
		String UserData = scanner.nextLine();                       // get data.

		int[] int_data = convert_String_into_array(UserData);       //Function to convert string into int type array.

		while (true) {                                                // A loop to keep it running until user select exit.
			System.out.println("1. Arithmetic mean");
			System.out.println("2. Harmonic mean");
			System.out.println("3. Geometric mean");
			System.out.println("4. Median");
			System.out.println("5. Mode");
			System.out.println("6. Exit Program");
			System.out.print("Select Operation: ");
			int selection = scanner.nextInt();

			switch (selection) {
				case 1 -> {
					int Arithmetic_mean = calculate_arithmetic_mean(int_data);
					System.out.println("The Arithmetic mean is: " + Arithmetic_mean);
				}
				case 2 -> {
					double Harmonic_mean = calculate_Harmonic_mean(int_data);
					System.out.println("The Harmonic mean is: " + Harmonic_mean);
				}
				case 3 -> {
					double geometric_mean = calculate_geometric_mean(int_data);
					System.out.println("The Geometric mean is: " + geometric_mean);
				}
				case 4 -> {
					double median = calculate_median(int_data);
					System.out.println("The Median is: " + median);
				}
				case 5 -> {
					int mode = find_mode(int_data);
					System.out.println("The mode is: " + mode);
				}
				case 6 -> System.exit(0);
				default -> System.out.println("**Invalid Choice**");
			}
		}


	}

	// convert String into int type array
	private static int[] convert_String_into_array(String data) {
		String[] rawData = data.split(" ");
		int[] intData = new int[rawData.length];
		for (int i = 0; i < rawData.length; i++) {
			intData[i] = Integer.parseInt(rawData[i]);
		}
		return intData;
	}

	// calculate arithmetic mean
	private static int calculate_arithmetic_mean(int[] data) {
		int sum = 0;
		for (int datum : data) {
			sum += datum;
		}
		return sum / data.length;
	}

	// calculate harmonic mean
	private static double calculate_Harmonic_mean(int[] data) {
		double sum = 0.0;
		for (int datum : data) {
			sum += 1.0 / datum;
		}
		return data.length / sum;
	}

	//calculate geometric mean
	private static double calculate_geometric_mean(int[] data) {
		int product = 1;
		for (int datum : data) {
			product *= datum;
		}
		return Math.pow(product, 1.0 / data.length);
	}

	//calculate median
	private static double calculate_median(int[] data) {
		Arrays.sort(data);
		double median = 0.0;
		if (data.length % 2 == 0) {
			double mid1 = data[(data.length / 2)];
			double mid2 = data[(data.length / 2) - 1];
			median = (mid1 + mid2) / 2;
		} else {
			median = data[data.length / 2];
		}
		return median;
	}

	// find mode
	private static int find_mode(int[] data) {
		int current_count = 1;                            // Initializing necessary variables
		int max_count = 0;
		int mode = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] == data[i - 1]) {
				current_count++;
			} else {
				if (current_count > max_count) {
					max_count = current_count;
					mode = data[i - 1];
				}
				current_count = 1;
			}
		}
		return mode;
	}

}
