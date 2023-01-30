package String;


/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.


Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

    Algorithm:(sliding window)
        1. build a char int list store the number of character
        2. check if different length return false, or has different number of character
        3. otherwise return true

    Complexity:
    Time: O(n)


 */


public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] charS = new int[26];
        int[] charT = new int[26];

        if(s.length()!=t.length())
            return false;

        for(int i=0; i<s.length();i++) {
            charS[s.charAt(i)-'a']++;
            charT[t.charAt(i)-'a']++;
        }

        for(int i=0; i<26;i++){
            if(charS[i] != charT[i])
                return false;
        }

        return true;
    }

    public static void main(String args[]){
//        System.out.println(isAnagram("anagram","nagaram"));
    }
}
