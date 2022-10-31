public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    //使用mod进行取模的原因防止计算时出现溢出，相加时防止int类型溢出，相乘防止long类型溢出
    //同时当数值比mod小的时候，取余数，对结果不会有影响。
    //加减法mod顺序任意
    public int distinctSubseqII(String s) {
        int[] repeat = new int[26];
        int ans = 0;
        for (char c : s.toCharArray()) {
            int newAdd = ans + 1;
            ans = (ans + newAdd) % MOD;
            ans = (ans - repeat[c - 'a'] + MOD) % MOD;//加MOD，不然可能出现负数
            repeat[c - 'a'] = newAdd;
        }
        return ans;
    }
}