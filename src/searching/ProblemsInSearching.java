package searching;

import java.util.Arrays;
import java.util.HashSet;

import javax.naming.directory.InvalidAttributesException;

public class ProblemsInSearching {

	// Print duplicates in array

	// first approach - brute force (n^2)
	// second approach - sorting + single scan
	// third approach - hash table (hash-set)

	public static void printDupesInArray(int[] arr) {
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (hs.contains(arr[i])) {
				System.out.println("dupe: " + arr[i]);
			} else {
				hs.add(arr[i]);
			}
		}
	}

	// fourth approach - counting

	public static void printDupesInArrayCounting(int[] arr, int size) {
		int[] count = new int[size + 1];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}

		System.out.println("The duped elements are: ");
		for (int i = 0; i < arr.length; i++) {
			if (count[arr[i]] == 1) {
				System.out.println("" + arr[i]);
			} else {
				count[arr[i]]++;
			}
		}
	}

	// FIND MAJORITY IN ARRAY
	// Moore's voting algorithm
	// returns -1 if none
	public static int findMajority(int[] arr) {
		int candidate = arr[0];
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == candidate) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				candidate = arr[i];
			}
		}
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == candidate) {
				count++;
			}
		}

		if (count > arr.length / 2) {
			return candidate;
		} else {
			return Integer.MIN_VALUE;
		}

	}

	// STOCK PURCHASE SELL PROBLEM

	public static void maxProfit(int[] arr) {

		int sell = 0;
		int buy = 0;
		int curMinIndex = 0;
		int curProfit = 0;
		int maxProfit = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < curMinIndex) {
				curMinIndex = i;
			}
			curProfit = arr[i] - arr[curMinIndex];
			if (curProfit > maxProfit) {
				buy = curMinIndex;
				sell = i;
				maxProfit = curProfit;
			}
		}
		System.out.println("Purchase day is " + buy + "stock at price " + arr[buy]);
		System.out.println("Sell day is " + sell + " at price " + arr[sell] + " for profit " + maxProfit);

	}

	// Binary search first occurrence of 1 in 01 array

	public static int BinarySearchFirstOccurence(int[] arr, int size) {
		if (size == 1 && arr[0] == 1)
			return 0;

		return BinarySearch01(arr, 0, size - 1);
	}

	private static int BinarySearch01(int[] arr, int start, int end) {
		int mid;
		if (end < start)
			return -1;
		mid = (start + end) / 2;
		if (1 == arr[mid] && 0 == arr[mid - 1])
			return mid;
		if (0 == arr[mid]) {
			return BinarySearch01(arr, mid + 1, end);
		} else {
			return BinarySearch01(arr, start, mid - 1);
		}
	}
	
	/*Given an array of n elements, write an algorithm to find three elements in an array whose
	sum is a given value.
	Hint: Try to do this problem using a brute force approach. Then try to apply the sorting
	approach along with a brute force approach. The Time Complexity will be On^2
	*/
	
	public static void findThreeSum(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				for (int k = 2; k < arr.length; k++) {
					if(arr[i] + arr[j] + arr[k] == sum) {
						System.out.printf("The sum %d is made by %d, %d and %d.\n",sum,arr[i],arr[j],arr[k]);
						return;
					}
				}
			}
		}
		System.out.println("There is no such sum with three members");		
		
	}

	public static void findThreeSumSort(int[] arr, int sum) {
		
		Arrays.sort(arr);
		

		for (int i = 0; i < arr.length; i++) {
			int first = arr[i],second,third;
			int start = i+1;
			int end = arr.length-1;
			while(start < end) {
				second = arr[start];
				third = arr[end];
				
				if(first + second + third == sum) {
					System.out.printf("The sum is done by accumulating %d, %d and %d\n", first, second, third);
					return;
				}
				
				if(first+second+third > sum) {
					end -= 1;
				} else {
					start +=1;
				}
				
			}
			
		}
		System.out.println("No combination of three matches the sum " + sum);
	}
	
	
