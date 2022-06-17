import java.util.Arrays;

public class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int index = 0;
        int i = -1;
        while (index < n) {
            i++;
            if (arr[i] == 0) {
                index += 2;
            } else {
                index++;
            }
        }
        int right = n - 1;
        if (arr[i] == 0 && index == n) {
            arr[right--] = 0;
            arr[right--] = 0;
            i--;
        } else {
            arr[right--] = arr[i--];
        }
        while (i >= 0) {
            if (arr[i] == 0) {
                arr[right--] = 0;
                arr[right--] = 0;
            } else {
                arr[right--] = arr[i];
            }
            i--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 0, 1, 0, 1};
        solution.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
