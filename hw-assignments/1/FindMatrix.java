public class FindMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{10, 5, 3}, {8, 4, 2}, {7, 3, 1}};
		int k = 6;
		System.out.println("is " + k + " in the matrix? " + MatrixFind(k, matrix));
	}

	public static boolean MatrixFind(int k, int[][] matrix){
		int row = matrix.length - 1;
		int col = 0;
		while(row >= 0 && col < matrix.length){
			int element = matrix[row][col];
			if(element == k){
				return true;
			} else if (k > element) {
				row -= 1;
			} else {
				col += 1;
			}
		}
		return false;
	}
}