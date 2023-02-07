package String;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:
    Input: s = "()"
    Output: true

Example 2:
    Input: s = "()[]{}"
    Output: true

Example 3:
    Input: s = "(]"
    Output: false

    Algorithm:
        1. build a stack, loop through all the parentheses
        2. if it is open bracket add to the stack, if it is close bracket, pop the last bracket check is it matched
        3. if there is no parenthese to match or run bracket, return false.
        4. after looping, if all the bracket are matched, the stack is empty. return true

    Complexity:
    Time: O(n)


 */

public class ValidParenthese {
    static boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        for(char c: s.toCharArray()) {
            switch (c){
                case '(':
                case '{':
                case '[':
                    chars.push(c);
                    break;
                case ')':
                    if(chars.isEmpty()||chars.pop()!='(') {
                        return false;
                    }
                    break;

                case '}':
                    if(chars.isEmpty()||chars.pop()!='{') {
                        return false;
                    }
                    break;

                case ']':
                    if(chars.isEmpty()||chars.pop()!='[') {
                        return false;
                    }
                    break;

            }
        }

        return chars.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

}
