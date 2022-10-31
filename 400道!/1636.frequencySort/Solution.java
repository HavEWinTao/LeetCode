public class Solution {
    public int[] frequencySort(int[] nums) {
        int[] num2cnt = new int[210];
        for (int num : nums) {
            num2cnt[num + 100]++;
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort((o1, o2) -> {
            int cnt1 = num2cnt[o1 - 100];
            int cnt2 = num2cnt[o2 - 100];
            return cnt1 != cnt2 ? cnt1 - cnt2 : o2 - o1;
        });
        return list.stream().mapToInt(Integer::new).toArray();
    }
}