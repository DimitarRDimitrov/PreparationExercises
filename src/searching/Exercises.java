package searching;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Exercises {
	// 1. Given an array of n elements, find the first repeated element. Which
	// of the following
	// methods will work for us. And which, if the method will not work for us.
	// If a method work,
	// then implements it.
	// · Brute force exhaustive search.
	// · Use Hash-Table to keep an index of the elements and use the second scan
	// to find the
	// element.
	// · Sorting the elements.
	// · If we know the range of the element then we can use counting technique.
	// Hint: When order in which elements appear in input is important, we
	// cannot use sorting.

	public static int firstRepeatedBrute(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j])
					;
				return arr[i];
			}
		}
		return -1;
	}

	public static int firstRepeatedHash(int[] arr) {

		int minIndex = -1;

		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (hs.contains(arr[i])) {
				minIndex = i;
			} else {
				hs.add(arr[i]);
			}
		}

		if (minIndex == -1) {
			System.out.println("No repeating elements");
		} else {
			System.out.println("The first repeating element is " + arr[minIndex]);
		}
		return minIndex;
	}

	public static int firstRepeatedCounting(int[] arr, int size) {
		int[] count = new int[size + 1];

		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		for (int j = 0; j < arr.length; j++) {
			if (count[arr[j]] > 1) {
				return arr[j];
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] myArr = { 4, 2, 2, 3, 4, 1 };

		firstRepeatedHash(myArr);
		System.out.println(firstRepeatedCounting(myArr, 4));
	}

}
