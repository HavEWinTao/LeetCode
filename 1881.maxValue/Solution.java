public class Solution {
    public String maxValue(String n, int x) {
        int length = n.length();
        StringBuilder sb = new StringBuilder();
        if (n.charAt(0) == '-') {
            sb.append('-');
            for (int i = 1; i < length; i++) {
                int temp = n.charAt(i) - '0';
                if (x < temp) {
                    sb.append(x);
                    sb.append(n.substring(i));
                    return sb.toString();
                } else {
                    sb.append(temp);
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                int temp = n.charAt(i) - '0';
                if (x > temp) {
                    sb.append(x);
                    sb.append(n.substring(i));
                    return sb.toString();
                } else {
                    sb.append(temp);
                }
            }
        }
        sb.append(x);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue("99", 9));
    }
}
