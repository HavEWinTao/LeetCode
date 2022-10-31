public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[] q2w = new double[n];
        for (int i = 0; i < n; i++) {
            q2w[i] = quality[i] / wage[i];
        }
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(h, (o1, o2) -> {
            return w2q[o2] - w2q[o1];
        });
    }
}

