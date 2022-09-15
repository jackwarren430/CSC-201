import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {3, 6, 2, 13, 65, 23, 76, 83, 6, 8, 84, 57, 42};
		mergesort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergesort(int[] array){
		if (array.length < 2){
			return;
		} 

		mergesort_helper(array, 0, array.length - 1);
	}

	private static void mergesort_helper(int[] array, int low, int high){
		// low == high -> 1 element
		if (low == high){
			return;
		} 
		
		int mid = low + (high - low)/2;
		mergesort_helper(array, low, mid);
		mergesort_helper(array, mid + 1, high);
		merge(array, low, mid, high);

	}
	
	private static void merge(int[] array, int low, int mid, int high){
		int[] combined = new int[high - low + 1];
		int lowp = low;
		int highp = mid + 1;
		int combp = 0;
		while (lowp <= mid && highp <= high){
			if (array[lowp] <= array[highp]){
				combined[combp] = array[lowp];
				lowp++;
			} else {
				combined[combp] = array[highp];
				highp++;
			}
			combp++;
		}
		while (lowp <= mid){
			combined[combp] = array[lowp];
			lowp++; combp++;
		}
		while (highp <= high){
			combined[combp] = array[highp];
			highp++; combp++;
		}
		for (int i = 0; i < combined.length; i++){
			array[i + low] = combined[i];
		}
	}
}


