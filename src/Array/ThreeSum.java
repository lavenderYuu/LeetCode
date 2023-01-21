package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

 Notice that the solution set must not contain duplicate triplets.

        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.

        Example 2:

        Input: nums = [0,1,1]
        Output: []

        Example 3:

        Input: nums = [0,0,0]
        Output: [[0,0,0]]

    Algorithm:
        1. sort the nums by order
        2. build a for loop, select each number from the list and find a pair in the rest of numbers which sum is neg of num
        3. if the num is same with previous one, skip over it to avoid duplicate.
        4. make the 2 sum loop. build index low and high and loop through whole sublist to find the sum we want.
        5. use 2 while loop to skip over the duplicate in 2 sum

     Complexity
        Time(n^2)

*/


public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List output = new ArrayList<List>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int sum = -nums[i];
                int low = i + 1;
                int high = nums.length - 1;

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        output.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return output;
    }


    public static void main(String args[]) {
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

}