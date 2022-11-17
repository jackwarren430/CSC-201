import java.util.HashSet;
import java.lang.Math;

public class HashTables{

    // Problem 4.
    
    //this method adds everything in array to a hashset, then iterates back through the array
    //and checks to see if the target - array[i] is in the hashset
    //if it is, that means both numbers that add up to target are in the array
    //and they get returned
    public static void findSumPair(int target, int[] array){
        HashSet<Integer> nums = new HashSet<Integer>();
        //adding array to hashset
        for (int i : array){
            nums.add(i);
        }
        //iterate back through array
        for (int i : array){
            //checks to see if the hashset contains the needed value
            if (nums.contains(target - i)){
                System.out.println("Pair found: " + i + "," + (target - i));
                return;
            }
        }
        //if no pairs are found, prints not found
        System.out.println("Pair not found");
    }

    // Problem 5.
    //this method simply iterates through the array, and adds the absolute value
    //of numbers that aren't already in the hashset. it then returns the hashset size
    public static int DistinctValues(int[] array){
        //base case for empty or null array
        if (array.length == 0 || array == null){return 0;}
        HashSet<Integer> nums = new HashSet<Integer>();
        //iterating through array
        for (int i : array){
            //adding abs value of number only if they're not already added
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