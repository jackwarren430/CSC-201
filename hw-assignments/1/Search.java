public class Search {
	public static void main(String[] args) {
		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("index of 8 is " + fast_search(8, array));
	}

	public static int fast_search(int k, int[] array){
		int bottom = 0;
		int top = array.length - 1;
		while(bottom != top) {
			int middle = (bottom + top) / 2;
			if (array[middle] == k){
				return middle;
			} else if (k > array[middle]){
				top = middle - 1;
			} else {
				bottom = middle + 1;
			}
		}
		return top;
	}	
}