public class Solution {
    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        char[] str1 = strs[0].toCharArray();
        char[] str2 = strs[1].toCharArray();
        int[] num1 = simplify(str1);
        int[] num2 = simplify(str2);
        num1[0] -= num2[0];
        num1[1] -= num2[1];
        if (num1[0] == 0 && num1[1] == 0) {
            return "Infinite solutions";
        }
        if (num1[0] == 0) {
            return "No solution";
        }
        return "x=" + (-num1[1] / num1[0]);
    }

    private int[] simplify(char[] str) {
        int[] num = new int[2];
        int i = 0;
        boolean sign = true;
        while (i < str.length) {
            char c = str[i];
            if (Character.isDigit(c)) {
                int j = i;
                int temp = 0;
                boolean flag = false;
                while (j < str.length && str[j] != '+' && str[j] != '-') {
                    if (str[j] != 'x') {
                        temp = temp * 10 + (str[j] - '0');
                    } else {
                        flag = true;
                    }
                    j++;
                }
                if (!sign) {
                    temp = -temp;
                }
                if (flag) {
                    num[0] += temp;
                } else {
                    num[1] += temp;
                }
                i = j - 1;
            }
            if (c == 'x') {
                if (!sign) {
                    num[0]--;
                } else {
                    num[0]++;
                }
            }
            if (c == '+') {
                sign = true;
            }
            if (c == '-') {
                sign = false;
            }
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String equation = "-x=-1";
        System.out.println(solution.solveEquation(equation));
    }
}
