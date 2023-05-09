public class Solution {
    private char[] start1;
    private char[] target1;

    public boolean canChange(String start, String target) {
        int n = start.length();
        start1 = start.toCharArray();
        target1 = target.toCharArray();
        for (int i = 0; i < n; i++) {
            if (start1[i] == target1[i]) {
                continue;
            }
            char c = target1[i];
            if (c == 'L') {
                int index = i;
                while (index < n && start1[index] == '_') {
                    index++;
                }
                if (index == n) {
                    return false;
                }
                if (start1[index] == 'R') {
                    return false;
                } else {
                    swap(index, i);
                }
            }
            if (c == 'R') {
                return false;
            }
            if (c == '_') {
                int index = i;
                while (index < n && start1[index] == 'R') {
                    index++;
                }
                if (index == n) {
                    return false;
                }
                if (start1[index] == '_') {
                    swap(i, index);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void swap(int a, int b) {
        char temp = start1[a];
        start1[a] = start1[b];
        start1[b] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String start = "_LL__R__R_";
        String target = "L___L___RR";
        System.out.println(solution.canChange(start, target));
    }
}
