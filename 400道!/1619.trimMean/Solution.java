public class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        int cnt = n / 20;
        PriorityQueue<Integer> samll = new PriorityQueue<>((num1, num2) -> {
            return Integer.compare(num2, num1);
        });
        PriorityQueue<Integer> big = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            sum += num;
            if (samll.size() < cnt) {
                samll.add(num);
            } else {
                if (num < samll.peek()) {
                    samll.poll();
                    samll.offer(num);
                }
            }
            if (big.size() < cnt) {
                big.add(num);
            } else {
                if (num > big.peek()) {
                    big.poll();
                    big.offer(num);
                }
            }
        }
        int sub = 0;
        while (!samll.isEmpty()) {
            sub += samll.poll();
        }
        while (!big.isEmpty()) {
            sub += big.poll();
        }
        return (double) (sum - sub) / (n - 2 * cnt);
    }
}