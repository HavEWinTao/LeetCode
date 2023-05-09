public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int n = boxTypes.length;
        int ans = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize > boxType[0]) {
                ans += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                ans += truckSize * boxType[1];
                break;
            }
        }
        return ans;
    }
}