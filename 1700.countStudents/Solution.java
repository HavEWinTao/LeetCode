public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;

        LinkedList<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.add(sandwiches[i]);
            queue.addFirst(students[i]);
        }
        loop:
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int num = n;
            while (num > 0) {
                int student = queue.removeFirst();
                if (student == top) {
                    n--;
                    continue loop;
                }
                queue.addLast(student);
                num--;
            }
            break;
        }
        return n;
    }

    //想到了，但是没写，这种写法O(n)
    public int countStudents1(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }
}