import java.util.*;

public class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 0);
        for (int i = 0; i < n; i++) {
            int length = positions[i][1];
            int l = positions[i][0], r = l + length - 1;
            //HigherKey()方法用于返回比给定键元素(key_ele)高的最低键值元素
            Integer lp = heightMap.higherKey(l), rp = heightMap.higherKey(r);
            Integer prevRightKey = rp != null ? heightMap.lowerKey(rp) : heightMap.lastKey();//这个值小于等于r
            Integer prevLeftKey = lp != null ? heightMap.lowerKey(lp) : heightMap.lastKey();//这个值小于等于l
            // 记录 right + 1 对应的堆叠高度（如果 right + 1 不在 heightMap 中）
            int rHeight = prevRightKey != null ? heightMap.get(prevRightKey) : 0;

            // 更新第 i 个掉落的方块的堆叠高度
            int height = 0;
            Map<Integer, Integer> tail = heightMap.tailMap(prevLeftKey);
            //找到当前方块放上去之后的高度
            for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
                if (Objects.equals(entry.getKey(), rp)) {
                    break;
                }
                height = Math.max(height, entry.getValue() + length);
            }
            // 清除 heightMap 中位于 (left, right] 内的点
            Set<Integer> keySet = new TreeSet<>(tail.keySet());
            for (Integer tmp : keySet) {
                if (lp == null || tmp < lp) {
                    continue;
                }
                if (rp != null && tmp >= rp) {
                    break;
                }
                heightMap.remove(tmp);
            }
            heightMap.put(l, height); // 更新 left 的变化
            // 如果 right + 1 不在 heightMap 中，更新 right + 1 的变化，如果right+1本身就存在的话就不需要加了
            if (rp == null || rp != r + 1) {
                heightMap.put(r + 1, rHeight);
            }
            //保存当前方块放下后的高度
            height = i > 0 ? Math.max(ans.get(i - 1), height) : height;
            ans.add(height);
        }
        return ans;
    }
}
