public class DLinkedList implements MyList{

    // define any variables you want using the Encapsulation design principle.
    //  instance variables
    //      pointer to head and to tail
    //      size var
    private Node head;
    private Node tail;
    private int size;
    //  constructor sets head pointing to tail and vice versa
    public DLinkedList(){
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    //  adds element to end of list.
    //  O(1) since we have tail pointer.
    //  returns nothing.
    public void append(Object item){
        Node toAdd = new Node(item);
        toAdd.prev = tail.prev;
        toAdd.next = tail;
        tail.prev.next = toAdd;
        tail.prev = toAdd;
        size++;
    }

    //  adds element to specific index.
    //  takes in the item and and index. returns nothing/
    public void insert(int index, Object item){
        //  handles index out of bounds and list is empty errors
        if (index < 0 || index > size) {
            System.out.println("ERROR: index " + index + " out of bound for length " + size);
            return;
        } else if (index == size) {
            //  handles inserting to last spot in list
            append(item);
            return;
        }
        //  moves down list to index
        Node curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        //  inserts element
        Node toAdd = new Node(item);
        toAdd.next = curr.next;
        toAdd.prev = curr;
        curr.next.prev = toAdd;
        curr.next = toAdd;
        size++;
    }

    //  takes nothing and returns nothing
    public void clear(){
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    //  checks if list is empty - returns true/false
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    //  returns size
    public int size(){
        return size;
    }

    //  replaces node at index with item.
    //  takes in item, index, and returns true if succesful
    //  and false if there was an error
    public boolean replace(int index, Object item){
        //  handles index out of bounds and list is empty errors
        if (index < 0 || index > size - 1){
            System.out.println("ERROR: index " + index + " out of bound for length " + size);
            return false;
        }
        //  traversal down the list to index
        Node curr = head;
        for (int i = 0; i <= index; i++){
            curr = curr.next;
        }
        curr.data = item;
        return true;
    }

    //  takes in index for where to remove. returns nothing
    public void remove(int index){
        //  handles index out of bounds and empty list errors
        if (index < 0 || index > size - 1){
            System.out.println("ERROR: index " + index + " out of bound for length " + size);
            return;
        }
        //  traversal down to index
        Node curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        // removes node at index from list
        curr.next.next.prev = curr;
        curr.next = curr.next.next;
        size--;
    }

    //  takes index and returns object at index
    public Object get(int index){
        //  handles index out of bounds and empty list errors
        if (index < 0 || index > size - 1){
            System.out.println("ERROR: index " + index + " out of bound for length " + size);
            return null;
        }
        //  traversal down to list
        Node curr = head;
        for (int i = 0; i <= index; i++){
            curr = curr.next;
        }
        return curr.data;
    }

    // toString for testing - returns... a string! :D
    public String toString(){
        Node curr = head;
        String toReturn = "";
        for (int i = 0; i < size; i++){
            toReturn += curr.next.data + ", ";
            curr = curr.next;
        }
        return toReturn;
    }

    private class Node{
        //a private nested Node class that users cannot access.
        public Object data;
        public Node prev;
        public Node next;
        
        private Node(Object data){
            this.data = data;
            prev = null;
            next = null;
        }
    }
}