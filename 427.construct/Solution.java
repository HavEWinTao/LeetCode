public class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return DFS(0, 0, n - 1, n - 1, grid);
    }

    private Node DFS(int a, int b, int c, int d, int[][] grid) {
        boolean flag = true;
        int temp = grid[a][b];
        for (int i = a; i <= c; i++) {
            for (int j = b; j <= d; j++) {
                if (grid[i][j] != temp) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        if (flag) {
            return new Node(temp == 1, true);
        }
        Node root = new Node(temp == 1, false);
        int midX = (c + a + 1) / 2, midY = (d + b + 1) / 2;
        root.topLeft = DFS(a, b, midX - 1, midY - 1, grid);
        root.topRight = DFS(a, midY, midX - 1, d, grid);
        root.bottomLeft = DFS(midX, b, c, midY - 1, grid);
        root.bottomRight = DFS(midX, midY, c, d, grid);
        return root;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}