public class MergeSort {
	public static void main(String[] args) {
		
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
		
		mergesort_helper(array, low, low + (high - low)/2);
		mergesort_helper(array, low + (high = low)/2 + 1, high);
		merge(array, low, low + (high - low)/2, high);

	}

	private static void merge(int[] array, int low, int mid, int high){
		int[] combined = new int[high - low];
		
	}
}