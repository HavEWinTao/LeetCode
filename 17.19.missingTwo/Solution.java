 class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int index = 0;
        List<Integer> ans = new ArrayList<>();
        boolean[] show = new boolean[2];
        while (index < n) {
            int num = nums[index];
            if (num - 1 < n) {
                if (num - 1 == index) {
                    index++;
                    continue;
                }
                int temp = nums[num - 1];
                nums[num - 1] = num;
                nums[index] = temp;
            } else {
                show[num - 1 - n] = true;
                index++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                ans.add(i + 1);
            }
        }
        if (!show[0]) {
            ans.add(n + 1);
        }
        if (!show[1]) {
            ans.add(n + 2);
        }
        return ans.stream().mapToInt(Integer::new).toArray();
    }
}