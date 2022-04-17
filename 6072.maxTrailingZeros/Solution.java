import java.util.Arrays;

public class Solution {
    //直接求乘法会溢出，所以求因子
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int facter[][][] = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (grid[i][j] % 5 == 0) {
                    grid[i][j] /= 5;
                    facter[i][j][1]++;
                }
                while (grid[i][j] % 2 == 0) {
                    grid[i][j] /= 2;
                    facter[i][j][0]++;
                }
            }
        }

        int[][][] left2right = new int[m][n][2];
        int[][][] right2left = new int[m][n][2];
        int[][][] up2down = new int[m][n][2];
        int[][][] down2up = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            left2right[i][0][0] = 0;
            left2right[i][0][1] = 0;
            for (int j = 1; j < n; j++) {
                left2right[i][j][0] = left2right[i][j - 1][0] + facter[i][j - 1][0];
                left2right[i][j][1] = left2right[i][j - 1][1] + facter[i][j - 1][1];
            }
        }
        for (int i = 0; i < m; i++) {
            right2left[i][n - 1][0] = 0;
            right2left[i][n - 1][1] = 0;
            for (int j = n - 2; j >= 0; j--) {
                right2left[i][j][0] = right2left[i][j + 1][0] + facter[i][j + 1][0];
                right2left[i][j][1] = right2left[i][j + 1][1] + facter[i][j + 1][1];
            }
        }
        for (int j = 0; j < n; j++) {
            up2down[0][j][0] = 0;
            up2down[0][j][1] = 0;
            for (int i = 1; i < m; i++) {
                up2down[i][j][0] = up2down[i - 1][j][0] + facter[i - 1][j][0];
                up2down[i][j][1] = up2down[i - 1][j][1] + facter[i - 1][j][1];
            }
        }
        for (int j = 0; j < n; j++) {
            down2up[m - 1][j][0] = 0;
            down2up[m - 1][j][1] = 0;
            for (int i = m - 2; i >= 0; i--) {
                down2up[i][j][0] = down2up[i + 1][j][0] + facter[i + 1][j][0];
                down2up[i][j][1] = down2up[i + 1][j][1] + facter[i + 1][j][1];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] nums = new int[6];
                nums[0] = Math.min(up2down[i][j][1] + left2right[i][j][1] + facter[i][j][1],
                        up2down[i][j][0] + left2right[i][j][0] + facter[i][j][0]);
                nums[1] = Math.min(up2down[i][j][1] + right2left[i][j][1] + facter[i][j][1],
                        up2down[i][j][0] + right2left[i][j][0] + facter[i][j][0]);
                nums[2] = Math.min(down2up[i][j][1] + left2right[i][j][1] + facter[i][j][1],
                        down2up[i][j][0] + left2right[i][j][0] + facter[i][j][0]);
                nums[3] = Math.min(down2up[i][j][1] + right2left[i][j][1] + facter[i][j][1],
                        down2up[i][j][0] + right2left[i][j][0] + facter[i][j][0]);
                nums[4] = Math.min(down2up[i][j][1] + up2down[i][j][1] + facter[i][j][1],
                        down2up[i][j][0] + up2down[i][j][0] + facter[i][j][0]);
                nums[5] = Math.min(left2right[i][j][1] + right2left[i][j][1] + facter[i][j][1],
                        left2right[i][j][0] + right2left[i][j][0] + facter[i][j][0]);
                for (int num : nums) {
                    if (num > ans) {
                        ans = num;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
        int[][] grid = new int[][]{
                {23, 17, 15, 3, 20}, {8, 1, 20, 27, 11},
                {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6},
                {22, 7, 4, 5, 3}
        };
        */
        /*
        int[][] grid = new int[][]{
                {824, 709, 193, 413, 701, 836, 727},
                {135, 844, 599, 211, 140, 933, 205},
                {329, 68, 285, 282, 301, 387, 231},
                {293, 210, 478, 352, 946, 902, 137},
                {806, 900, 290, 636, 589, 522, 611},
                {450, 568, 990, 592, 992, 128, 92},
                {780, 653, 795, 457, 980, 942, 927},
                {849, 901, 604, 906, 912, 866, 688}
        };
        */
        /*
        int[][] grid = new int[][]{
                {105, 507, 750, 15, 431, 430, 926, 722, 231, 746},
                {396, 894, 565, 46, 770, 505, 330, 984, 262, 766},
                {114, 691, 633, 603, 671, 163, 956, 464, 19, 128},
                {5, 266, 119, 818, 572, 647, 236, 991, 137, 420},
                {216, 946, 258, 254, 666, 435, 755, 793, 843, 517},
                {311, 880, 961, 561, 582, 1, 174, 458, 939, 444},
                {335, 448, 906, 379, 632, 580, 587, 992, 614, 756},
                {997, 634, 502, 458, 33, 798, 478, 732, 17, 986},
                {49, 362, 390, 252, 642, 107, 978, 920, 54, 710},
                {1, 747, 854, 133, 358, 308, 869, 868, 518, 173},
                {670, 624, 327, 827, 611, 439, 347, 161, 257, 407},
                {820, 735, 572, 662, 499, 814, 318, 203, 995, 242},
                {416, 621, 387, 130, 968, 918, 951, 38, 229, 984},
                {77, 956, 770, 767, 348, 708, 147, 538, 180, 706},
                {924, 126, 266, 602, 65, 99, 772, 31, 964, 84},
                {594, 98, 943, 825, 386, 282, 522, 364, 785, 662},
                {836, 64, 354, 407, 696, 357, 990, 844, 112, 306},
                {709, 2, 776, 215, 912, 71, 41, 382, 658, 615},
                {504, 374, 202, 675, 880, 884, 644, 928, 610, 859},
                {916, 604, 672, 426, 279, 403, 205, 208, 789, 414},
                {386, 204, 820, 349, 545, 842, 427, 74, 776, 329},
                {504, 770, 188, 233, 806, 554, 709, 857, 977, 285},
                {181, 291, 121, 96, 63, 929, 591, 958, 516, 406},
                {651, 963, 946, 724, 176, 911, 312, 881, 40, 985},
                {575, 971, 143, 955, 712, 559, 823, 162, 614, 152},
                {153, 527, 10, 686, 704, 897, 251, 890, 616, 528},
                {821, 996, 30, 443, 986, 290, 32, 486, 572, 900},
                {901, 896, 584, 856, 295, 321, 467, 5, 93, 163},
                {975, 762, 432, 620, 521, 733, 390, 190, 631, 828},
                {594, 477, 328, 376, 677, 668, 463, 532, 283, 868},
                {503, 895, 100, 470, 146, 442, 256, 549, 509, 353},
                {865, 580, 264, 591, 914, 200, 715, 888, 452, 531},
                {32, 438, 848, 735, 266, 564, 627, 488, 419, 859},
                {733, 457, 203, 918, 633, 362, 578, 47, 330, 339},
                {77, 567, 350, 296, 434, 649, 504, 3, 900, 429},
                {212, 268, 224, 903, 596, 393, 724, 834, 3, 348},
                {933, 134, 178, 173, 511, 559, 509, 9, 116, 252},
                {256, 217, 241, 668, 468, 925, 320, 823, 152, 823},
                {2, 777, 368, 76, 527, 98, 5, 191, 999, 417},
                {289, 460, 909, 458, 535, 592, 241, 895, 512, 822},
                {385, 32, 142, 916, 15, 171, 355, 101, 592, 528},
                {242, 38, 412, 482, 808, 88, 189, 229, 443, 127},
                {228, 683, 544, 185, 825, 146, 611, 829, 681, 232},
                {788, 844, 110, 557, 801, 272, 127, 413, 510, 472},
                {349, 149, 469, 517, 847, 964, 541, 177, 555, 983},
                {915, 284, 905, 495, 545, 26, 752, 220, 746, 977},
                {281, 464, 466, 642, 375, 764, 253, 35, 990, 701},
                {993, 65, 91, 971, 973, 921, 283, 578, 605, 773},
                {793, 40, 16, 243, 976, 517, 489, 870, 860, 866},
                {900, 114, 170, 768, 81, 356, 955, 996, 945, 331},
                {903, 630, 955, 65, 937, 708, 153, 9, 721, 827},
                {820, 143, 108, 299, 293, 110, 873, 719, 465, 689},
                {459, 703, 166, 75, 410, 927, 511, 545, 806, 434},
                {986, 626, 718, 704, 647, 655, 725, 795, 901, 848}};
        */
        int[][] grid = new int[][]{
                {899, 727, 165, 249, 531, 300, 542, 890},
                {981, 587, 565, 943, 875, 498, 582, 672},
                {106, 902, 524, 725, 699, 778, 365, 220}
        };
        System.out.println(solution.maxTrailingZeros(grid));
    }
}
