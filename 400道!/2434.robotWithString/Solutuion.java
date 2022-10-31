public class Solutuion {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minChar = new char[n];
        minChar[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minChar[i] = (char) Math.min(minChar[i + 1], s.charAt(i));
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= minChar[i]) {
                sb.append(stack.pop());
            }
            stack.add(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }  
}