package prep.arrays;

import java.awt.print.PrinterAbortException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,10,12,15,16,17,20,33,44};
		System.out.println(binarySearch(arr, 12));
		
		rotateArray(arr, 1);
		pritntArray(arr);
		
		int[] arr1 = {1,-2,3,4,-4,6,-14,8,2};
		System.out.println(maxContiguousSum(arr1));
		
		printInt10(456);
		
		permutate(new int[] {1,2,3,4}, 0);
		
		Chap1Exercises.printMaximasInArray(new int[] {1,2,3,2,4,3});
		Chap1Exercises.normalizeArray(new int[] {1,1,0,1,0,0});
		Chap1Exercises.mergeOverlappingIntervals(new int[][] {{1,2}, {2,5}, {6,7}});
		Chap1Exercises.reverse(new int[] {1,2,4,4});
		Chap1Exercises.zeroOneTwo(new int[] {0,2,1,1,1,1,2,2,2,2,0});
		Chap1Exercises.printDuplicatedElements(new int[] {1,2,3,4,5,6,7,8,1,8});
		Chap1Exercises.printDuplicatedElementsV2(new int[] {1,2,3,4,5,6,7,8,1,8}, 10);
		Chap1Exercises.printSumPairs(new int[] {2,45,7,3,5,1,8,9}, 8);
		System.out.println(Chap1Exercises.inputSum(1984));
		System.out.println(Chap1Exercises.sumN(6));
	}
	
	
	
	//Binary search array
	private static int binarySearch(int[] arr, int value) {
		
		int mid;
		int low = 0;
		int high = arr.length -1;
		
		while(low <= high) {
			mid = low + (high - low)/2;
			
			if(arr[mid] == value) {
				return mid;
			} else if (arr[mid] > value) {
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//rotating array x positions
	private static void rotateArray(int[] arr, int offset) {
		
		reverseArray(arr, 0, offset-1);
		reverseArray(arr, offset, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
		
		
	}
	
	private static void reverseArray(int[] arr, int start, int end) {
		for(int i=start,j=end;i<j;i++,j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
		
	}
	
	private static void pritntArray(int[] arr) {
		for(int n: arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	//max contiguous sum array
	private static int maxContiguousSum(int[] arr) {
		int max=0, maxCurrent=0;
		
		for (int i = 0; i < arr.length; i++) {
			maxCurrent = maxCurrent + arr[i];
			if(max < maxCurrent) {
				max = maxCurrent;
			}
			if(maxCurrent<0) {
				maxCurrent = 0;
			}
		}
		return max;
		
	}
	
	
	//print int base 10
	private static void printInt10(int value) {
		char current = (char) (value % 10 + '0');
		
		if( value / 10 == 0) {
			current = (char) (value % 10 + '0');
			System.out.print(current);;
			return;
		}
		
		printInt10(value / 10);
		System.out.print("" + current);
		
	}
	
	//all permutations of an array
	private static void printArray(int[] arr) {
		System.out.print("\nThe values in the array are: ");
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}
	
	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return;
	}

	private static void permutate(int[] arr, int x) {
		if(arr.length == x) {
			printArray(arr);
			return;
		}
		
		for (int y = x; y < arr.length; y++) {
			swap(arr, x, y);
			permutate(arr, x+1);
			swap(arr,y,x);
		}
		return;		
	}
	
	
	
	
	

}
