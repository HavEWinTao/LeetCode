import java.util.Arrays;

class Solution {
    //subtraction(b,a)求的是向量ab  subtraction(c,a)求的是向量ac
    int[] subtraction(int[] a, int[] b) { // 向量相减
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }

    //叉乘！！！！！
    //叉乘公式定义获得到的值k就是k=a.x*b.y-b.x*a.y
    //如果k>0时，那么a正旋转到b的角度为<180°，如果k<0，那么a正旋转到b的角度为>180°,如果k=0 那么a，b向量平行。
    double cross(int[] a, int[] b) { // 叉乘
        return a[0] * b[1] - a[1] * b[0];
    }

    //通过平面两点向量叉乘判断当前ac向量是在顺时针方向还是逆时针方向
    double getArea(int[] a, int[] b, int[] c) { //向量ab转为向量ac过程中扫过的面积
        return cross(subtraction(b, a), subtraction(c, a));
    }

    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });
        int n = trees.length, tp = 0;
        int[] stk = new int[n + 10];
        boolean[] vis = new boolean[n + 10];
        stk[++tp] = 0;//不标记起点
        for (int i = 1; i < n; i++) {
            int[] c = trees[i];
            while (tp >= 2) {
                int[] a = trees[stk[tp - 1]], b = trees[stk[tp]];
                if (getArea(a, b, c) > 0) vis[stk[tp--]] = false;
                else break;
            }
            stk[++tp] = i;
            vis[i] = true;
        }

        int size = tp;
        for (int i = n - 1; i >= 0; i--) {
            if (vis[i]) continue;
            int[] c = trees[i];
            while (tp > size) {
                int[] a = trees[stk[tp - 1]], b = trees[stk[tp]];
                if (getArea(a, b, c) > 0) tp--;
                else break;
            }
            stk[++tp] = i;
        }

        int[][] ans = new int[tp - 1][2];
        for (int i = 1; i < tp; i++) ans[i - 1] = trees[stk[i]];
        return ans;
    }
}