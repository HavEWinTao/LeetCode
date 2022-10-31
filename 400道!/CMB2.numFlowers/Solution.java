package numFlowers;

public class Solution {
    public int numFlowers(int[][] roads) {
        int num = roads.length + 1;
        int[] outdegree = new int[num];
        int ans = Integer.MIN_VALUE;
        for (int[] road : roads) {
            outdegree[road[0]]++;
            outdegree[road[1]]++;
        }
        for (int temp : outdegree) {
            if (temp > ans) {
                ans = temp;
            }
        }
        return ans + 1;
    }
}
