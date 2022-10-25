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

    private void siftDown(int idx){
        int parent_idx = idx;
        //int max_child_idx = heap.get(idx*2 + 1) > heap.get(idx*2+2) ? heap.get(idx*2+1) : heap.get(idx*2+1);
        while (parent_idx < size/2 - 1){
            if (2 * parent_idx + 1 >= size){break;}
            if(2 * parent_idx + 2 >= size){
                if (heap.get(parent_idx) < heap.get(2 * parent_idx + 1)){
                    swap(parent_idx, parent_idx * 2 + 1);
                    parent_idx = parent_idx * 2 + 1;
                }
            } else {
                if (heap.get(parent_idx * 2 + 1) < heap.get(parent_idx * 2 + 2)){
                    swap(parent_idx, parent_idx * 2 + 2);
                    parent_idx = parent_idx * 2 + 2;
                } else {
                    swap(parent_idx, parent_idx * 2 + 1);
                    parent_idx = parent_idx * 2 + 1;
                }
            }
        }
    }

    private void swap(int idx, int idx2){
        if (idx < 0 || idx >= size - 1 || idx2 < 0 || idx2 >= size){
            return;
        }
        int hold = heap.get(idx);
        heap.set(idx, heap.get(idx2));
        heap.set(idx2, hold);
    }
    /* insert a new value into the maxHeap.
     If `val` is a duplicate of an existing heap item, perform insert as usual but leave the pre-existing heap item at its current location.
    */
    public void insert(int val){
        // TODO: implement.
    }
}



