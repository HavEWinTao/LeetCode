import java.util.Map;
import java.util.TreeMap;

public class Trie {

    private TreeNode root;

    public Trie() {
        root = new TreeNode();
        root.isWord = false;
        root.val = '#';
        root.childrens = new TreeMap<>();
    }

    public void insert(String word) {
        TreeNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.childrens.containsKey(word.charAt(i))) {
                TreeNode t = new TreeNode();
                t.isWord = false;
                t.val = word.charAt(i);
                t.childrens = new TreeMap<>();
                temp.childrens.put(word.charAt(i), t);
            }
            temp = temp.childrens.get(word.charAt(i));
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        TreeNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.childrens.containsKey(word.charAt(i))) {
                return false;
            }
            temp = temp.childrens.get(word.charAt(i));
        }
        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!temp.childrens.containsKey(prefix.charAt(i))) {
                return false;
            }
            temp = temp.childrens.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("zhan");
        obj.insert("zhang");
        System.out.println(obj.search("zhan"));
        System.out.println(obj.startsWith("zh"));
    }
}

class TreeNode {
    public boolean isWord;
    public char val;
    public Map<Character, TreeNode> childrens;
}