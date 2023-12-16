package array;

import java.util.HashMap;
import java.util.Map;

/*
Given a string "abcdefabcdah"
The longest length as per the program should be 11
as a's first index =0 and last index is 10 , hence length is 11
 */
public class LongestLengthOfCharacterInAString {


    public static void main(String[] args) {
        System.out.println(findLongestLength("abcdefabcdah"));//11

        System.out.println(findLongestLength("abcdefcdh"));//5 as c is of length 5
    }

    private static int findLongestLength(String str) {
        Map<Character, Index> characterIndex = new HashMap<>();
        int maxLength = 0;
        int i = 0;
        for (char ch : str.toCharArray()) {
            Index idx = characterIndex.getOrDefault(ch, new Index(i, i));
            idx.lastIndex = i;
            maxLength = Math.max(maxLength, idx.lastIndex - idx.firstIndex + 1);
            characterIndex.put(ch, idx);
            i++;
        }
        return maxLength;
    }
}


class Index {
    int firstIndex;
    int lastIndex;

    public Index(int i1, int i2) {
        firstIndex = i1;
        lastIndex = i2;
    }
}