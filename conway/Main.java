import game.GameOfLife;


class Main {
    public static void main(String[] args) {
        GameOfLife board = new GameOfLife(15);
        int[][] generation = board.getGeneration();
        generation[1][2] = 1;
        generation[2][3] = 1;
        generation[3][1] = 1;
        generation[3][2] = 1;
        generation[3][3] = 1;

        printGeneration(board.getGeneration());


        for (int i = 0; i < 5;i++) {
            board.calculateNextGeneration();
            printGeneration(board.getGeneration());
        }
    }

    private static void printGeneration(int[][] generation) {
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < generation[i].length; j++) {
                System.out.print(generation[i][j]);
                if (j + 1 != generation[i].length) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }
}