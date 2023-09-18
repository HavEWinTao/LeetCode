func exist(board [][]byte, word string) bool {
	var dfs func(board [][]byte, word string, x, y, idx int, vis [][]bool) bool
	dfs = func(board [][]byte, word string, x, y, idx int, vis [][]bool) bool {
		if idx == len(word) {
			return true
		}
		if board[x][y] != word[idx] {
			return false
		}
		vis[x][y] = true
		for i := 0; i < 4; i++ {
			x1 := x + direction[i][0]
			y1 := y + direction[i][1]
			if x1 < 0 || x1 >= len(board) || y1 < 0 || y1 >= len(board[0]) || vis[x1][y1] {
				continue
			}
			if dfs(board, word, x1, y1, idx+1, vis) {
				return true
			}
		}
		vis[x][y] = false
		return idx+1 == len(word)
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			vis := make([][]bool, len(board))
			for k := 0; k < len(board); k++ {
				vis[k] = make([]bool, len(board[0]))
			}
			if dfs(board, word, i, j, 0, vis) {
				return true
			}
		}
	}
	return false
}

var direction = [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}