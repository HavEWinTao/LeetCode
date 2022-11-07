public class Solution {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        s = s.substring(1, n - 1);
        n = n - 2;
        for (int i = 1; i < n; i++) {
            ans.addAll(cal(s.substring(0, i), s.substring(i)));
        }
        return ans;
    }

    private List<String> cal(String s1, String s2) {
        List<String> left = parse(s1);
        List<String> right = parse(s2);
        List<String> ret = new ArrayList<>();
        for (String item1 : left) {
            for (String item2 : right) {
                ret.add("(" + item1 + ", " + item2 + ")");
            }
        }
        return ret;
    }

    private List<String> parse(String s) {
        List<String> ret = new ArrayList<>();
        int n = s.length();
        if (n == 1) {
            ret.add(s);
            return ret;
        }
        if (s.charAt(n - 1) != '0' && s.charAt(0) != '0') {
            //放小数点
            //小数点放到第i位后
            for (int i = 0; i < n - 1; i++) {
                String num = s.substring(0, i + 1) + "." + s.substring(i + 1);
                ret.add(num);
            }
        }
        if (s.charAt(0) == '0' && s.charAt(n - 1) != '0') {
            String num = s.charAt(0) + "." + s.substring(1);
            ret.add(num);
        }
        if (s.charAt(0) != '0') {
            ret.add(s);
        }
        return ret;
    }
}