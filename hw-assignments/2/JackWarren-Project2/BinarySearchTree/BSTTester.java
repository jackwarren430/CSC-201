public class BSTTester {
	public static void main(String[] args) {
		
		BST tree = new BST();
		tree.insert(7);
		tree.insert(5);
		tree.insert(2);
		tree.insert(6);
		tree.insert(1);
		tree.insert(3);
		tree.insert(10);

		System.out.println("in order: ");
		int[] arr = tree.inorder_traversal();
		String toPrint = "";
		for (int i : arr){
			toPrint += i + ", ";
		}
		System.out.println(toPrint);

		System.out.println("pre order: ");
		arr = tree.preorder_traversal();
		toPrint = "";
		for (int i : arr){
			toPrint += i + ", ";
		}
		System.out.println(toPrint);

		System.out.println("post order: ");
		arr = tree.postorder_traversal();
		toPrint = "";
		for (int i : arr){
			toPrint += i + ", ";
		}
		System.out.println(toPrint);

		arr = new int[] {0, 1, 2, 3, 4, 5, 6};
		tree.ArrayToTree(arr);

		System.out.println("arr to tree in order: ");
		int[] arr2 = tree.inorder_traversal();
		toPrint = "";
		for (int i : arr2){
			toPrint += i + ", ";
		}
		System.out.println(toPrint);

		tree.delete(3);
		tree.delete(5);
		tree.delete(1);
		arr = tree.inorder_traversal();
		toPrint = "";
		for (int i : arr){
			toPrint += i + ", ";
		}
		System.out.println("deleted 3, 5, 1: " + toPrint);
	}
}