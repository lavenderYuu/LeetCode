package BinarySearch;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4

Example 2:
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1

        Algorithm:
        1. use a while loop to loop through whole int array, when lo <= hi, search end
        2. store the index low, mid, and high.
        3. check if mid is the target
        4. if mid < target, target might in the range mid - hi, so we let lo = mid+1 and search the rest array
        5, same for mid > target
        6. We will check the mid of every interval that target might be, so in the end, if target exist it will be the mid


        Complexity:
        Time: O(log(n))
 */

    public class BinarySearch {
        static int search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            while (lo <= hi) {
                int mid = (hi - lo) / 2 + lo;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            System.out.println(search(new int[]{-1, 0, 5}, -1));
        }
}
