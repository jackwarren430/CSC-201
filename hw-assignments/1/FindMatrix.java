public class FindMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{10, 5, 3}, {8, 4, 2}, {7, 3, 1}};
		System.out.println(MatrixFind(6, matrix));
	}

	public static boolean MatrixFind(int k, int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] >= k && matrix[i][matrix.length - 1] <= k){
				int top = matrix.length - 1;
				int bottom = 0;
				while (top != bottom){
					int mid = (top + bottom) / 2;
					if (matrix[i][mid] == k){
						return true;
					} else if (matrix[i][mid] > k){
						bottom = mid + 1;
					} else {
						top = mid - 1;
					}
				}
				if (matrix[i][top] == k){
					return true;
				}
			}
		} 
		return false;
	}
}