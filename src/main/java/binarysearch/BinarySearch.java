package binarysearch;

public class BinarySearch {
	
//	public static int searchForElement(int[] array, int target){
//		int start = 0;
//		int end = array.length-1; 
//		return binarySearch(array, start, end, target);
//	}
//	
//	public static int binarySearch(int[] array, int start, int end, int target){
//		int mid = (end + start)/2;
//	
//		if(target <= array[mid])
//			if (start == mid)	
//				return start; 
//			else
//				return binarySearch(array, start, mid - 1, target);
//		else if (target == array[mid])
//			return mid;
//		else 
//			if (end == mid)
//				return end + 1;
//			else
//				return binarySearch(array, mid + 1, end, target);		
//	}
	
//	public static int searchForElement(int[] arr, int target) {
//
//		  int left = 0, right = arr.length-1;
//		  while (left < right) {
//		    int middle = (left+right)/2;
//		    if (arr[middle] < target){
//		      left = middle+1;
//		    }else{
//		      right = middle;
//		    }
//		  }
//		  return arr[left] < target ? left+1 : left;
//		}
	
	public static int searchForElement(int[] x, int target){
		int low = 0;
		int high = x.length- 1;
		int mid = 0;
		while (low <= high) {
		    mid = (low+high)/2;
		    if (target == x[mid]) {
		        return mid;
		    }
		    else if (target < x[mid]) {
		        high = mid-1;
		    }
		    else {
		        low = mid +1;
		    }
		}
		return mid+1;
	}
	
	public static void main(String[] args) throws Exception 
	{	
		int[] array1 = {1, 3, 4, 4, 9, 10};
		int[] array2 = {2,45,234,567,876,900,976,999};
		int[] array3 = {1,3,5,6};
		System.out.println(searchForElement(array1, 1));
		System.out.println(searchForElement(array1, 10));
		System.out.println(searchForElement(array1, 4));
		System.out.println(searchForElement(array1, 0));
		System.out.println(searchForElement(array1, 20));
		
		System.out.println(searchForElement(array2, 800));	
		
		System.out.println(searchForElement(array3, 5));
		System.out.println(searchForElement(array3, 0));
		System.out.println(searchForElement(array3, 2));
		System.out.println(searchForElement(array3, 7));
		
		//LinkedList.linkedlist.LC2_AddTwoNumbers cases:
		// IN: start, end, mid (odd/even number of elements)
		// OUT: less than first, larger than last (odd/even number of elements)
		// duplicate
	}
}
