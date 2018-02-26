public class Sudoku {
    boolean solve = false;

    int tab[][] = {
            {0, 0, 4, 0, 5, 2, 1, 0, 8},
            {0, 2, 7, 1, 0, 0, 4, 0, 0},
            {9, 0, 0, 0, 7, 0, 0, 6, 0},
            {0, 5, 0, 7, 0, 9, 0, 4, 0},
            {0, 8, 1, 0, 4, 0, 5, 0, 0},
            {4, 0, 0, 8, 0, 0, 3, 1, 0},
            {0, 7, 0, 0, 9, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 7, 9, 3, 0},
            {5, 0, 3, 2, 6, 0, 7, 0, 0}
    };

    public void fill() {
        while (!solve) {
            solve = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (tab[i][j] == 0) {
                        solve = false;
                        check(i, j);
                    }
                }
            }
        }
    }


    public void check(int i, int j) {
        boolean[] array = new boolean[9];
        int amount = 0;
        int number = 0;

        for (int k = 1; k <= 9; k++) {
            // checking rows
            for (int x = 0; x < 9; x++) {
                if (tab[i][x] == k) {
                    array[k - 1] = true;
                    break;
                }
            }

            // checking columns
            for (int y = 0; y < 9; y++) {
                if (tab[y][j] == k) {
                    array[k - 1] = true;
                    break;
                }
            }

            // checking squaeres
            for (int y = 3 * (i / 3); y < 3 * (i / 3) + 3; y++) {
                for (int x = 3 * (j / 3); x < 3 * (j / 3) + 3; x++) {
                    if (tab[y][x] == k) {
                        array[k - 1] = true;
                        break;
                    }
                }
            }

            if (array[k - 1] == false) {
                amount++;
                number = k;
            }
        }

        if (amount == 1) {
            tab[i][j] = number;
        }

    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tab[i][j] + " ");
                if ((j + 1) % 3 == 0)
                    System.out.print(" ");
            }
            System.out.println(" ");
            if (((i + 1) % 3 == 0) && i != 8)
                System.out.println(" ");
        }
    }

}