public class DLinkedList implements MyList{

    // define any variables you want using the Encapsulation design principle.

    private Node head;
    private Node tail;
    private int size;

    public DLinkedList(){
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void append(Object item){
        Node toAdd = new Node(item);
        toAdd.prev = tail.prev;
        toAdd.next = tail;
        tail.prev.next = toAdd;
        tail.prev = toAdd;
        size++;
    }

    public void insert(int index, Object item){
        if (index < 0 || index > size) {
            System.out.println("ERROR: index " + index + " out of bound for length " + size);
            return;
        } else if (index == size) {
            append(item);
            return;
        }
        Node curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        Node toAdd = new Node(item);
        toAdd.next = curr.next;
        toAdd.prev = curr;
        curr.next.prev = toAdd;
        curr.next = toAdd;
        size++;
    }

    public void clear(){
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public boolean isEmpty(){
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public boolean replace(int index, Object item){
        if (index < 0 || index > size - 1){
            System.out.println("ERROR: index " + index + " out of bound for length " + size);
            return false;
        }
        Node curr = head;
        for (int i = 0; i <= index; i++){
            curr = curr.next;
        }
        curr.data = item;
        return true;
    }

    public void remove(int index){
        if (index < 0 || index > size - 1){
            System.out.println("ERROR: index " + index + " out of bound for length " + size);
            return;
        }
        Node curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        curr.next.next.prev = curr;
        curr.next = curr.next.next;
        size--;
    }

    public Object get(int index){
        if (index < 0 || index > size - 1){
            System.out.println("ERROR: index " + index + " out of bound for length " + size);
            return null;
        }
        Node curr = head;
        for (int i = 0; i <= index; i++){
            curr = curr.next;
        }
        return curr.data;
    }

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