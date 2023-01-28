package String;
/* //https://leetcode.com/problems/longest-repeating-character-replacement/description/
You are given a string s and an integer k. You can choose any character of the string and change it to any other
uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4

    Algorithm:(sliding window)
        1. build 2 pointer and a character int list to contain the char we have and start pointer pA, end pointer pB
        2. A for loop to loop through the whole string.
        3. store the count of char in the int list, store the max count
        4. A while loop, when the number we want to replace out of the capacity. Move the start pointer to the right,
        until the string in(pA,pB) is legal. And the int list only contain the string (pA,pB)
        5. the max length is (pA, pB)

    Complexity:
    Time: O(n)


 */


public class LongestRepeatingCharacterReplacement {
    class Solution {
        public int characterReplacement(String s, int k) {
            int pA = 0;
            int pB = 0;
            int[] charL = new int[26];
            int max=0;
            int maxC =0;

            for(pB = 0; pB < s.length(); pB++) {
                charL[s.charAt(pB) - 'A']++;
                int count = charL[s.charAt(pB) - 'A'];
                maxC = Math.max(count, maxC);
                while(pB - pA - maxC +1 > k) {
                    charL[s.charAt(pA) - 'A']--;
                    pA++;
                }

                max = Math.max(max, pB - pA +1);


            }
            return max;
        }
    }
}
