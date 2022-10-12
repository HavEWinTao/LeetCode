public class Solution {

    private List<String> ans;

    public List<String> subdomainVisits(String[] cpdomains) {
        TreeNode root = new TreeNode();
        for (String cpdomain : cpdomains) {
            String[] temp = cpdomain.split(" ");
            int num = Integer.parseInt(temp[0]);
            String[] strs = temp[1].split("\\.");
            TreeNode tNode = root;
            for (int i = strs.length - 1; i >= 0; i--) {
                String str = strs[i];
                Map<String, TreeNode> map = tNode.children;
                TreeNode child = map.getOrDefault(str, new TreeNode());
                child.num += num;
                map.put(str, child);
                tNode = child;
            }
        }
        ans = new ArrayList<>();
        DFS(root, "");
        return ans;
    }

    private void DFS(TreeNode root, String str) {
        Map<String, TreeNode> map = root.children;
        if (map.size() == 0) {
            return;
        }
        for (Map.Entry<String, TreeNode> entry : map.entrySet()) {
            String domain = entry.getKey();
            int num = entry.getValue().num;
            String s = domain + str;
            ans.add(num + " " + s);
            DFS(entry.getValue(), "." + s);
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(solution.subdomainVisits(cpdomains));
    }
}

class TreeNode {
    int num;
    Map<String, TreeNode> children;

    TreeNode() {
        num = 0;
        children = new HashMap<>();
    }
}