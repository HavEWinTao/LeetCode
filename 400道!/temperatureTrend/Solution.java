class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int ans = 0;
        int temp = 0;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (temperatureA[i] > temperatureA[i - 1] && temperatureB[i] > temperatureB[i - 1]) {
                if (!flag) {
                    flag = true;
                }
                temp++;
            } else if (temperatureA[i] == temperatureA[i - 1] && temperatureB[i] == temperatureB[i - 1]) {
                if (!flag) {
                    flag = true;
                }
                temp++;
            } else if (temperatureA[i] < temperatureA[i - 1] && temperatureB[i] < temperatureB[i - 1]) {
                if (!flag) {
                    flag = true;
                }
                temp++;
            } else {
                flag = false;
                temp = 0;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        int[] temperatureA = new int[]{21, 18, 18, 18, 31};
        int[] temperatureB = new int[]{34, 32, 16, 16, 17};
        System.out.println(solution.temperatureTrend(temperatureA, temperatureB));
    }
}