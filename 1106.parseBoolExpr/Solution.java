public class Solution {
    public boolean parseBoolExpr(String expression) {
        char[] str = expression.toCharArray();
        int n = str.length;
        char[] stack = new char[n];
        int tail = 0;
        for (char c : str) {
            if (c == ',') {
                continue;
            }
            if (c == ')') {
                boolean flag1 = true;
                boolean flag2 = false;
                while (stack[--tail] != '(') {
                    flag1 = flag1 && (stack[tail] == 't');
                    flag2 = flag2 || (stack[tail] == 't');
                }
                tail--;
                if (stack[tail] == '!') {
                    stack[tail] = flag1 ? 'f' : 't';
                } else if (stack[tail] == '&') {
                    stack[tail] = flag1 ? 't' : 'f';
                } else {
                    stack[tail] = flag2 ? 't' : 'f';
                }
                tail++;
            } else {
                stack[tail++] = c;
            }
        }
        return stack[tail - 1] == 't';
    }
}