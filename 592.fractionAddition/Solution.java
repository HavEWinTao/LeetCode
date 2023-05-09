import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution {
    public String fractionAddition(String expression) {
        char[] str = expression.toCharArray();
        Deque<frac> deque = new ArrayDeque<>();
        int index = 0;
        int length = expression.length();
        while (index < length - 1) {
            char c = str[index];
            boolean sign = (c == '+');
            if (index == 0 && Character.isDigit(c)) {
                sign = true;
                index = -1;
            }
            int numerator = 0;
            while (str[++index] != '/') {
                numerator = numerator * 10 + str[index] - '0';
            }
            int denominator = 0;
            while (index < length - 1 && Character.isDigit(str[++index])) {
                denominator = denominator * 10 + str[index] - '0';
            }
            deque.addLast(new frac(sign, numerator, denominator));
        }
        while (deque.size() > 1) {
            frac num1 = deque.pollFirst();
            frac num2 = deque.pollFirst();
            deque.addFirst(num1.add(num2));
        }
        return deque.pollFirst().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String expression = "1/3-1/2";
        System.out.println(solution.fractionAddition(expression));
    }
}

class frac {
    boolean sign;
    int numerator;
    int denominator;

    frac(boolean sign, int numerator, int denominator) {
        this.sign = sign;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return getGCD(b, a % b);
        }
    }

    public frac add(frac num) {
        int gcd = getGCD(this.denominator, num.denominator);
        int factor1 = num.denominator / gcd;
        int factor2 = this.denominator / gcd;
        this.numerator *= factor1;
        this.denominator *= factor1;
        num.numerator *= factor2;
        num.denominator *= factor2;
        int numerator;
        boolean sign = this.sign;
        if (this.sign == num.sign) {
            numerator = this.numerator + num.numerator;
        } else {
            if (this.numerator < num.numerator) {
                sign = num.sign;
            }
            numerator = Math.abs(this.numerator - num.numerator);
        }
        int factor3 = getGCD(numerator, this.denominator);
        numerator /= factor3;
        if (numerator == 0) {
            sign = true;
        }
        return new frac(sign, numerator, this.denominator / factor3);
    }

    @Override
    public String toString() {
        String ret = this.sign ? "" : "-";
        return ret +
                this.numerator +
                '/' +
                this.denominator;
    }
}