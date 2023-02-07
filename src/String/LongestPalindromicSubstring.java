package String;
/*
Given a string s, return the longest palindromic substring in s.

Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

Example 2:
    Input: s = "cbbd"
    Output: "bb"

    Algorithm:
        1. create a help function that return the longest length of the word is palindromic which middle char at i index
        2. build a for loop, loop through whole string
        3. len 1, check the number has a unique char in the middle, len 2, totally palindrome
        4. if length is max, update the new end and start index of the substring
        (if the string has unique char, the start will be i - (length-1)/2)

    Complexity:
    Time: O(nK)
 */

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int length;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = checkFromMiddle(s, i, i);
            int len2 = checkFromMiddle(s, i, i + 1);
            length = Math.max(len1, len2);
            if (length > (end - start + 1)) {
                end = i + length / 2;
                start = i - (length - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int checkFromMiddle(String s, int le, int ri) {
        while (le >= 0 && ri < s.length() && s.charAt(le) == s.charAt(ri)) {
            le--;
            ri++;
        }
        return ri - le - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abb"));
    }

}


