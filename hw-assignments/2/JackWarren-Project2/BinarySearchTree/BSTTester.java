public class BSTTester {
	public static void main(String[] args) {
		
		BST tree = new BST();
		tree.insert(0);
		tree.insert(2);
		tree.insert(6);
		tree.insert(3);
		tree.insert(7);

		int[] arr = tree.inorder_traversal();
		String toPrint = "";
		for (int i : arr){
			toPrint += i + ", ";
		}

		System.out.println(toPrint);
	}
}