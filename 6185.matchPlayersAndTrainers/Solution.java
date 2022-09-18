class Solution {
    private List<Integer> list;

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        list = Arrays.stream(trainers).boxed().collect(Collectors.toList());
        for (int player : players) {
            int index = binarySearch(player);
            if (index != -1) {
                list.remove(index);
                ans++;
            }
        }
        return ans;
    }

    private int binarySearch(int key) {
        if (list.size() == 0) {
            return -1;
        }
        int left = 0, right = list.size() - 1;
        if (key > list.get(right)) {
            return -1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (key <= list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}