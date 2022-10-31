import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int lengthLongestPath(String input) {
        TreeNode root = new TreeNode();
        String[] paths = input.split("\n");
        Stack<TreeNode> stack = new Stack<>();
        int ans = 0;
        int nowLength = 0;
        for (String path : paths) {
            if (stack.isEmpty()) {
                root.path = path.replace("\t", "");
                root.rank = 0;
                root.isDirectionary = !path.contains(".");
                nowLength += root.path.length();
                if (root.isDirectionary) {
                    stack.add(root);
                } else {
                    if (nowLength + root.rank > ans) {
                        ans = nowLength;
                    }
                    nowLength -= root.path.length();
                }
            } else {
                int rank = 0;
                while (path.charAt(rank) == '\t') {
                    rank++;
                }
                TreeNode temp = new TreeNode();
                temp.path = path.replace("\t", "");
                temp.rank = rank;
                temp.isDirectionary = !path.contains(".");
                nowLength += temp.path.length();
                while (!stack.isEmpty() && rank <= stack.peek().rank) {
                    nowLength -= stack.peek().path.length();
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    TreeNode top = stack.peek();
                    //top.elements.add(temp);
                }
                if (temp.isDirectionary) {
                    stack.add(temp);
                } else {
                    if (nowLength + temp.rank > ans) {
                        ans = nowLength + temp.rank;
                    }
                    nowLength -= temp.path.length();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext\n\tsubdir3\n\t\tfile3.ext";
        //String input = "a";
        //String input = "file1.txt\nfile2.txt\nlongfile.txt";
        //String input = "dir\n        file.txt";
        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath(input));
    }
}

class TreeNode {
    boolean isDirectionary;
    //Set<TreeNode> elements;
    String path;
    int rank;

    TreeNode() {
        //elements = new HashSet<>();
    }
}