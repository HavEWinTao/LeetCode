public class rowAndMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = 0;
        int num = 0;
        for (int i = 0; i < mat.length; i++) {
            int temp = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) temp++;
            }
            if (temp > num) {
                num = temp;
                index = i;
            }
        }
        return new int[]{index, num};
    }
}