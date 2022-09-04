
public class Sort {
	public static void main(String[] args) {
		int[] array = {45, 72, 23, 75, 83, 12, 87, 34, 76, 93, 28, 56, 73};
		System.out.println("Unsorted array: ");
		for (int i : array){
			System.out.print(i + ", ");
		}
		System.out.println("\nSorting array: " + my_sort(array));
		System.out.println("Sorted Array: ");
		for (int i : array){
			System.out.print(i + ", ");
		}
	}

	public static boolean my_sort(int[] array){
		boolean done = true;
		while (true){
			done = true;
			for (int i = 0; i < array.length; i++){
				if (i != array.length - 1){
					if (array[i] < array[i + 1]){
						done = false;
						int temp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = temp;
					}
				}
			}
			if (done){
				return true;
			}
		}
	}
}
