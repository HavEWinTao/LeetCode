class Solution {
    public int maximumSwap(int num) {
        int[] arr = new int[32];
        int cnt = 0;
        int numCopy = num;
        while (num != 0) {
            int temp = num % 10;
            arr[cnt++] = temp;
            num /= 10;
        }
        for (int i = cnt - 1; i >= 0; i--) {
            int temp1 = arr[i];
            int index = -1;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > temp1) {
                    //System.out.println("" + arr[j] + " " + j + " " + i);
                    temp1 = arr[j];
                    index = j;
                }
            }
            if (index != -1) {
                int temp2 = arr[i];
                arr[i] = arr[index];
                arr[index] = temp2;
                int ans = 0;
                for (int k = cnt - 1; k >= 0; k--) {
                    ans = ans * 10 + arr[k];
                }
                return ans;
            }
        }
        //System.out.println(num);
        return numCopy;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 98368;
        System.out.println(solution.maximumSwap(num));
    }
}