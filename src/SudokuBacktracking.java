public class SudokuBacktracking {

    int[][] tab = {
            {0, 0, 4, 0, 5, 2, 1, 0, 0},
            {0, 0, 7, 1, 0, 0, 4, 0, 0},
            {9, 0, 0, 0, 7, 0, 0, 6, 0},
            {0, 5, 0, 7, 0, 0, 0, 4, 0},
            {0, 0, 1, 0, 4, 0, 0, 0, 0},
            {4, 0, 0, 0, 0, 0, 3, 1, 0},
            {0, 7, 0, 0, 9, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 7, 9, 3, 0},
            {5, 0, 3, 0, 6, 0, 7, 0, 0}
    };

    public boolean fill () {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (tab[y][x] == 0) {
                    for (int number = 1; number <= 9 ; number++) {
                        if (checkAll(number, y, x)) {
                            tab[y][x] = number;
                            if (fill()) {
                                return true;
                            }
                            tab[y][x] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow (int number, int row) {
        for (int x = 0; x < 9; x++) {
            if (tab[row][x] == number)
                return true;
        }
        return false;
    }

    public boolean checkColumn (int number, int column) {
        for (int y = 0; y < 9; y++) {
            if (tab[y][column] == number)
                return true;
        }
        return false;
    }

    public boolean checkSquare (int number, int row, int column) {
        for (int y = 3*(row/3); y < 3*(row/3) + 3; y++) {
            for (int x = 3*(column/3); x < 3*(column/3) + 3; x++) {
                if (tab[y][x] == number)
                    return true;
            }
        }
        return false;
    }

    public boolean checkAll(int number, int row, int column) {
        if (checkRow(number, row) || checkColumn(number, column) || checkSquare(number, row, column))
            return false;
        return true;
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
