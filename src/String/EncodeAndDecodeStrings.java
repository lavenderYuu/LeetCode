package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Design an algorithm to encode a list of strings to a string.
The encoded string is then sent over the network and is decoded back to the original list of strings.

    Algorithm:
        1. encode, for each string add length and # (as stop sign)
        2. decode, use while loop and index i to loop through the string
        3. read the length and start with the stop sign


    Complexity:
    Time: O(n)
 */


public class EncodeAndDecodeStrings {
    static String encode(List<String> strs) {
        StringBuffer encode = new StringBuffer();

        for (String s : strs) {
            encode.append(s.length());
            encode.append('#');
            encode.append(s);
        }

        return encode.toString();

    }

    static List<String> decode(String str) {
        List<String> decode = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int length = 0;
            while (i < str.length() && str.charAt(i) != '#') {
                length = 10 * length + Character.getNumericValue(str.charAt(i));
                i++;
            }
            decode.add(str.substring(i + 1, i + length + 1));
            i += length + 1;
        }

        return decode;

    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("hello", " ", "World", "!");
        System.out.println(encode(strs));
        System.out.println(decode(encode(strs)));
    }
}
