public class QuicksortTester {
	public static void main(String[] args) {
		int[] arr = {3, 12, 7, 11, 10, 4, 8};

		Quicksort.my_quicksort(arr);

		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i] + ", ");
		}
	}
}