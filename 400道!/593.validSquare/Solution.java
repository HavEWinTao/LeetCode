package src;

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int length12 = calDistancePowBase2(p1, p2);
        int length13 = calDistancePowBase2(p1, p3);
        int length14 = calDistancePowBase2(p1, p4);
        try {
            if (isVertical(getLine(p1, p2), getLine(p1, p3)) && isVertical(getLine(p4, p2), getLine(p4, p3))) {
                return length12 == length13;
            }
            if (isVertical(getLine(p1, p2), getLine(p1, p4)) && isVertical(getLine(p3, p2), getLine(p3, p4))) {
                return length12 == length14;
            }
            if (isVertical(getLine(p1, p3), getLine(p1, p4)) && isVertical(getLine(p2, p3), getLine(p2, p4))) {
                return length13 == length14;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private int[] getLine(int[] p1, int[] p2) throws Exception {
        if (p1[0] - p2[0] == 0 && p1[1] - p2[1] == 0) {
            throw new RuntimeException("点相同");
        }
        return new int[]{p1[0] - p2[0], p1[1] - p2[1]};
    }

    private boolean isVertical(int[] line1, int[] line2) {
        return line1[0] * line2[0] + line1[1] * line2[1] == 0;
    }

    private int calDistancePowBase2(int[] p1, int[] p2) {
        return (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p1 = new int[]{0, 0};
        int[] p2 = new int[]{1, 1};
        int[] p3 = new int[]{1, 0};
        int[] p4 = new int[]{0, 1};
        System.out.println(solution.validSquare(p1, p2, p3, p4));
    }
}
