public class Solution {
    public String validIPAddress(String queryIP) {
        int n = queryIP.length();
        if (n==0){
            return "Neither";
        }
        if (queryIP.charAt(n - 1) == ':' || queryIP.charAt(0) == ':') {
            return "Neither";
        }
        if (queryIP.charAt(n - 1) == '.' || queryIP.charAt(0) == '.') {
            return "Neither";
        }
        String[] ipv4 = queryIP.split("\\.");
        String[] ipv6 = queryIP.split(":");
        if (ipv4.length == 4) {
            for (String str : ipv4) {
                int x;
                try {
                    x = Integer.parseInt(str);
                } catch (Exception e) {
                    return "Neither";
                }
                if (x <= 255 && x >= 0) {
                    if (String.valueOf(x).equals(str)) {
                        continue;
                    } else {
                        return "Neither";
                    }
                }
                return "Neither";
            }
            return "IPv4";
        }
        if (ipv6.length == 8) {
            for (String str : ipv6) {
                if (str.length() > 4 || str.length() < 1) {
                    return "Neither";
                }
                for (int i = 0; i < str.length(); i++) {
                    if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'f') ||
                            (str.charAt(i) >= 'A' && str.charAt(i) <= 'F') ||
                            (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                        continue;
                    } else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validIPAddress("1e1.4.5.6"));
    }
}
