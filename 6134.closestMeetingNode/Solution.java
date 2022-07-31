import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map1 = ToNode(edges, node1);
        Map<Integer, Integer> map2 = ToNode(edges, node2);
        Set<Integer> set = new HashSet<>(map1.keySet());
        set.retainAll(map2.keySet());
        int ans = -1;
        int minLength = Integer.MAX_VALUE;
        for (int node : set) {
            int length = Math.max(map1.get(node), map2.get(node));
            if (length < minLength) {
                minLength = length;
                ans = node;
            }
            if (length == minLength) {
                ans = Math.min(ans, node);
            }
        }
        return ans;
    }

    private Map<Integer, Integer> ToNode(int[] edges, int node) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0;
        while (node != -1) {
            if (map.containsKey(node)) {
                break;
            }
            map.put(node, length);
            node = edges[node];
            length += 1;
        }
        return map;
    }
}
