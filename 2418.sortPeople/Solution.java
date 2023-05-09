class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[][] map = new String[n][2];
        for (int i = 0; i < n; i++) {
            map[i][0] = names[i];
            map[i][1] = String.valueOf(heights[i]);
        }
        Arrays.sort(map, (o1, o2) -> {
            int h1 = Integer.parseInt(o1[1]);
            int h2 = Integer.parseInt(o2[1]);
            return Integer.compare(h2, h1);
        });
        return Arrays.stream(map).map(o1 -> o1[1]).collect(Collectors.toList()).toArray(new String[n]);
    }
}