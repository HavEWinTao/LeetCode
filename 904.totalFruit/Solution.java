public class Solution {
    private static final int SIZE = 2;

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int temp = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (j < n && map.size() < SIZE) {
                int cnt = map.getOrDefault(fruits[j], 0);
                map.put(fruits[j], cnt + 1);
                j++;
                temp++;
            }
            while (j < n && map.containsKey(fruits[j])) {
                int cnt = map.get(fruits[j]);
                map.put(fruits[j], cnt + 1);
                j++;
                temp++;
            }
            ans = Math.max(ans, temp);
            while (map.size() == SIZE) {
                int cnt = map.get(fruits[i]);
                if (cnt > 1) {
                    map.put(fruits[i], cnt - 1);
                } else {
                    map.remove(fruits[i]);
                }
                i++;
                temp--;
            }
        }
        return ans;
    }
}