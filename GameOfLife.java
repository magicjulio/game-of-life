class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // Mark as live to dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // Mark as dead to live
                    }
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0; // Update to dead
                } else if (board[i][j] == 2) {
                    board[i][j] = 1; // Update to live
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int x, int y) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Skip the cell itself
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (board[newX][newY] == 1 || board[newX][newY] == -1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}