public class Solution {

    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length() + num2.length() + 1];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int c = 0;
            int n1 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n2 = num1.charAt(j) - '0';
                int idx = (num2.length() - i - 1) + (num1.length() - j - 1);
                nums[idx] += c + n1 * n2;
                c = nums[idx] / 10;
                nums[idx] %= 10;
            }
            if (c != 0) nums[num1.length() + num2.length() - i-1] += c;
        }

        StringBuilder sb = new StringBuilder();
        int idx = nums.length - 1;
        while (idx >= 0 && nums[idx] == 0) idx--;
        if (idx == -1) return "0";
        while (idx >= 0) {
            sb.append(nums[idx--]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            String num1 = "123";
            String num2 = "456";
            String ans = solution.multiply(num1, num2);
            System.out.println(ans);
        }
        {
            String num1 = "98";
            String num2 = "9";
            String ans = solution.multiply(num1, num2);
            System.out.println(ans);
        }
        {
            String num1 = "9";
            String num2 = "9";
            String ans = solution.multiply(num1, num2);
            System.out.println(ans);
        }
        {
            String num1 = "9";
            String num2 = "99";
            String ans = solution.multiply(num1, num2);
            System.out.println(ans);
        }
    }
}