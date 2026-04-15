public class Conway {

    public static void printGeneration(int[][] generation) {
        for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                System.out.print(generation[i][j]);
                if (j + 1 != generation.length) System.out.print(" ");
            }
            System.out.println("");
        } 
        System.out.println("----------------------------");
    }


    public static int countLivingNeighbors(int[][] currentGeneration, int x, int y) {
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



    public static int[][] calculateNextGeneration(int[][] currentGeneration) {
        int[][] nextGeneration = new int[currentGeneration.length][currentGeneration[0].length];

         for (int i = 0; i < currentGeneration.length;i++) {
            for (int j = 0; j < currentGeneration[i].length; j++) {
                int livingNeighbours = countLivingNeighbors(currentGeneration, i, j);

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

        return nextGeneration;
    }
    

    public static void main(String[] arg) {

        int[][] generation = new int[10][10];

        // fill the board with dead cells
        for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                generation[i][j] = 0;
            } 
        }
        // all cells dead
        printGeneration(generation);

        // sample start configuration
        generation[1][2] = 1;
        generation[2][3] = 1;
        generation[3][1] = 1;
        generation[3][2] = 1;
        generation[3][3] = 1;

        printGeneration(generation);

        for (int i = 0; i < 5;i++) {
            generation = calculateNextGeneration(generation);
            printGeneration(generation);
        }

    }

}