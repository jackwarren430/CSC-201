import java.util.*;

public class BST{
    // the below variable should keep track of the number of nodes in the BST. Must increment/decrement num_nodes appropriately in insert/delete and ArrayToTree.

    private int num_nodes;
    private TreeNode root;

    public BST(){
        num_nodes = 0;
        root = null;
    }

    private class TreeNode{
        //implement this class.
        private int data;
        private TreeNode right;
        private TreeNode left;

        private TreeNode(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }


    public int getNumNodes(){
        return num_nodes;
    }

    public void insert(int item){
        if (num_nodes == 0){
            root = new TreeNode(item);
            num_nodes++;
            return;
        }
        insertHelper(item, root);
        num_nodes++;
    }

    private void insertHelper(int item, TreeNode node){
        if (item > node.data){
            if (node.right == null){
                node.right = new TreeNode(item);
            } else {
                insertHelper(item, node.right);
            }
        } else {
            if (node.left == null){
                node.left = new TreeNode(item);
            } else {
                insertHelper(item, node.left);
            }
        }
    }

    public boolean find(int item){
        if (root.data == item){
            return true;
        }
        return findHelper(item, root);
    }

    private boolean findHelper(int item, TreeNode node){
        if (item > node.data){
            if (node.right == null){
                return false;
            } else if (node.right.data == item){
                return true;
            } else {
                return findHelper(item, node.right);
            }
        } else {
            if (node.left == null){
                return false;
            } else if (node.left.data == item){
                return true;
            } else {
                return findHelper(item, node.left);
            }
        }
    }

    public void delete(int item){

    }


    public void ArrayToTree(int[] array){
        root = ArrayToTree_helper(array, 0, array.length - 1);
        num_nodes = array.length;
    }


    // Part 2.
    private TreeNode ArrayToTree_helper(int[] array, int low, int high){
        if (high - low < 0){
            return null;
        }
        int index = ((high - low) / 2) + low;
        TreeNode node = new TreeNode(array[index]);
        node.right = ArrayToTree_helper(array, index + 1, high);
        node.left = ArrayToTree_helper(array, low, index - 1);

        return node;
    }

    // Part 3.
    public int[] preorder_traversal(){
        if (num_nodes == 0){
            return new int[0];
        }
        int[] arr = new int[num_nodes];
        String preOrder = preorder_traversalHelper(root);
        return stringToArr(preOrder, arr);
    }

    private String preorder_traversalHelper(TreeNode node){
        if (node == null){
            return "";
        } else {
            int n = node.data;
            String left = preorder_traversalHelper(node.left);
            String right = preorder_traversalHelper(node.right);
            return n + "," + left + right;
        }
    }

    public int[] postorder_traversal(){
        if (num_nodes == 0){
            return new int[0];
        }
        int[] arr = new int[num_nodes];
        String postOrder = postorder_traversalHelper(root);
        return stringToArr(postOrder, arr);
    }

    private String postorder_traversalHelper(TreeNode node){
        if (node == null){
            return "";
        } else {
            int n = node.data;
            String left = postorder_traversalHelper(node.left);
            String right = postorder_traversalHelper(node.right);
            return left + right + n + ",";
        }
    }

    public int[] inorder_traversal(){
        if (num_nodes == 0){
            return new int[0];
        }
        int[] arr = new int[num_nodes];
        String inOrder = inorder_traversalHelper(root);
        return stringToArr(inOrder, arr);
    }

    private String inorder_traversalHelper(TreeNode node){
        if (node == null){
            return "";
        } else {
            int n = node.data;
            String left = inorder_traversalHelper(node.left);
            String right = inorder_traversalHelper(node.right);
            return left + n + "," + right;
        }
    }

    private int[] stringToArr(String str, int[] arr){
        String helper = "";
        int j = 0;
        for (int i = 0; i < str.length(); i++){
            String cha = str.substring(i, i + 1);
            if (cha.equals(",")){
                arr[j] = Integer.parseInt(helper);
                j++;
                helper = "";
            } else {
                helper += cha;
            }
        }
        return arr;
    }

    public int findMax(){
        TreeNode curr = root;
        while (curr.right != null){
            curr = curr.right;
        }
        return curr.data;
    }

    public int findMin(){
        TreeNode curr = root;
        while (curr.left != null){
            curr = curr.left;
        }
        return curr.data;
    }
    
}