package Array;

/*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
the ith line are (i, 0) and (i, height[i]). Find two lines that together with the x-axis form a container,
such that the container contains the most water. Return the maximum amount of water a container can store.

Notice that you may not slant the container.

    |
    |   |
    | | |   |
    | | | | |

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
    In this case, the max area of water (blue section) the container can contain is 49.

Algorithm
    1. build 2 pointer to count the index from the lowest and the highest
    2. build  a for loop when the left and right point meet loop stop
    3. if the left side of the container higher than the right side calculate the area, then keep the highest side
    and move the right  side  1 position to the left. verse vice.
    (because the lowest side current reach area is the area it max can reach, so don't need to check the following inside)

    Time complexity: O(n). Single pass.
    Space complexity: O(1). Constant space is used.
*/

public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int maxA = 0;
            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                if (height[left] > height[right]) {
                    maxA = Math.max(maxA, height[right] * (right - left));
                    right--;
                } else {
                    maxA = Math.max(maxA, height[left] * (right - left));
                    left++;
                }
            }

            return maxA;
        }
    }
}
