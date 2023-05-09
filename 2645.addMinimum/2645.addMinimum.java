public class addMinimum {
    public int addMinimum(String word) {
        int index = 0;
        int ans = 0;
        while (index < word.length()) {
            if (word.charAt(index) == 'a') {
                if (index + 1 < word.length()) {
                    if (word.charAt(index + 1) == 'a') {
                        ans += 2;
                        index += 1;
                    } else if (word.charAt(index + 1) == 'b') {
                        if (index + 2 < word.length()) {
                            if (word.charAt(index + 2) == 'c') {
                                index += 3;
                            } else {
                                ans += 1;
                                index += 2;
                            }
                        } else {
                            ans += 1;
                            index += 2;
                        }
                    } else {
                        ans += 1;
                        index += 2;
                    }
                } else {
                    ans += 2;
                    index += 1;
                }
            } else if (word.charAt(index) == 'b') {//b
                if (index + 1 < word.length()) {
                    if (word.charAt(index + 1) == 'c') {
                        ans += 1;
                        index += 2;
                    } else {
                        ans += 2;
                        index += 1;
                    }
                } else {
                    ans += 2;
                    index += 1;
                }
            } else {//c
                ans += 2;
                index += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        addMinimum solution = new addMinimum();
        String s = "abc";
        System.out.println(solution.addMinimum(s));
    }
}
