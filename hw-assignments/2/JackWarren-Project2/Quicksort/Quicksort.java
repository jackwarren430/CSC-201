public class Quicksort{
    public static void my_quicksort(int[] array){
        if (array.length == 1 || array.length == 0){
            return;
        }
        quicksort_helper(array, 0, array.length - 1);
    }

    private static void quicksort_helper(int[] array, int low, int high){
        if (high - low <= 0){ return; }
        int pivot = partition(array, low, high);
        quicksort_helper(array, low, pivot - 1);
        quicksort_helper(array, pivot + 1, high);
    }

    private static int partition(int[] array, int low, int high){
        int pivot = low;
        int low_p = low + 1;
        int high_p = high;

        while(low_p < high_p){
            while(array[low_p] >= array[pivot] && low_p < high_p){
                low_p++;
            }
            while(array[high_p] <= array[pivot] && high_p >= low_p){
                high_p--;
            }
            if (array[low_p] < array[high_p] && low_p < high_p){
                int hold = array[high_p];
                array[high_p] = array[low_p];
                array[low_p] = hold;
            }
        }
        
        int hold2 = array[pivot];
        array[pivot] = array[high_p];
        array[high_p] = hold2;
        return high_p;
    }
}