public class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[][] date = new int[4][2];
        String[] arriveA = arriveAlice.split("-");
        String[] leaveA = leaveAlice.split("-");
        String[] arriveB = arriveBob.split("-");
        String[] leaveB = leaveBob.split("-");
        date[0][0] = Integer.parseInt(arriveA[0]);
        date[0][1] = Integer.parseInt(arriveA[1]);
        date[1][0] = Integer.parseInt(leaveA[0]);
        date[1][1] = Integer.parseInt(leaveA[1]);
        date[2][0] = Integer.parseInt(arriveB[0]);
        date[2][1] = Integer.parseInt(arriveB[1]);
        date[3][0] = Integer.parseInt(leaveB[0]);
        date[3][1] = Integer.parseInt(leaveB[1]);
        int[] arrive = new int[2];
        if (date[0][0] < date[2][0]) {
            arrive = date[2];
        } else if (date[0][0] > date[2][0]) {
            arrive = date[0];
        } else {
            arrive[0] = date[0][0];
            arrive[1] = Math.max(date[0][1], date[2][1]);
        }
        int[] leave = new int[2];
        if (date[1][0] < date[3][0]) {
            leave = date[1];
        } else if (date[1][0] > date[3][0]) {
            leave = date[3];
        } else {
            leave[0] = date[1][0];
            leave[1] = Math.min(date[1][1], date[3][1]);
        }
        int ans = 0;
        for (int i = arrive[0]; i <= leave[0]; i++) {
            if (arrive[0] == leave[0]) {
                ans += (leave[1] - arrive[1]) + 1;
                return Math.max(ans, 0);
            }
            if (i == arrive[0]) {
                ans += (days[i - 1] - arrive[1]) + 1;
            } else if (i == leave[0]) {
                ans += leave[1];
            } else {
                ans += days[i - 1];
            }
        }
        return Math.max(ans, 0);
    }
}