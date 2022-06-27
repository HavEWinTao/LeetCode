import java.util.*;

public class Solution {
    Map<Integer, Integer> b2w;
    Random random;
    int bound;

    public Solution(int n, int[] blacklist) {
        b2w = new HashMap<>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;//白名单中数字个数
        //初始化黑名单
        Set<Integer> black = new HashSet<>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }
        //把小于bound的黑名单中的数映射出去
        //因为黑名单数量m和n是确定的，所以w一定在n的范围内
        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (black.contains(w)) {
                    ++w;
                }
                b2w.put(b, w);
                ++w;
            }
        }
    }

    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }
}
