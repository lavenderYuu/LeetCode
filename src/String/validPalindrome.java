package String;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase
letters and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.

    Algorithm:
        1. converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters
        2. use 2 pointer check front and back one are the same, use while loop to loop through the whole string

    Complexity:
    Time: O(n)
 */

public class validPalindrome {
    static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int front = 0;
        int back = s.length() - 1;
        
        if (s.length() < 1) {
            return true;
        }

        while (back > front) {
            if (s.charAt(front) != s.charAt(back))
                return false;

            front++;
            back--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ce a c"));
    }

}
