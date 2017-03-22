package prep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

public class Chap1Exercises {
	
//	Find average of all the elements in an array
	
	public static double averageIntArray(int[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		return sum / arr.length;
	}

//	Find the sum of all the elements of a two dimensional array
	
	public static int sumTwoDimIntArray(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}
	
//	 Find the largest element in the array.
	
	public static int minOrMax(int[] arr, boolean minimal) {
		int min=0, max=0;
		for (int i = 0; i < arr.length; i++) {
			min = (min > arr[i]) ? arr[i] : min;
			max = (max < arr[i]) ? arr[i] : max;
		}
		
		return (minimal == true) ? min : max;
	}
	
//	Print all the maxima’s in an array. (A value is a maximum if the value before and after its
//			index are smaller than it is or does not exist.)
	
	public static void printMaximasInArray(int[] arr) {
		if(arr.length == 1) {
			System.out.println("Only 1 element in array");
		} else if (arr.length == 2) {
			System.out.println("Only 2 elements in array");
		}
		
		for (int i = 1; i < arr.length-1; i++) {
			if(arr[i-1] < arr[i] && arr[i+1] < arr[i]) {
				System.out.println("\nMaxima found: " + arr[i]);
			}
		}
		return;
		
	}
	
	
//	Given an array with value 0 or 1, write a program to segregate 0 on the left side and 1 on
//	the right side
	
	public static void normalizeArray(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			
			if(arr[start] == 1 && arr[end] == 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
			if(arr[start] == 0) start++;
			if (arr[end] == 1) end--;
		}
		
		System.out.println(Arrays.toString(arr));
	}

	
//	Given a list of intervals, merge all overlapping intervals
	
	public static void mergeOverlappingIntervals(int[][] arr) {
		int[][] result = new int[arr.length][2];
		int counter = 0;
		result[0] = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if(result[counter][0] < arr[i][0] && result[counter][1] >= arr[i][0]) {
				result[counter][1] = arr[i][1];
			} else {
				counter++;
				result[counter] = arr[i];
			}
		}
		
		for(int i = 0; i <= counter; i++)
			System.out.print(Arrays.toString(result[i]));
		System.out.println();
		
	}
	
//	Reverse an array in-place. (You cannot use any additional array in other wards Space
//			Complexity should be O(1). )
	
	public static int[] reverse(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < arr.length/2; i++) {
			int temp=arr[i];
			arr[i] = arr[len-i-1];
			arr[len-i-1] = temp;
		}
//		System.out.println(Arrays.toString(arr));
		return arr;
	}
	
//	Given an array of 0s, 1s and 2s. We need to sort it so that all the 0s are before all the 1s.
//	And all the 1s are before 2s.
//	Hint: Same as above first think 0s and 1s as one group and move all the 2s on the right
//	side. Then do a second pass over the array to sort 0s and 1s
	
	public static int[] zeroOneTwo(int[] arr) {
		int index = arr.length -1;
		while(arr[index] == 2) index--;
		
		for (int i = 0; i < index; i++) {
			if(arr[i] == 2) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index--;
			}
		}
		index--;
		while(index >= 0 && (arr[index] == 1 || arr[index] == 2)) index--;
		
		for (int i = 0; i < index; i++) {
			if(arr[i] == 1) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index--;
			}
		}

		System.out.println(Arrays.toString(arr));
		return arr;
		
		
	}
	
//	Find the duplicate elements in an array of size n where each element is in the
//	range 0 to n-Hint:
//	Maintain a Hash-Table. Set the hash value to 1 if we encounter the element
//	for the first time. When we same value again we can see that the hash value is already 1
//	so we can print that value. O(n) solution, but additional space is required.
	
	
	public static void printDuplicatedElements(int[] arr) {
		Map<Integer,Integer> ht = new HashMap<>();
		ArrayList<Integer> duplicates = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(ht.containsKey(arr[i])) {
				duplicates.add(arr[i]);
			} else {
				ht.put(arr[i], 1);
			}
		}
		
		System.out.print("the duplicate elements are: ");
		for(int i : duplicates) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
//	We will exploit the constraint "every element is in the range 0 to n-1".
//	We can take an array arr[] of size n and set all the elements to 0. Whenever we get a value
//	say val1. We will increment the value at arr[var1] index by 1. In the end, we can traverse
//	the array arr and print the repeated values. Additional Space Complexity will be O(n)
//	which will be less then Hash-Table approach.
	
	public static void printDuplicatedElementsV2(int[] arr, int size) {
		int[] checker = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			checker[arr[i]] += 1;
		}
		
		for (int i = 0; i < checker.length; i++) {
			if(checker[i] > 1) {
				System.out.println("dup item " + i);
			}
		}
		
	}
	
//	Given an array with 'n' elements & a value 'x', find two elements in the array that sums
//	to 'x'.
	
	public static void printSumPairs(int[] input, int sum) {
		Map<Integer, Integer> pairs = new HashMap<>();
		
		for (int i = 0; i < input.length; i++) {
			if (pairs.containsKey(sum-input[i])) {
				System.out.println(input[i] + ", " + (sum-input[i]));
			} else {
				pairs.put(input[i], 1);
			}
		}
		
	}
	
//	Write a method to find the sum of every number in an int number. Example: input= 1984,
//			output should be 32 (1+9+8+4).
	
	public static int inputSum(int input) {

		if (input / 10 == 0) {
			return input;
		}
		
		return (input % 10) + inputSum(input/10);
	}
	
//	Write a method to compute Sum(N) = 1+2+3+…+N
	
	public static int sumN(int n) {
		if(n == 1) {
			return 1;
		}
		return n + sumN(n-1);
		
		
	}
	
}
