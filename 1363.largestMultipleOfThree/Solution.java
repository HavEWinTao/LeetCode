import java.util.*;

public class Solution {

    public String largestMultipleOfThree(int[] digits) {
        int[] cnt = new int[10];
        int sum = 0;
        int[] mod2cnt = new int[3];
        for (int digit : digits) {
            sum += digit;
            cnt[digit]++;
            mod2cnt[digit % 3]++;
        }
        if (sum % 3 == 1) {
            if (mod2cnt[1] > 0) {
                for (int i = 0; i * 3 + 1 <= 9; i++) {
                    if (cnt[i * 3 + 1] > 0) {
                        cnt[i * 3 + 1]--;
                        break;
                    }
                }
            } else if (mod2cnt[2] > 1) {
                int num = 2;
                for (int i = 0; i * 3 + 2 <= 9; i++) {
                    while (num > 0 && cnt[i * 3 + 2] > 0) {
                        cnt[i * 3 + 2]--;
                        num--;
                    }
                }
            } else return "";
        }
        if (sum % 3 == 2) {
            if (mod2cnt[2] > 0) {
                for (int i = 0; i * 3 + 2 <= 9; i++) {
                    if (cnt[i * 3 + 2] > 0) {
                        cnt[i * 3 + 2]--;
                        break;
                    }
                }
            } else if (mod2cnt[1] > 1) {
                int num = 2;
                for (int i = 0; i * 3 + 1 <= 9; i++) {
                    while (num > 0 && cnt[i * 3 + 1] > 0) {
                        cnt[i * 3 + 1]--;
                        num--;
                    }
                }
            } else return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            while (cnt[i] > 0) {
                sb.append(i);
                cnt[i]--;
            }
        }
        if (sb.length() == 0) return "";
        if (sb.charAt(sb.length() - 1) == '0') return "0";
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            int[] digits = new int[]{8, 1, 9};
            String ans = solution.largestMultipleOfThree(digits);
            System.out.println(ans);
        }
        {
            int[] digits = new int[]{8, 6, 7, 1, 0};
            String ans = solution.largestMultipleOfThree(digits);
            System.out.println(ans);
        }
        {
            int[] digits = new int[]{1};
            String ans = solution.largestMultipleOfThree(digits);
            System.out.println(ans);
        }
        {
            int[] digits = new int[]{0, 0, 0, 0, 0, 0};
            String ans = solution.largestMultipleOfThree(digits);
            System.out.println(ans);
        }
    }
}