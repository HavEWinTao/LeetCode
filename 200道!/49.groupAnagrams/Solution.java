import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        int length = strs.length;
        List<Map<Character, Integer>> charCounter = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                if (map.containsKey(strs[i].charAt(j))) {
                    map.put(strs[i].charAt(j), map.get(strs[i].charAt(j)) + 1);
                } else {
                    map.put(strs[i].charAt(j), 1);
                }
            }
            charCounter.add(map);
        }
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                for (int j = i + 1; j < length; j++) {
                    if (!visited[j]) {
                        if (charCounter.get(i).equals(charCounter.get(j))) {
                            temp.add(strs[j]);
                            visited[j] = true;
                        }
                    }
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
