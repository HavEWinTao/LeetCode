public class Solution {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] scores = new int[n];
        TreeNode root = new TreeNode();
        for (String word : words) {
            TreeNode temp = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                int cnt = temp.childCnt.getOrDefault(c, 0);
                temp.childCnt.put(c, cnt + 1);
                if (cnt == 0) {
                    temp.children.put(c, new TreeNode());
                }
                temp = temp.children.get(c);
            }
        }
        for (int i = 0; i < n; i++) {
            TreeNode tempNode = root;
            int temp = 0;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                int cnt = tempNode.childCnt.get(c);
                temp += cnt;
                tempNode = tempNode.children.get(c);
            }
            scores[i] = temp;
        }
        return scores;
    }

    public static void main(String[] args) {
        Main main = new Main();
        String[] words = new String[]{"abc", "ab", "bc", "b"};
        System.out.println(Arrays.toString(main.sumPrefixScores(words)));
    }
}

class TreeNode {
    Character val;
    Map<Character, Integer> childCnt;
    Map<Character, TreeNode> children;

    TreeNode() {
        val = '#';
        childCnt = new HashMap<>();
        children = new HashMap<>();
    }

    TreeNode(Character val) {
        this.val = val;
        childCnt = new HashMap<>();
        children = new HashMap<>();
    }
}