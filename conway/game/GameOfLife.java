package game;

import java.util.Arrays;

public class GameOfLife {
    
    private int[][] board;
    private long counter;

    public GameOfLife(int size) {
        board = new int[size][size];
    }

    public int[][] getGeneration() {
        return board;
    }

    public long getIteration() {
        return counter;
    }
    public String toString() {
        String total = new String();
        for (int i = 0; i < board.length; i++) {
            total = total + Arrays.toString(board[i]) + '\n';

        }
        return total;
       
    }

    public int countLivingNeighbors(int x, int y) {
        int[][] currentGeneration = board;
        int result = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                // skip cell itself
                if (i == x && j == y) continue;
                // skip negative indices and indices larger than size
                if (i < 0 || j < 0 || i >= currentGeneration.length || j >= currentGeneration[0].length) continue;

                result += currentGeneration[i][j];
            }
        }
        return result;
    }

    public void calculateNextGeneration() {
        int[][] currentGeneration = board;
        counter++;
        int[][] nextGeneration = new int[currentGeneration.length][currentGeneration[0].length];

         for (int i = 0; i < currentGeneration.length;i++) {
            for (int j = 0; j < currentGeneration[i].length; j++) {
                int livingNeighbours = countLivingNeighbors(i, j);

                if (currentGeneration[i][j] == 0 && livingNeighbours == 3) {
                    // 3 living neighbours and dead cell
                    nextGeneration[i][j] = 1;
                } else if (currentGeneration[i][j] == 1 && (livingNeighbours < 2 || livingNeighbours > 3)) {
                    // living cell dies
                    nextGeneration[i][j] = 0;
                } else {
                    // case cell is dead and not exactly 3 living neighbours -> cell dead in next step
                    // case cell lives but has 2 or 3 living neighbours -> cell does not die
                    nextGeneration[i][j] = currentGeneration[i][j];
                }

            }
         }

        board = nextGeneration;
    }
}