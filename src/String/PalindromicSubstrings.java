package String;

/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.



Example 1:
    Input: s = "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
    Input: s = "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


    Algorithm:
        1. create a help function that return the longest length of the word is palindromic which middle char at i index
        2. build a for loop, loop through whole string
        3. first count add, check the number has a unique char in the middle
        4. second count add, totally palindrome

    Complexity:
    Time: O(nK)
 */

public class PalindromicSubstrings {
        static int countSubstrings(String s) {
            int count=0;
            for(int i = 0; i<s.length(); i++) {
                count +=readMid(s,i,i);
                count +=readMid(s,i,i+1);
            }

            return count;

        }

        static int readMid (String s, int low, int high) {
            int count=0;
            while(high < s.length()&& low >=0 && s.charAt(low) == s.charAt(high)) {
                count++;
                low--;
                high++;
            }
            return count;
        }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }
}
