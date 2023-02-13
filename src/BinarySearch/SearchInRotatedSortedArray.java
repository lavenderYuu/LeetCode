package BinarySearch;

/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target
if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

Example 3:
    Input: nums = [1], target = 0
    Output: -1

        Algorithm:
        1. use a while loop to loop through whole int array, when lo <= hi, search end
        2. store the index low, mid, and high.
        3. check if mid is the target
        4. if middle < high one, which means between mid->high ascending
                so if target is between (mid,hi] then lo can be mid +1, else mid -1
        5. if mid > hi, if target in (mid, hi] same operation
        6. We will check the mid of every interval that target might be, so in the end, if target exist it will be the mid


        Complexity:
        Time: O(log(n))
 */


public class SearchInRotatedSortedArray {
    static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (nums[mid] < target || target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 5, 1}, 1));
    }

}
