import java.util.Arrays;
import java.util.Random;

public class Ga {
    int[][] mat_;
    private int target;
    private int[][] chromosomes;
    private int m, n;
    private int popSize;
    private Random r;

    public int minimizeTheDifference(int[][] mat, int target) {
        if (mat.length == 1) {
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < mat[0].length; i++) {
                ans = Math.min(ans, Math.abs(mat[0][i] - target));
            }
            return ans;
        }
        if (mat[0].length == 1) {
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum += mat[i][0];
            }
            return Math.abs(sum - target);
        }
        r = new Random();
        r.setSeed(0);
        mat_ = mat;
        this.target = target;
        m = mat.length;
        n = mat[0].length;
        popSize = 500;
        chromosomes = new int[popSize][m];
        init();
        for (int i = 0; i < 2000; i++) {
            evolve();
        }
        Arrays.sort(chromosomes, (int[] o1, int[] o2) -> fitness(o1) - fitness(o2));
        return fitness(chromosomes[0]);
    }

    private void evolve() {
        int[][] child = new int[popSize][m];
        Arrays.sort(chromosomes, (int[] o1, int[] o2) -> {
            return fitness(o1) - fitness(o2);
        });
        //选择
        for (int i = 0; i < 0.4 * popSize; i++) {
            for (int j = 0; j < m; j++) {
                child[i][j] = chromosomes[i][j];
            }
        }
        //交叉
        for (int i = (int) (0.4 * popSize); i < popSize; i++) {
            int index1 = r.nextInt(popSize);
            int index2 = r.nextInt(popSize);
            int split = r.nextInt(m);
            for (int j = 0; j < split; j++) {
                child[i][j] = chromosomes[index1][j];
            }
            for (int j = split; j < m; j++) {
                child[i][j] = chromosomes[index2][j];
            }
        }
        //变异
        for (int i = 0; i < popSize; i++) {
            if (r.nextDouble() < 0.3) {
                for (int j = 0; j < m; j++) {
                    child[i][j] = r.nextInt(n);
                }
            }
        }
        chromosomes = child;
    }

    private void init() {
        for (int i = 0; i < popSize; i++) {
            for (int j = 0; j < m; j++) {
                chromosomes[i][j] = r.nextInt(n);
            }
        }
    }

    private int fitness(int[] chromosome) {
        int fit = 0;
        for (int i = 0; i < chromosome.length; i++) {
            fit += mat_[i][chromosome[i]];
        }
        return Math.abs(fit - target);
    }

    public static void main(String[] args) {
        Ga ga = new Ga();
        int[][] mat = new int[][]{
                {70, 9, 70, 1, 1, 1, 1, 1, 70, 70, 1, 70, 70, 70, 70, 70, 70, 1, 70, 1, 70, 1, 70, 70, 70, 70, 70, 1, 1, 70, 70},
                {1, 1, 70, 9, 70, 70, 70, 70, 1, 1, 1, 70, 1, 1, 1, 1, 1, 70, 70, 70, 1, 70, 70, 1, 1, 1, 1, 1, 1, 1, 1},
                {70, 1, 1, 1, 70, 70, 70, 70, 1, 1, 1, 1, 70, 1, 70, 1, 70, 1, 1, 70, 1, 1, 1, 70, 1, 70, 70, 9, 1, 70, 70},
                {1, 1, 1, 1, 70, 70, 1, 70, 70, 1, 70, 1, 70, 1, 70, 70, 70, 70, 70, 70, 70, 1, 70, 70, 1, 9, 1, 70, 70, 1, 70},
                {70, 70, 1, 1, 1, 70, 1, 70, 1, 1, 1, 1, 1, 1, 70, 70, 70, 1, 1, 1, 1, 1, 1, 70, 70, 70, 1, 70, 70, 70, 9},
                {1, 1, 1, 1, 70, 1, 1, 1, 1, 1, 70, 1, 1, 70, 1, 70, 1, 9, 1, 70, 1, 70, 70, 1, 70, 1, 70, 70, 1, 1, 70},
                {70, 1, 9, 1, 70, 1, 70, 1, 1, 70, 70, 70, 70, 70, 70, 70, 1, 1, 1, 70, 1, 70, 1, 1, 1, 1, 70, 1, 70, 1, 70},
                {1, 70, 1, 1, 1, 70, 1, 1, 70, 1, 1, 1, 1, 70, 70, 70, 1, 70, 70, 9, 1, 1, 1, 70, 70, 1, 70, 70, 1, 70, 70},
                {70, 1, 1, 70, 1, 70, 1, 1, 1, 1, 1, 1, 70, 70, 70, 70, 1, 9, 1, 70, 1, 70, 1, 1, 70, 70, 70, 1, 70, 70, 70},
                {70, 1, 1, 1, 70, 1, 1, 1, 1, 1, 70, 70, 1, 9, 1, 1, 1, 1, 1, 1, 1, 70, 70, 70, 70, 1, 70, 1, 70, 1, 70},
                {1, 1, 70, 1, 1, 70, 9, 1, 70, 70, 70, 70, 1, 1, 70, 1, 70, 1, 1, 1, 70, 1, 1, 70, 1, 70, 1, 70, 70, 70, 70},
                {70, 70, 70, 70, 70, 70, 70, 1, 70, 70, 70, 70, 1, 9, 1, 1, 1, 70, 70, 70, 70, 70, 1, 70, 1, 1, 1, 1, 70, 1, 70},
                {1, 70, 70, 70, 70, 70, 70, 70, 1, 70, 1, 70, 1, 1, 9, 1, 70, 70, 1, 70, 1, 70, 70, 1, 1, 1, 70, 70, 70, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 70, 1, 1, 1, 70, 1, 1, 1, 70, 1, 9, 1, 1, 1, 1, 70, 1, 70, 70, 1, 1, 70, 70, 1},
                {70, 70, 70, 1, 1, 1, 70, 70, 70, 1, 1, 1, 1, 70, 1, 70, 70, 1, 70, 70, 1, 70, 9, 70, 1, 70, 1, 70, 1, 70, 1},
                {70, 1, 70, 70, 1, 70, 1, 9, 1, 70, 1, 70, 1, 1, 1, 1, 1, 70, 1, 70, 1, 1, 70, 1, 70, 70, 70, 70, 70, 1, 1},
                {70, 70, 70, 1, 1, 1, 1, 1, 1, 70, 70, 70, 70, 70, 1, 1, 70, 1, 1, 70, 70, 1, 70, 9, 1, 1, 1, 70, 70, 1, 1},
                {70, 70, 70, 1, 70, 1, 70, 70, 1, 70, 70, 70, 70, 9, 1, 1, 1, 1, 1, 70, 70, 70, 70, 1, 70, 1, 70, 70, 1, 70, 1},
                {1, 70, 70, 70, 1, 70, 70, 1, 70, 1, 1, 1, 1, 70, 1, 70, 70, 70, 70, 1, 70, 9, 1, 70, 1, 1, 70, 1, 70, 70, 1},
                {70, 1, 70, 1, 1, 70, 70, 70, 1, 70, 1, 1, 1, 1, 70, 70, 1, 70, 1, 70, 1, 1, 1, 70, 1, 9, 70, 1, 1, 1, 1},
                {70, 1, 70, 70, 70, 70, 70, 70, 70, 1, 1, 70, 70, 70, 70, 1, 1, 70, 1, 9, 1, 70, 1, 70, 1, 1, 1, 70, 70, 70, 70},
                {70, 1, 1, 70, 70, 70, 70, 1, 70, 1, 1, 1, 70, 1, 70, 70, 70, 70, 70, 1, 1, 70, 9, 70, 1, 1, 70, 70, 1, 1, 1},
                {70, 1, 1, 1, 70, 70, 70, 70, 1, 1, 1, 1, 1, 70, 1, 1, 70, 70, 70, 70, 70, 1, 9, 1, 70, 1, 1, 1, 1, 1, 70},
                {70, 1, 70, 70, 70, 70, 70, 1, 1, 1, 70, 1, 1, 1, 70, 70, 1, 1, 1, 1, 1, 1, 1, 70, 1, 70, 1, 70, 70, 70, 9},
                {70, 1, 1, 9, 1, 1, 70, 1, 70, 70, 1, 1, 70, 70, 1, 1, 1, 70, 1, 1, 1, 70, 1, 70, 70, 1, 70, 70, 70, 70, 70},
                {70, 1, 1, 1, 70, 1, 1, 70, 70, 1, 1, 1, 1, 70, 1, 70, 70, 70, 70, 70, 1, 1, 70, 1, 1, 70, 9, 1, 70, 70, 70},
                {70, 70, 1, 70, 1, 1, 70, 1, 1, 1, 70, 70, 70, 1, 70, 1, 1, 70, 1, 1, 70, 9, 1, 1, 70, 70, 1, 1, 70, 70, 70},
                {1, 1, 1, 70, 1, 70, 1, 1, 70, 70, 9, 1, 70, 1, 70, 1, 1, 70, 1, 70, 70, 70, 1, 1, 1, 1, 70, 1, 1, 1, 70},
                {70, 70, 70, 70, 1, 1, 1, 1, 70, 1, 70, 1, 1, 1, 70, 1, 70, 9, 70, 70, 70, 70, 1, 70, 70, 70, 1, 70, 1, 1, 1},
                {70, 70, 70, 9, 1, 70, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 70, 70, 70, 1, 70, 70, 70, 1, 1, 70, 1, 1, 1, 70},
                {1, 70, 70, 1, 1, 70, 70, 1, 70, 70, 1, 70, 1, 70, 70, 70, 70, 9, 70, 70, 70, 70, 70, 1, 70, 1, 1, 70, 1, 70, 70}};
        // {{18, 36, 45, 13, 30, 17, 39, 24, 15, 49, 45, 28, 21, 24, 44, 45, 7, 39, 13, 43, 2, 32, 15, 47, 15, 18, 26}, {1, 27, 29, 4, 27, 16, 37, 31, 41, 22, 39, 4, 35, 43, 33, 13, 8, 3, 4, 31, 14, 7, 21, 41, 49, 23, 11}, {28, 20, 15, 4, 13, 30, 1, 38, 41, 30, 3, 29, 45, 46, 42, 35, 27, 24, 29, 17, 45, 6, 37, 19, 5, 14, 23}, {16, 21, 8, 2, 13, 34, 27, 15, 7, 44, 47, 32, 19, 2, 50, 47, 36, 46, 48, 37, 23, 22, 44, 12, 3, 11, 36}, {47, 41, 23, 11, 6, 47, 2, 12, 49, 31, 22, 19, 45, 5, 19, 8, 20, 5, 2, 47, 48, 26, 14, 37, 30, 12, 10}, {16, 29, 47, 34, 8, 24, 6, 46, 7, 13, 37, 19, 30, 34, 20, 47, 6, 45, 32, 39, 41, 33, 42, 31, 49, 41, 28}, {10, 49, 19, 4, 2, 11, 35, 39, 2, 13, 26, 30, 23, 9, 25, 35, 19, 49, 8, 9, 21, 22, 3, 3, 11, 20, 50}, {20, 47, 16, 43, 14, 28, 4, 20, 49, 25, 46, 5, 9, 16, 18, 46, 18, 28, 45, 10, 2, 43, 24, 8, 2, 37, 17}, {13, 48, 26, 44, 43, 39, 43, 32, 14, 41, 47, 18, 46, 49, 16, 26, 21, 4, 38, 29, 32, 45, 35, 29, 21, 43, 31}, {46, 48, 26, 19, 8, 25, 2, 6, 3, 3, 6, 45, 24, 24, 1, 37, 31, 2, 5, 20, 32, 7, 26, 49, 49, 32, 2}, {45, 3, 5, 24, 2, 16, 43, 11, 24, 6, 11, 8, 21, 36, 22, 5, 25, 43, 10, 20, 9, 24, 45, 4, 36, 43, 48}, {24, 38, 44, 35, 29, 4, 48, 3, 48, 10, 38, 21, 9, 43, 42, 10, 35, 50, 46, 4, 22, 43, 34, 48, 27, 43, 17}, {13, 41, 33, 44, 31, 16, 19, 49, 5, 43, 31, 29, 45, 17, 43, 26, 9, 36, 29, 12, 32, 18, 24, 44, 14, 45, 22}, {23, 32, 45, 47, 28, 41, 12, 15, 42, 4, 19, 14, 8, 44, 27, 30, 29, 2, 11, 47, 6, 6, 1, 31, 20, 12, 23}, {14, 34, 20, 19, 18, 19, 21, 47, 8, 1, 29, 36, 21, 32, 25, 42, 8, 19, 32, 13, 44, 8, 1, 28, 15, 19, 31}, {43, 5, 27, 3, 8, 34, 46, 6, 48, 22, 24, 11, 47, 39, 23, 17, 23, 20, 13, 9, 1, 15, 3, 50, 8, 35, 27}, {32, 45, 24, 39, 18, 15, 29, 37, 8, 50, 6, 46, 44, 3, 19, 46, 12, 46, 30, 4, 26, 45, 32, 8, 24, 21, 1}};
        //{{1}, {2}, {3}};
        //{{1, 2, 9, 8, 7}};
        //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(ga.minimizeTheDifference(mat, 281));
    }
}
