import java.util.*;

public class Solution {
    static final int VISITING = 1, VISITED = 2;
    Map<Character, List<Character>> edges = new HashMap<>();//边
    Map<Character, Integer> states = new HashMap<>();//状态0未访问，1访问中，2已访问
    boolean valid = true;//有效的
    char[] order;//顺序(ans)
    int index;

    public String alienOrder(String[] words) {
        int length = words.length;
        //所有的结点
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }
        //为每个字符串构建边
        for (int i = 1; i < length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }
        //ans
        order = new char[edges.size()];
        index = edges.size() - 1;
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!states.containsKey(u)) {
                dfs(u);//效果不好，感觉可以只找入度为0的点，
            }
        }
        if (!valid) {
            return "";
        }
        return new String(order);
    }

    public void addEdge(String before, String after) {
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {//第一个不一样的字母
                edges.get(c1).add(c2);
                break;
            }
            index++;
        }
        //给的字符串序列就是错的
        if (index == length && length1 > length2) {
            valid = false;
        }
    }

    public void dfs(char u) {
        states.put(u, VISITING);
        List<Character> adjacent = edges.get(u);
        for (char v : adjacent) {
            if (!states.containsKey(v)) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (states.get(v) == VISITING) {//有环
                valid = false;
                return;
            }
        }
        states.put(u, VISITED);
        order[index] = u;
        index--;
    }
}
