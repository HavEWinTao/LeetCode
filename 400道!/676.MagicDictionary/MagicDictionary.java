import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MagicDictionary {

    private Map<Integer, Set<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            int length = word.length();
            Set<String> temp = map.getOrDefault(length, new HashSet<>());
            temp.add(word);
            map.put(length,temp);
        }
    }

    public boolean search(String searchWord) {
        int length = searchWord.length();
        Set<String> set = map.get(length);
        if (set == null) {
            return false;
        }
        for (String str : set) {
            int flag = 0;
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) != searchWord.charAt(i)) {
                    flag++;
                    if (flag == 2) {
                        break;
                    }
                }
            }
            if (flag == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary md = new MagicDictionary();
        String[] dict = new String[]{"hello", "leet", "code"};
        md.buildDict(dict);
    }
}
