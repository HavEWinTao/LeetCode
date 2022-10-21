public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int cnt = map.getOrDefault(word, 0);
            if (cnt == 0) {
                ans.add(word);
            }
            map.put(word, cnt + 1);
        }
        ans.sort((s1, s2) -> {
            int cnt1 = map.get(s1);
            int cnt2 = map.get(s2);
            if (cnt1 == cnt2) {
                return s1.compareTo(s2);
            }
            return Integer.compare(cnt2, cnt1);
        });
        return ans.subList(0, k);
    }
}