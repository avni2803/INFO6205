
import java.util.Arrays;
import java.util.Collections;

class ksmallest {
	
	public static int CreatePartition(Integer[] arr, int l,
								int r)
	{
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				// Swapping 
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
			}
		}

		// Swapping 
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		return i;
	}

	// This function returns k'th smallest element
	
	public static int kthSmallest(Integer[] arr, int l,
								int r, int k)
	{
		// If k is smaller than number of elements
		// in array
		if (k > 0 && k <= r - l + 1) {
			
			int pos = CreatePartition(arr, l, r);

			// If position is same as k
			if (pos - l == k - 1)
				return arr[pos];

			// If position is more, recursion for
			// left subarray
			if (pos - l > k - 1)
				return kthSmallest(arr, l, pos - 1, k);

			// Else recursion  for right subarray
			return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
		}

		// If k is more than number of elements
	
		return Integer.MAX_VALUE;
	}

	
	public static void main(String[] args)
	{
		Integer arr[] = new Integer[] { 1, 3, 8, 7, 4, 19, 26 };
		int k = 2;
		System.out.print("K'th smallest element is " + kthSmallest(arr, 0, arr.length - 1, k));
	}
}

