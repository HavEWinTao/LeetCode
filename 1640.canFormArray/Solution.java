public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int index = 0;
        int n = arr.length;
        int m = pieces.length;
        boolean[] visit = new boolean[m];
        loop:
        while (index < n) {
            for (int i = 0; i < m; i++) {
                int temp = index;
                if (!visit[i]) {
                    int j = 0;
                    while (j < pieces[i].length && arr[temp] == pieces[i][j]) {
                        temp++;
                        j++;
                    }
                    if (j == pieces[i].length) {
                        visit[i] = true;
                        index += pieces[i].length;
                        continue loop;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2, 82, 79, 95, 28};
        int[][] pieses = new int[][]{{2}, {82}, {28}, {79, 95}};
        System.out.println(solution.canFormArray(arr, pieses));
    }
}