import java.util.*;

public class BinaryTree {
	BTNode root;

	private class BTNode {
		int data;
		BTNode right, left;
	}

	public void level_order_queue(){
		Queue<BTNode> q = LinkedList<BTNode>();
		q.add(root);
		while(!q.isEmpty()){
			tmp = q.poll();
			System.out.println(tmp.data + ", ");
			if (tmp.left != null){
				q.add(tmp.left);
			}
			if (tmp.right != null){
				q.add(tmp.right);
			}
		}
	}

	public void print_level_order(){
		int height = height(root);
		for (int i = 0; i < height; i++){
			level_order_helper(root, i);
		}
		System.out.println();
	}

	private void level_order_helper(BTNode node, int curr_level){
		if (node == null){ return; }
		if (curr_level == 0) {
			System.out.println(node.data + ", ");
			return;
		}
		level_order_helper(node.left, curr_level - 1);
		level_order_helper(node.right, curr_level - 1);
	}

	public int height(BTNode node){
		if (node == null) { return -1; }
		int left_height = height(node.left);
		int right_height = height(node.right);
		int child_height = left_height > right_height ? left_height : right_height;
		return child_height + 1;
	}
}
