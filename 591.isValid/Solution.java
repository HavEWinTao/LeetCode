public class Solution {
    public boolean isValid(String code) {
        //虽然正则是\[就表示匹配[，但是在字符串里得是\\[将\转义
        String CDATA_CONTENT_PATTERN = "<!\\[CDATA\\[.*?]]>";
        //()标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。
        //[]标记一个中括号表达式的开始,表示的是匹配的范围，要匹配[使用\[。
        String TAG_CONTENT_PATTERN = "<([A-Z]{1,9})>[^<]*</\\1>";
        //</DIV><DIV>test
        code = code.replaceAll(CDATA_CONTENT_PATTERN, "</DIV><DIV>test");
        String temp = code;
        //code = code.replaceAll(TAG_CONTENT_PATTERN,"#");
        while (true) {
            code = code.replaceFirst(TAG_CONTENT_PATTERN, "#");
            if (temp.equals(code)) {
                break;
            } else {
                temp = code;
            }
        }
        return code.equals("#");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        System.out.println(solution.isValid(code));
    }
}
