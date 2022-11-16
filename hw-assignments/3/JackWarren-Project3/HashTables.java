import java.util.HashSet;
import java.lang.Math;

public class HashTables{

    // Problem 4.
    public static void findSumPair(int target, int[] array){
        HashSet<Integer> nums = new HashSet<Integer>();
        for (int i : array){
            nums.add(i);
        }
        for (int i : array){
            if (nums.contains(target - i)){
                System.out.println("Pair found: " + i + "," + (target - i));
                return;
            }
        }
        System.out.println("Pair not found");
    }

    // Problem 5.
    public static int DistinctValues(int[] array){
        if (array.length == 0 || array == null){return 0;}
        HashSet<Integer> nums = new HashSet<Integer>();
        for (int i : array){
            if (!nums.contains(Math.abs(i))){
                nums.add(Math.abs(i));
            }
        }
        return nums.size();
    }

    public static void main(String[] args){
        int[] array = {2, 7, 3, 9, 4, 1};
        findSumPair(8, array);

        int[] arr2 = {-4, 4, 4, 2, -2, -2, 1, 6};
        System.out.println("unique nums in arr2: " + DistinctValues(arr2));
    }
}