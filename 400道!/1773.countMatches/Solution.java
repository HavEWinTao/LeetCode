public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int n = items.size();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        for (List<String> item : items) {
            String type = item.get(0);
            String color = item.get(1);
            String name = item.get(2);
            int cnt;
            cnt = map1.getOrDefault(type, 0);
            map1.put(type, cnt + 1);
            cnt = map2.getOrDefault(color, 0);
            map2.put(color, cnt + 1);
            cnt = map3.getOrDefault(name, 0);
            map3.put(name, cnt + 1);
        }
        Map<String, Integer> map;
        if (ruleKey.equals("type")) {
            map = map1;
        } else if (ruleKey.equals("color")) {
            map = map2;
        } else {
            map = map3;
        }
        return map.getOrDefault(ruleValue, 0);
    }
}