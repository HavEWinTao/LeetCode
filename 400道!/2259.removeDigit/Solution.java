public class Solution {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        int index = 0;
        for (int i = 0; i < n; i++) {
            char c = number.charAt(i);
            if (c == digit) {
                index = i;
                if (i + 1 != n && number.charAt(i + 1) > digit) {
                    break;
                }
            }
        }
        return number.substring(0, index) + number.substring(index + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String number = "123";
        System.out.println(solution.removeDigit(number, '3'));
    }
}
