public class Solution {

    public String validIPAddress(String queryIP) {
        int n = queryIP.length();
        String neither = "Neither";
        if (n == 0) return neither;
        if (queryIP.charAt(0) == '.' || queryIP.charAt(n - 1) == '.') return neither;
        String[] ipv4 = queryIP.split("\\.");
        if (queryIP.charAt(0) == ':' || queryIP.charAt(n - 1) == ':') return neither;
        String[] ipv6 = queryIP.split(":");
        if (ipv4.length == 4) {
            for (String str : ipv4) {
                int x;
                try {
                    x = Integer.parseInt(str);
                } catch (Exception e) {
                    return neither;
                }
                if (x <= 255 && x >= 0) {
                    if (!String.valueOf(x).equals(str)) return neither;
                } else return neither;
            }
            return "IPv4";
        }
        if (ipv6.length == 8) {
            for (String str : ipv6) {
                if (str.length() > 4 || str.isEmpty()) return neither;
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9')) continue;
                    else return neither;
                }
            }
            return "IPv6";
        }
        return neither;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            String s = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
            String ans = solution.validIPAddress(s);
            System.out.println(ans);
        }
    }
}