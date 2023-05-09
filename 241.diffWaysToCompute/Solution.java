import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = expression.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!Character.isDigit(aChar)) {
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        if (aChar == '+') {
                            ans.add(left + right);
                        } else if (aChar == '-') {
                            ans.add(left - right);
                        } else {
                            ans.add(left * right);
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }
}
