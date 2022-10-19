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


    public void ArrayToTree(int array[]){

    }

/*
    // Part 2.
    private TreeNode ArrayToTree_helper(int array[], int low, int high){
        
    }

    // Part 3.
    public int[] preorder_traversal(){

    }

    public int[] postorder_traversal(){

    }
*/
    public int[] inorder_traversal(){
        int[] arr = new int[num_nodes + 1];
        inorder_traversalHelper(root, arr, 1);
        return arr;
    }

    private void inorder_traversalHelper(TreeNode node, int[] arr, int index){
        arr[index] = node.data;
        if (node.right != null){
            inorder_traversalHelper(node.right, arr, index*2 + 1);
        }
        if (node.left != null){
            inorder_traversalHelper(node.left, arr, index*2);
        }
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