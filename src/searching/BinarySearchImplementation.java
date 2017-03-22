package searching;

public class BinarySearchImplementation {
	
	public static boolean search(int[] arr, int value) {
		
		int min = 0;
		int max = arr.length;
		int mid;
		while(min <= max) {
			mid = min + (max - min)/2;
			if(arr[mid] > value) {
				max = mid-1;
			} else if (arr[mid] == value) {
				return true;
			} else {
				min = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] myArr = {1,2,3,4,5,6,7,8,9,10,11,15,16,17,88};
		System.out.println(search(myArr, 12));
	}

}
