import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int n = nums.length;
        int m = nums[0].length();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int trim = query[1];
            List<String[]> temp = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                String num = nums[j];
                num = num.substring(m - trim);
                temp.add(new String[]{num, String.valueOf(j)});
            }
            temp.sort(((o1, o2) -> {
                if (!Objects.equals(o1[0], o2[0])) {
                    return o1[0].compareTo(o2[0]);
                } else {
                    Integer a = Integer.parseInt(o1[1]);
                    Integer b = Integer.parseInt(o2[1]);
                    return a.compareTo(b);
                }
            }));
            ans[i] = Integer.parseInt(temp.get(query[0] - 1)[1]);
        }
        return ans;
    }

    private int strNumCMP(String num1,String num2) {
        int i = 0, j = 0;
        int length1 = num1.length(), length2 = num2.length();
        while (num1.charAt(i) == '0') {
            i++;
        }
        while (num2.charAt(j) == '0') {
            j++;
        }
        length1 -= i;
        length2 -= j;
        if (length1 < length2) {
            return -1;
        } else if (length1 == length2) {
            while (i < length1) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(i++) - '0';
                if (a < b) {
                    return -1;
                }
                if (a > b) {
                    return 1;
                }
            }
        } else {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] nums = new String[]{"64333639502", "65953866768", "17845691654", "87148775908", "58954177897", "70439926174", "48059986638", "47548857440", "18418180516", "06364956881", "01866627626", "36824890579", "14672385151", "71207752868"};
        int[][] queries = new int[][]{{9, 4}, {6, 1}, {3, 8}, {12, 9}, {11, 4}, {4, 9}, {2, 7}, {10, 3}, {13, 1}, {13, 1}, {6, 1}, {5, 10}};
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums, queries)));
    }
}
