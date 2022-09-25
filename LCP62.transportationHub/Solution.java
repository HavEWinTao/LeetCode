class Solution {
    public int transportationHub(int[][] path) {
        int[] in = new int[1010];
        int[] out = new int[1010];
        Set<Integer> set = new HashSet<>();
        for (int[] t : path) {
            out[t[0]]++;
            in[t[1]]++;
            set.add(t[0]);
            set.add(t[1]);
        }
        for (int i = 0; i < 1010; i++) {
            if (in[i] == set.size() - 1) {
                if (out[i] == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}