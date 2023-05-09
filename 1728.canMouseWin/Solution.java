import java.util.Arrays;

class Solution {
    private int m, n;
    private int maxTurn;
    private int[] foodPos = new int[2];
    private int[] mcjump = new int[2];

    private final int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        m = grid.length;
        n = grid[0].length();
        int block = 0;
        int[] catPos0 = new int[2];
        int[] mousePos0 = new int[2];
        mcjump[0] = mouseJump;
        mcjump[1] = catJump;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '#') {
                    block++;
                }
                if (grid[i].charAt(j) == 'C') {//猫的位置
                    catPos0[0] = i;
                    catPos0[1] = j;
                }
                if (grid[i].charAt(j) == 'M') {//老鼠的位置
                    mousePos0[0] = i;
                    mousePos0[1] = j;
                }
                if (grid[i].charAt(j) == 'F') {//食物的位置
                    foodPos[0] = i;
                    foodPos[1] = j;
                }
            }
        }
        maxTurn = (n * m - block - 2) * 2;
        return move(mousePos0, catPos0, 0, grid);
    }

    //dp(mousePos,catPos,turn)代表：给定猫和老鼠的位置，以及当前的轮数，返回老鼠是否能赢
    //turn最多为“空格数x2”（食物也算空格），不用等1000轮。因为如果猫能赢，猫肯定直冲食物或者活捉老鼠。老鼠也同样。只要有一方能赢就不会绕圈，因此最多空格x2轮（食物也算空格）。
    //此题允许原地不动，但猫可以原地不动，老鼠不能，因为如果老鼠原地不动了，猫也选择原地不动，大家一直等下去最后到达轮数限制猫会赢。
    private boolean move(int[] mousePos, int[] catPos, int turn, String[] grid) {
        if ((turn > maxTurn) ||//超过最大轮数
                (mousePos[0] == catPos[0] && mousePos[1] == catPos[1]) ||//猫在老鼠处
                (catPos[0] == foodPos[0] && catPos[1] == foodPos[1])) {//猫在食物处
            return false;
        }
        if (mousePos[0] == foodPos[0] && mousePos[1] == foodPos[1]) {//老鼠在食物处
            return true;
        }
        int jump = mcjump[turn % 2];
        int[] curPos = (turn % 2 == 0 ? mousePos : catPos);
        for (int[] ints : direction) {
            int di = ints[0];
            int dj = ints[1];
            for (int jumpStep = 0; jumpStep <= jump; jumpStep++) {
                if (jumpStep == 0 && turn % 2 == 0) {//猫能原地不动但老鼠不能
                    continue;
                }
                int i2 = curPos[0] + di * jumpStep;
                int j2 = curPos[1] + dj * jumpStep;
                if (i2 >= m || i2 < 0 || j2 >= n || j2 < 0 || grid[i2].charAt(j2) == '#') {
                    break;
                }
                int[] mousePos2 = new int[2];
                int[] catPos2 = new int[2];
                if (turn % 2 == 1) {
                    mousePos2[0] = mousePos[0];
                    mousePos2[1] = mousePos[1];
                    catPos2[0] = i2;
                    catPos2[1] = j2;
                } else {
                    mousePos2[0] = i2;
                    mousePos2[1] = j2;
                    catPos2[0] = catPos[0];
                    catPos2[1] = catPos[1];
                }
                boolean mouseWin = move(mousePos2, catPos2, turn + 1, grid);
                if (turn % 2 == 0 && mouseWin) {
                    return true;
                }
                if (turn % 2 != 0 && !mouseWin) {
                    return false;
                }
            }
        }
        return turn % 2 != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] grid = new String[]{"C...#", "...#F", "....#", "M...."};
        int catJump = 2;
        int mouseJump = 5;
        System.out.println(solution.canMouseWin(grid, catJump, mouseJump));
    }
}
