package src;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reformat(String s) {
        char[] str = s.toCharArray();
        List<Character> num = new ArrayList<>();
        List<Character> character = new ArrayList<>();
        for (char c : str) {
            if (Character.isDigit(c)) {
                num.add(c);
            }
            if (Character.isLetter(c)) {
                character.add(c);
            }
        }
        if (Math.abs(num.size() - character.size()) > 1) {
            return "";
        }
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        while (i != num.size() && j != character.size()) {
            ans.append(num.get(i++));
            ans.append(character.get(j++));
        }
        if (i < num.size()) {
            ans.append(num.get(i));
        }
        if (j < character.size()) {
            ans.reverse().append(character.get(j)).reverse();
        }
        return ans.toString();
    }
}
