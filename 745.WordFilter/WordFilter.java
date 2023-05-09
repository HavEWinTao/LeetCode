import java.util.*;

public class WordFilter {
    Trie forward;

    Trie backward;

    public WordFilter(String[] words) {
        forward = new Trie();
        backward = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();
            Trie temp = forward;
            for (int j = 0; j < length; j++) {
                char c = word.charAt(j);
                if (!temp.children.containsKey(c)) {
                    Trie node = new Trie();
                    temp.children.put(c, node);
                }
                temp = temp.children.get(c);
                temp.index.add(i);
            }
            temp = backward;
            for (int j = length - 1; j >= 0; j--) {
                char c = word.charAt(j);
                if (!temp.children.containsKey(c)) {
                    Trie node = new Trie();
                    temp.children.put(c, node);
                }
                temp = temp.children.get(c);
                temp.index.add(i);
            }
        }
    }

    public int f(String pref, String suff) {
        Trie f = forward;
        for (int i = 0; i < pref.length(); i++) {
            char c = pref.charAt(i);
            if (f.children.containsKey(c)) {
                f = f.children.get(c);
            } else {
                return -1;
            }
        }
        Trie b = backward;
        for (int i = suff.length() - 1; i >= 0; i--) {
            char c = suff.charAt(i);
            if (b.children.containsKey(c)) {
                b = b.children.get(c);
            } else {
                return -1;
            }
        }
        List<Integer> list1 = f.index;
        List<Integer> list2 = b.index;
        int i = list1.size() - 1, j = list2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (list1.get(i) > list2.get(j)) {
                i--;
            } else if (list1.get(i) < list2.get(j)) {
                j--;
            } else {
                return list1.get(i);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"apple","apple"};
        WordFilter wordFilter = new WordFilter(words);
        System.out.println(wordFilter.f("app", "e"));
    }
}

class Trie {
    Map<Character, Trie> children;

    List<Integer> index;

    public Trie() {
        children = new HashMap<>();
        index = new ArrayList<>();
    }
}
