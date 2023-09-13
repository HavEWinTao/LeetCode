import java.util.*;

public class Solution {

    List<String> ans = new ArrayList<>();
    int[] segments = new int[4];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[4];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int depth, int idx) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (depth == 4 && idx == s.length()) {
            StringBuffer addr = new StringBuffer();
            for (int i = 0; i < 4; ++i) {
                addr.append(segments[i]);
                if (i != 4 - 1) {
                    addr.append('.');
                }
            }
            ans.add(addr.toString());
            return;
        }
        //提前回溯
        if (depth == 4) return;
        if (idx == s.length()) return;

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(idx) == '0') {
            segments[depth] = 0;
            dfs(s, depth + 1, idx + 1);
            return;
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int i = idx; i < s.length(); i++) {
            addr = addr * 10 + (s.charAt(i) - '0');
            if (addr > 0 && addr <= 255) {
                segments[depth] = addr;
                dfs(s, depth + 1, i + 1);
            } else break;
        }
    }
}