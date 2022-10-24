import java.util.*;

public class BST{
    // the below variable should keep track of the number of nodes in the BST. Must increment/decrement num_nodes appropriately in insert/delete and ArrayToTree.

    private int num_nodes;
    private TreeNode root;

    public BST(){
        num_nodes = 0;
        root = null;
    }

    //  sub class for nodes in tree
    //  two pointers to right and left
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

    // takes in an item and returns nothing
    public void insert(int item){
        //  base case for if tree is empty
        if (num_nodes == 0){
            root = new TreeNode(item);
            num_nodes++;
            return;
        }
        //  initial recursive call
        insertHelper(item, root);
        num_nodes++;
    }

    // private recursive method for insert
    // takes in the item and the current node
    private void insertHelper(int item, TreeNode node){
        //  checks whether to go right or left
        if (item > node.data){
            //  insert if there's an open spot
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

    // takes in item and returns true if it's in the list
    public boolean find(int item){
        // base case for root
        if (root.data == item){
            return true;
        }
        //  initial recursive call
        return findHelper(item, root);
    }

    //  recursive method works similar to insert.
    //  takes in item and current node. returns true if 
    //  item is in the tree, false if it reaches the end of the tree
    private boolean findHelper(int item, TreeNode node){
        //  deciding where to go from curr node
        if (item > node.data){
            //  returns false if the next spot is null,
            //  true if the next node is the element,
            //  or makes recursive call to next node.
            if (node.right == null){
                return false;
            } else if (node.right.data == item){
                return true;
            } else {
                return findHelper(item, node.right);
            }
        } else {
            //  same deal but for left side
            if (node.left == null){
                return false;
            } else if (node.left.data == item){
                return true;
            } else {
                return findHelper(item, node.left);
            }
        }
    }

    // delete takes in the item to be removed
    public void delete(int item){
        // base case - item is not in tree or tree is empty
        if (!find(item) || num_nodes == 0) {return;}
        //  handles all the root cases - special because no parent to account for
        if (root.data == item){
            if (root.right == null && root.left == null){
                //  if no children
                root = null;
            } else if (root.right == null){
                //  if left child only
                root = root.left;
            } else if (root.left == null){
                // if right child only
                root = root.right;
            } else {
                // if two children - set equal to max of left subtree and delete it
                root.data = deleteMax(root.left);
            }
        } else {
            // if item is not root
            if (item > root.data){
                delete(item, root.right, root);
            } else {
                delete(item, root.left, root);
            }
        }
        num_nodes--;
    }

    //  recursive method takes in the item to be deleted,
    //  the current node, and its parent
    private void delete(int item, TreeNode node, TreeNode parent){
        // if at the wrong place, perform the delete,
        // else make recursive call to the correct node
        if (node.data == item){
            if (node.right == null && node.left == null){
                // if childless - make parent pointer point to null
                if (node.data < parent.data){
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (node.right == null){
                //  if one child, just make parent point to child
                if (node.data < parent.data){
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            } else if (node.left == null){
                if (node.data < parent.data){
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            } else {
                //  if two children - replace with max of left subtree and delete it
                node.data = deleteMax(node.left);
            }
        } else if (item > node.data){
            delete(item, node.right, node);
        } else {
            delete(item, node.left, node);
        }
    }

    //  special method for deleting the max of left subtrees.
    //  takes in the subtree root and returns the max value
    private int deleteMax(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        int hold = node.data;
        delete(hold);
        num_nodes++;
        return hold;
    }

    //  user method takes in array and returns nothing,
    // however it rewrites the current instance to the new tree.
    public void ArrayToTree(int[] array){
        root = ArrayToTree_helper(array, 0, array.length - 1);
        num_nodes = array.length;
    }

    // Part 2.
    //  recursive method - takes in the array, and low and high pointers
    //  essentaily performs binary search on the array recursively,
    //  adding nodes each step of the way
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
    //  performs pre order traversal on tree and returns the resulting int array
    public int[] preorder_traversal(){
        if (num_nodes == 0){
            return new int[0];
        }
        int[] arr = new int[num_nodes];
        String preOrder = preorder_traversalHelper(root);
        return stringToArr(preOrder, arr);
    }

    //  since adding strings is way easier than adding arrays, I return a string of the
    //  traversal then convert it into an array with another method
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

    //  same exact process as preorder except switching the order in which 
    //  recursive calls are added
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

    //  same exact process as preorder except switching the order in which 
    //  recursive calls are added
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

    //  special method to convert a string of ints into an array
    //  takes in a string and the array with the correct size and
    //  returns the same array. could've returned nothing but I already coded it this way
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

    //  iterates to the right most node and returns the value
    public int findMax(){
        TreeNode curr = root;
        while (curr.right != null){
            curr = curr.right;
        }
        return curr.data;
    }
    //  iterates to the left most node and returns the value
    public int findMin(){
        TreeNode curr = root;
        while (curr.left != null){
            curr = curr.left;
        }
        return curr.data;
    }
    
}