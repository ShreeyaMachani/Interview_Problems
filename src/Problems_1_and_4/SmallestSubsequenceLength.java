package Problems_1_and_4;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class SmallestSubsequenceLength {

	public static void main(String[] args) {
		// int arr[] = {2, 3, 1, 5, 6, 3, 7, 9, 14, 10, 2, 5};
		// int k = 35;

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements required in the array: ");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the array elements: ");
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.print("Enter the sum value value: ");
		int k = s.nextInt();
		
		int result = smallestSubsequenceLength(arr, k);
		if(result == -1) {
			System.out.println("result = "+result+" and subsequence with sum greater than equal to the given sum is not possible");
		} else {
			System.out.println("The length of the smallest subsequence = " + result);
		}
		
		s.close();
	}

	private static int smallestSubsequenceLength(int[] arr, int k) {
		int sum = 0, result = 0;
		Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
		}

		while (!queue.isEmpty() && sum < k) {
			sum += queue.peek();
			queue.remove();
			result++;
		}

		if (sum < k) {
			return -1;
		}

		return result;
	}

}