//	Given an array of –ve and +ve numbers, write a program to separate –ve numbers from the
//	+ve numbers.
	
	public static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	
	public static int[] separatePositiveNegative(int[] arr) {
		
		int start = 0;
		int end = arr.length-1;
		
		while(start < end) {

			if (arr[start] < 0) start++;
			else if (arr[end] > 0) end--;
			else {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return arr;
		
	}
	
//	 Given an array of 0’s, 1’s and 2’s, write a program to separate 0’s , 1’s and 2’s
//	Counting solution
	
	public static int[] separationZeroOneTwoCounting(int[] arr) {
		int zeroAmount = 0;
		int oneAmount = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				zeroAmount++;
			} else if (arr[i] == 1){
				oneAmount++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(i < zeroAmount) {
				arr[i] = 0;
			} else if (i < zeroAmount + oneAmount) {
				arr[i] = 1;
			} else {
				arr[i] = 2;
			}
		}
		return arr;
	}
	
//	Given an array whose elements is monotonically increasing with both negative and positive
//	numbers. Write an algorithm to find the point at which list becomes positive.
	
	public static int findFirstPositiveIndex(int[] arr) {
		int min = 0;
		int max = arr.length-1;
		int mid;
		
		while(min < max) {
			mid = (max+min)/2;
			
			if(arr[mid] >= 0 && (arr[mid-1] < 0)) {
				return mid;
			}
			if(arr[mid] >= 0) {
				max = mid-1;
			} else {
				min = mid +1;
			}
		}
		return Integer.MIN_VALUE;
		
		
	}
	
//	Given a sorted array, find a given number. If found return the index if not, find the index of
//			that number if it is inserted into the array
	
	public static int findItemPositionPlace(int[] arr, int item) {
		
		if (arr.length == 1) {
			return (arr[0] < item) ? 1 : 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == item) {
				return i;
			}
			if(arr[i] < item && i <arr.length - 1 && arr[i+1] > item) {
				return i+1;
			}
		}
		
		return arr.length;
		
	}
	
//	Find kth Smallest Element in the Union of Two Sorted Arrays
	
	public static int nthSmallestInTwoArrays(int[] arr1, int arr2[], int val) {
		if (arr1.length == 0 || arr2.length == 0) {
			try{
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				System.out.println("One of the arrays had length 0");
			}
			return Integer.MIN_VALUE;
		}
		int counter = 0;
		int arr1Index = 0;
		int arr2Index = 0;
		
		while (counter <= val && counter < arr1.length + arr2.length-1) {
			if(arr1[arr1Index] < arr2[arr2Index]) {
				arr1Index++;
				counter++;
				if(counter == val) {
					return arr1[arr1Index];
				}
			} else {
				arr2Index++;
				counter++;
				if(counter == val) {
					return arr2[arr2Index];
				}
			}

		}
		return -1;
		
		
	}
	
	public static void main(String[] args) {

		int[] arr = { 1,2,3,4,5,6 };
		int[] poser = {-1,2,3,4,5,6,-1,2,-4,-6,7};
		int[] zeroOneTwo = {1,0 ,1,2,0,2,1,0,1,0,2,2,2,0,1,1,1};
		int[] negativeToPositive = {-6,-5,-5,-5,-3,0,1,2,3,4,6};
		// printDupesInArray(arr);
		// printDupesInArrayCounting(arr, 91);
		// System.out.println("if majority " + findMajority(arr));
		// maxProfit(arr);
		System.out.println(BinarySearchFirstOccurence(arr, 1));
		findThreeSum(arr, 5);
		findThreeSumSort(arr, 11);
		System.out.println(Arrays.toString(separationZeroOneTwoCounting(zeroOneTwo)));
		System.out.println(Arrays.toString(separatePositiveNegative(poser)));
		System.out.println(findFirstPositiveIndex(negativeToPositive));
		System.out.println(findItemPositionPlace(negativeToPositive, 5));
		System.out.println(nthSmallestInTwoArrays(arr,new int[] {}, 20));

	}

}
