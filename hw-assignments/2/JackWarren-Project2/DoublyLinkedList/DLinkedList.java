public class DLinkedList implements MyList{

    // define any variables you want using the Encapsulation design principle.

    private Node head;
    private Node tail;
    private int size;

    public DLinkedList(){
        head = new Node(null);
        tail = new Node(null);
        head.right = tail;
        tail.left = head;
        size = 0;
    }

    public void append(Object item){
        Node toAdd = new Node(item);
        toAdd.left = tail.left;
        toAdd.right = tail;
        tail.left.right = toAdd;
        tail.left = toAdd;
    }

    public void insert(int index, Object item){

    }

    public void clear(){

    }

    public boolean isEmpty(){
        return true;
    }

    public int size(){
        return 0;
    }

    public boolean replace(int index, Object item){
        return true;
    }

    public void remove(int index){

    }

    public Object get(int index){
        return 1;
    }

    public String toString(){
        Node curr = head;
        String toReturn = "";
        for (int i = 0; i <= size; i++){
            toReturn += curr.right.data + ", ";
        }
        return toReturn;
    }

    private class Node{
        //a private nested Node class that users cannot access.
        private Object data;
        private Node left;
        private Node right;
        
        private Node(Object data){
            this.data = data;
            left = null;
            right = null;
        }
    }
}