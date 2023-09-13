import java.util.*;

class SolBase {

    private Random r = new Random();

    public int rand7() {
        return r.nextInt(7) + 1;
    }
}

public class Solution extends SolBase {
    public int rand10() {
        int r1 = rand7();
        int r2 = rand7();
        //8~56--->1~49--->1~48
        int num = r1 * 7 + r2 - 7 - 1;
        if (num >= 40) return rand10();
        return num / 4 + 1;
    }
}