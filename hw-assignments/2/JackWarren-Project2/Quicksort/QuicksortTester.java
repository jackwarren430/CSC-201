public class QuicksortTester {
	public static void main(String[] args) {
		int[] arr = {3, 12, 15, 17, 15, 2, 9, 18, 13, 15, 12, 14, 7, 11, 16, 12, 16, 18, 18, 12, 14, 19, 17, 10, 4, 8};

		Quicksort.my_quicksort(arr);
		System.out.println("\nFINAL:");
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
	}
}