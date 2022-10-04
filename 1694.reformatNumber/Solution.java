public class Solution {
    public String reformatNumber(String number) {
        number = number.replaceAll(" ", "");
        number = number.replaceAll("-", "");
        int n = number.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (n - index > 4) {
            sb.append(number.substring(index, index + 3));
            index += 3;
            sb.append("-");
        }
        if (n - index == 2) {
            sb.append(number, index, index + 2);
        } else if (n - index == 3) {
            sb.append(number, index, index + 3);
        } else {
            sb.append(number, index, index + 2);
            sb.append("-");
            index += 2;
            sb.append(number, index, index + 2);
        }
        return sb.toString();
    }
}