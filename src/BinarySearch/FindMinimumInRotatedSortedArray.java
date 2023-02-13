package BinarySearch;
/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
[a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.


Example 1:
    Input: nums = [3,4,5,1,2]
    Output: 1
    Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:
    Input: nums = [4,5,6,7,0,1,2]
    Output: 0
    Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:
    Input: nums = [11,13,15,17]
    Output: 11
    Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

        Algorithm:
        1. use a while loop to loop through whole int array
        2. store the index low, mid, and high.
        3. if middle one is smaller than the high one, which means between mid->high ascending
           so min is between lo -> mid
        4. if mid > hi, mean min is between them lo and mid
        5. when lo = hi -1 loop breaked

        Complexity:
        Time: O(log(n))
 */
public class FindMinimumInRotatedSortedArray {

    static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi - 1) {
            int mid = (hi - lo) / 2 + lo;

            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return Math.min(nums[lo], nums[hi]);
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2, 1}));
    }
}
