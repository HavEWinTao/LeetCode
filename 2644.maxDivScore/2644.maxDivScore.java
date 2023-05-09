public class maxDivScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        int index = 0;
        int cnt = 0;
        for (int i = 0; i < divisors.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) temp++;
            }
            if (temp == cnt) {
                if (divisors[index] > divisors[i]) index = i;
            } else if (temp > cnt) {
                cnt = temp;
                index = i;
            }
        }
        return divisors[index];
    }

    public static void main(String[] args) {
        maxDivScore solution = new maxDivScore();
        int[] nums = new int[]{73, 13, 20, 6};
        int[] divisors = new int[]{56, 75, 83, 26, 24, 53, 56, 61};
        System.out.println(solution.maxDivScore(nums, divisors));
    }
}
