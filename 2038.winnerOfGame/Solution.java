public class Solution {
    //脑筋急转弯
    //根据删除规则，删除任意一个 A 不会影响可被删删除的 B 的数量，反之亦然
    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    alice++;
                }
                if (colors.charAt(i) == 'B') {
                    bob++;
                }
            }
        }
        return alice > bob;
    }

    public boolean winnerOfGame2(String colors) {
        int a = 0, b = 0, acnt = 0, bcnt = 0;
        for (char ch : colors.toCharArray()) {
            if (ch == 'A') {
                if (++acnt > 2) {
                    a++;
                }
                bcnt = 0;
            } else {
                if (++bcnt > 2) {
                    b++;
                }
                acnt = 0;
            }
        }
        return a > b;
    }
}
