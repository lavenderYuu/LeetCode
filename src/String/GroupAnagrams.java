package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
    Input: strs = [""]
    Output: [[""]]

Example 3:
    Input: strs = ["a"]
    Output: [["a"]]

    Algorithm:(sliding window)
        1. build a hash map to store the anagram's str
        2. a for loop wo loop through all the string
        3. build a char int list, second for loop is store the #char each str had
        4. third for loop, to give each str their group code
        5. if it is a new group, create new list and store it in, if not add str to the group

    Complexity:
    Time: O(nK)


 */

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> check = new HashMap<String,List<String>>();

        for(int i = 0; i<strs.length; i++) {
            String c = "";
            int[] b = new int[26];
            for(char cha: strs[i].toCharArray()){
                b[cha - 'a']++;
            }
            for(int track = 0; track<26; track++){
                c=c +"#" + b[track] ;
            }
            if(!check.containsKey(c)) {
                List strss = new ArrayList();
                strss.add(strs[i]);
                check.put(c,strss);
            } else {
                List list = check.get(c);
                list.add(strs[i]);
                check.put(c,list);
            }
        }

        return new ArrayList(check.values());
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(groupAnagrams(new String[]{"bddd","bbbc"}));
    }
}
