import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> morse = new HashMap<>();
        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c', "-.-.");
        morse.put('d', "-..");
        morse.put('e', ".");
        morse.put('f', "..-.");
        morse.put('g', "--.");
        morse.put('h', "....");
        morse.put('i', "..");
        morse.put('j', ".---");
        morse.put('k', "-.-");
        morse.put('l', ".-..");
        morse.put('m', "--");
        morse.put('n', "-.");
        morse.put('o', "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s', "...");
        morse.put('t', "-");
        morse.put('u', "..-");
        morse.put('v', "...-");
        morse.put('w', ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");

        Set<String> ans = new HashSet<>();
        for (String word : words) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                temp.append(morse.get(word.charAt(i)));
            }
            ans.add(temp.toString());
        }
        return ans.size();
    }
}
