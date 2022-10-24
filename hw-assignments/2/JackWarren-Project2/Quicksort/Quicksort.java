public class Quicksort{

    //  static method stakes array and sorts it - returns nothing
    public static void my_quicksort(int[] array){
        //  handles base case - arr is empty or size 1
        if (array.length == 1 || array.length == 0){
            return;
        }
        // initial reccursive call
        quicksort_helper(array, 0, array.length - 1);
    }

    //  main recursive method - takes in a "sub array" with low and high indices.
    //  partitions whole sub array.
    //  splits into two subarrays and calls itself on them.
    private static void quicksort_helper(int[] array, int low, int high){
        //  base case - sub array is size 0
        if (high - low <= 0){ return; }
        int pivot = partition(array, low, high);
        quicksort_helper(array, low, pivot - 1);
        quicksort_helper(array, pivot + 1, high);
    }

    //  this method takes in a sub array and moves elements around a pivot,
    //  which is always the first element.
    private static int partition(int[] array, int low, int high){
        
        // saves the pivit index and creates two pointer vars
        int pivot = low;
        int low_p = low + 1;
        int high_p = high;

        //  makes switches between high and low pointer
        //  while the high pointer is greater than the low pointer
        while(low_p < high_p){
            //  moves low pointer up until an element is less than pivot
            while(array[low_p] >= array[pivot] && low_p < high_p){
                low_p++;
            }
            //  moves high pointer down until an element is greater than pivot
            while(array[high_p] <= array[pivot] && high_p >= low_p){
                high_p--;
            }
            //  switches high and low pointer if needed
            if (array[low_p] < array[high_p] && low_p < high_p){
                int hold = array[high_p];
                array[high_p] = array[low_p];
                array[low_p] = hold;
            }
        }
        //  since high pointer landed on correct pivot spot,
        //  switch pivot and high pointer
        int hold2 = array[pivot];
        array[pivot] = array[high_p];
        array[high_p] = hold2;
        return high_p;
    }
}