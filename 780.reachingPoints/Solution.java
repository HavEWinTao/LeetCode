public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        //当一个坐标相同时，就看另一个坐标与原始坐标的差能否被整除
        if (sx == tx && (ty - sy) % sx == 0) {
            return true;
        }
        if (sy == ty && (tx - sx) % sy == 0) {
            return true;
        }
        //tx和ty有一个大小关系，两个数都取对方的余数，就只对较大数生效
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }
}
