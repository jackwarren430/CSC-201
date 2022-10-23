import java.util.ArrayList;
public class maxHeap{
    ArrayList<Integer> heap; // stores maxHeap values using an ArrayList representation.
    int size; // current size of heap.

    // creates a heap with size of capacity.
    public maxHeap(int capacity){
        //TODO: implement.
        heap = new ArrayList<Integer>(capacity);
        size = 0;
    }

    // return max value in maxHeap, but don't delete it.
    public Integer getMax(){
        return size == 0 ? null : heap.get(0);
    }

    // delete and return the max value in the maxHeap.
    public Integer deleteMax(){
        //TODO: implement.
        if (size == 0) {return null;}
        Integer toReturn = heap.get(0);
        heap.set(0, heap.remove(size - 1));
        size--;
        siftDown(0);
        return toReturn;
    }

    private void siftDown(int index){
        int parent_index, max_child_index;
        while (heap.get(parent_index) < heap.get()){
            
        }
    }

    /* insert a new value into the maxHeap.
     If `val` is a duplicate of an existing heap item, perform insert as usual but leave the pre-existing heap item at its current location.
    */
    public void insert(int val){
        // TODO: implement.
    }
}