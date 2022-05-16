import java.util.*;

public class Solution {

    //状态压缩？其实就是用二进制数来表示动态规划状态转移过程中的状态。

    //什么时候应该状态压缩？状态压缩的题目，一般都会有非常明显的标志：如果你看到有一个参数的数值小于20
    //同时这道题目中有涉及到是否选取、是否使用这样的二元状态，那么这道题目很可能就是一道状态压缩的题目。

    public int minStickers(String[] stickers, String target) {
        int n = stickers.length, m = target.length();
        int[] dp = new int[1 << m];//target长度是m所以一共2^m个状态，0不选1选
        Arrays.fill(dp, -1);//dp中保存的是当前m状态需要的个数
        dp[0] = 0;
        for (String sticker : stickers) {//对于每一个sticker都进行遍历
            //起始时有 state = 0，最终若能凑成target，则有state=(1<<n)-1
            for (int status = 0; status < (1 << m); status++) {//遍历每一个状态,看他们能转移到什么状态
                if (dp[status] == -1) {
                    continue;
                }
                int curStatus = status;//若t[i]已被凑成，则在curstate中低i位为1，否则为0
                //已经变成1的位不会变回0，所以10000 -> 01111 是不存在的
                for (char c : sticker.toCharArray()) {
                    for (int i = 0; i < m; i++) {
                        if (c == target.charAt(i) && (curStatus & (1 << i)) == 0) {//当前这位还没有被使用过
                            curStatus |= 1 << i;
                            break;//因为当前这个字母已经使用过了。所以从下一个字母c开始
                        }
                    }
                }
                dp[curStatus] = dp[curStatus] == -1 ? dp[status] + 1 : Math.min(dp[curStatus], dp[status] + 1);
            }
        }
        //dp的大小是2^m,下标最大是2^m-1，而上面state最大是2^(m-1)，正好对应最高位为1
        return dp[(1 << m) - 1];//11111这样的
    }
}
