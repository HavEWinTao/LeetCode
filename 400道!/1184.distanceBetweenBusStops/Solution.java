public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int lenght1 = 0, length2 = 0;
        int i = start;
        while (i != destination) {
            lenght1 += distance[i++];
            if (i == n) {
                i = 0;
            }
        }
        int j = destination;
        while (j != start) {
            length2 += distance[j++];
            if (j == n) {
                j = 0;
            }
        }
        return Math.min(lenght1, length2);
    }
}
