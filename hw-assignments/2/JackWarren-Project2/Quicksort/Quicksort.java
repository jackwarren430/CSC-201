public class Quicksort{
    public void my_quicksort(int[] array){
        if (array.length == 1 || array.length == 0){
            return;
        }
        quicksort_helper(array, 0, array.length - 1);
    }

    private void quicksort_helper(int[] array, int low, int high){
        int pivot = low + (high - low) / 2;
        int low_p = low;
        int high_p = high;
        while ()
    }

    private int partition(int[] array, int low, int high){
        
    }
}