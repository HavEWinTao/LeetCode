import java.util.*;

public class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            List<Integer> temp;
            if (index.containsKey(cards[i])) {
                temp = index.get(cards[i]);
            } else {
                temp = new ArrayList<>();
            }
            temp.add(i);
            index.put(cards[i], temp);
        }
        int ans = Integer.MAX_VALUE;
        for (List<Integer> list : index.values()) {
            int n = list.size() - 1;
            for (int i = 0; i < n; i++) {
                int temp = list.get(i + 1) - list.get(i);
                ans = Math.min(ans, temp);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] cards = new int[]{3, 4, 2, 3, 4, 7};
        int[] cards = new int[]{1, 0, 5, 3};
        System.out.println(solution.minimumCardPickup(cards));
    }
}
