import java.util.HashMap;
import java.util.Map;

public class Solution {
public String minWindow(String s_, String t_) {
        Map<Character, Integer> map1 = new HashMap<>();
        char[] s = s_.toCharArray();
        char[] t = t_.toCharArray();
        for (char c : t) {
            Integer cnt = map1.getOrDefault(c, 0);
            map1.put(c, cnt + 1);
        }
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int index1 = 0, index2 = 0;
        while (j <= s.length && i <= j) {
            if (cntAllMap(map1)) {
                if (j == s.length) {
                    break;
                }
                if (map1.containsKey(s[j])) {
                    map1.put(s[j], map1.get(s[j]) - 1);
                }
                j++;
            } else {
                if (j - i < minLen) {
                    minLen = j - i;
                    index1 = i;
                    index2 = j;
                }
                if (map1.containsKey(s[i])) {
                    map1.put(s[i], map1.get(s[i]) + 1);
                }
                i++;
            }
        }
        return s_.substring(index1, index2);
    }

    private boolean cntAllMap(Map<Character, Integer> map) {
        for (int cnt : map.values()) {
            if (cnt > 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s_ = "ADOBECODEBANC";
        String t_ = "ABC";
        System.out.println(solution.minWindow(s_, t_));
    }
}
