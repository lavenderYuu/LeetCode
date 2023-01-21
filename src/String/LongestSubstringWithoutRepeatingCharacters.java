package String;

import java.util.HashSet;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Algorithm:(sliding window)
        1.build 2 pointer and a hashset to contain the new char we had started with the char at pA
        2. build the while loop with pB < string length is the pointer track to uncheck char in the string
        3. if the new char set don't contain the char at index pB, add it to the set and compare the set size with the max before
        4. if it is a repeat char at pB, remove the start char in substring, which is char at pA. And pA ++, this
        is the new substring start with char at pA.

    Complexity:
    Time: O(n)


 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int pA = 0;
        int pB = 0;
        HashSet<Character> num = new HashSet();

        while (pB < s.length()) {
            if (!num.contains(s.charAt(pB))) {
                num.add(s.charAt(pB));
                pB++;
                max = Math.max(num.size(), max);
            } else {
                num.remove(s.charAt(pA));
                pA++;
            }
        }

        return max;
    }
}
