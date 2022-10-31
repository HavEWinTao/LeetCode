package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public List<List<Integer>> groupThePeople(int[] gs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < gs.length; i++) {
            int num = gs[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 0; i < list.size(); i += key) {
                List<Integer> temp = new ArrayList<>();
                for (int j = i; j < i + key; j++) {
                    temp.add(list.get(j));
                }
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] groupSize = new int[]{3, 3, 3, 3, 3, 1, 3};
        System.out.println(solution1.groupThePeople(groupSize));
    }
}
