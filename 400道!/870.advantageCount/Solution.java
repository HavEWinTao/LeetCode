public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, cnt + 1);
        }
        for (int i = 0; i < n; i++) {
            int num = nums2[i];
            Integer key = map.ceilingKey(num + 1);
            if (key == null) {
                key = map.firstKey();
            }
            int cnt = map.get(key);
            if (cnt == 1) {
                map.remove(key);
            } else {
                map.put(key, cnt - 1);
            }
            ans[i] = key;
        }
        return ans;
    }
}