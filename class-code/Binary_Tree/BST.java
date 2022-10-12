public class BST {
	private TreeNode root;

	private class TreeNode {
		int data;
		TreeNode left, right;
	}

	public int FindMax(){
		return FindMaxHelp(root);
	}

	private int FindMaxHelp(TreeNode curr_node){
		if (curr_node == null) { return -1; }
		if (curr_node.right == null) { return curr_node.data; }
		return FindMaxHelp(curr_node.right);
	}

	public void DeleteMin(){
		root = DeleteMinHelp(root);
	}

	private TreeNode DeleteMinHelp(TreeNode curr_node){
		if (curr_node == null) { return null; }
		if (curr_node.left == null) { return curr_node.right; }
		curr_node.left = DeleteMinHelp(curr_node.left);
		return curr_node;
	}
}