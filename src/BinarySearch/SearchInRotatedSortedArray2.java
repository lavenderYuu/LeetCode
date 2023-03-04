package BinarySearch;

/*
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums,
or false if it is not in nums.

You must decrease the overall operation steps as much as possible.



Example 1:
    Input: nums = [2,5,6,0,0,1,2], target = 0
    Output: true

Example 2:
    Input: nums = [2,5,6,0,0,1,2], target = 3
    Output: false

        Algorithm:
        1. use a while loop to loop through whole int array, when lo <= hi, search end
        2. store the index low, and high.
        3. check if mid is the target
        4. if middle < high one, which means between mid->high ascending
                so if target is between (mid,hi] then lo can be mid +1, else mid -1
        5. when we meet duplicate, we start shrink the nums from start or the end, until it reach the remove the duplicate
        6. if mid > hi, if target in (mid, hi] same operation
        7. We will check the mid of every interval that target might be, so in the end, if target exist it will be the mid


        Complexity:
        Time: O(log(n))
 */

public class SearchInRotatedSortedArray2 {
    static boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }

            } else if (nums[mid] == nums[hi]) {
                hi--;
            } else if (nums[mid] == nums[lo]) {
                lo++;
            } else {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }

            }
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}
