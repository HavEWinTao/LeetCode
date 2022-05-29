import java.util.*;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }
        Map<String, List<String>> graph = new HashMap<>();
        List<String> banks = new ArrayList<>(Arrays.stream(bank).toList());
        boolean startIn = false;
        for (String s : banks) {
            if (s.equals(start)) {
                startIn = true;
                break;
            }
        }
        if (!startIn) {
            banks.add(start);
        }
        for (int i = 0; i < banks.size(); i++) {
            for (int j = i + 1; j < banks.size(); j++) {
                if (isEdge(banks.get(i), banks.get(j))) {
                    List<String> node1 = graph.getOrDefault(banks.get(i), new ArrayList<>());
                    List<String> node2 = graph.getOrDefault(banks.get(j), new ArrayList<>());
                    node1.add(banks.get(j));
                    node2.add(banks.get(i));
                    graph.put(banks.get(i), node1);
                    graph.put(banks.get(j), node2);
                }
            }
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        int ans = -1;
        Set<String> visit = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                visit.add(node);
                if (Objects.equals(node, end)) {
                    return ans;
                }
                for (String v : graph.get(node)) {
                    if (!visit.contains(v)) {
                        queue.offer(v);
                    }
                }
            }
        }
        return -1;
    }

    private boolean isEdge(String a, String b) {
        int flag = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                flag++;
            }
        }
        return flag == 7;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(solution.minMutation(start, end, bank));
    }
}
