package Problems_1_and_4;

import java.util.Arrays;
import java.util.Scanner;

public class MinPlatform {

	public static void main(String[] args) {
		// int arrival[] = { 900, 940, 950, 1100, 1500, 1800 };
		// int departure[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements required in the arrival array: ");
		int n1 = s.nextInt();
		int arrival[] = new int[n1];
		System.out.println("Enter the array elements of the arrival array: ");
		for (int i = 0; i < n1; i++) {
			arrival[i] = s.nextInt();
		}
		
		System.out.println("Enter the number of elements required in the departure array: ");
		int n2 = s.nextInt();
		int departure[] = new int[n1];
		System.out.println("Enter the array elements of the departure array: ");
		for (int i = 0; i < n2; i++) {
			departure[i] = s.nextInt();
		}

		Arrays.sort(arrival);
		Arrays.sort(departure);
		int n = arrival.length;

		int result = minPlatformRequired(arrival, departure, n);
		System.out.println("Minimum number of platforms required by the railway station = " + result);
		s.close();
	}

	private static int minPlatformRequired(int[] arrival, int[] departure, int n) {
		int i = 1, j = 0;
		int min_platform = 1;
		int result = 1;

		while (i < n && j < n) {
			if (arrival[i] <= departure[j]) {
				min_platform++;
				i++;
			} else if (arrival[i] > departure[j]) {
				min_platform--;
				j++;
			}
			if (min_platform > result) {
				result = min_platform;
			}
		}
		return result;
	}
}
