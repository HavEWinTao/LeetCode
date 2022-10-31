public class LUPPrefix {
    private int longestValue;
    private Set<Integer> set;

    public LUPPrefix(int n) {
        longestValue = 0;
        set = new HashSet<>();
    }

    public void upload(int video) {
        if (longestValue == video - 1) {
            set.add(video);
            while (set.contains(video)) {
                longestValue = video;
                video++;
            }
        } else {
            set.add(video);
        }

    }

    public int longest() {
        return longestValue;
    }
}