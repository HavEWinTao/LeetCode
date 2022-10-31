class Solution {
    public boolean checkDistances(String s, int[] distance) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.get(c - 'a').add(i);
        }
        for (int i = 0; i < 26; i++) {
            int dis = 0;
            if (!list.get(i).isEmpty()) {
                List<Integer> temp = list.get(i);
                dis = temp.get(1) - temp.get(0) - 1;
                if (dis != distance[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}