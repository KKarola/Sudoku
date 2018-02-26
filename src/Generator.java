import java.util.ArrayList;
import java.util.Random;

public class Generator {

    public Generator (int i) {
        fill();
        solve();
        hide(i);
    }

    private int[][] tab = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private ArrayList<Integer> numbers;
    private void init(int size) {
        numbers = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            numbers.add(new Integer(i));
        }
    }

    private Integer get() {
        Random random = new Random();
        int i = random.nextInt(numbers.size());
        int j = numbers.get(i);
        numbers.remove(i);
        return j;
    }

    // filling the diagonal
    private void fill() {
        for (int i = 0; i < 3; i++) {
            init(10);
            for (int j = 3 * i; j < 3 * i + 3; j++) {
                for (int k = 3 * i; k < 3 * i + 3; k++) {
                    tab[j][k] = get();
                }
            }
        }
    }

    // solution
    private boolean solve () {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (tab[y][x] == 0) {
                    for (int number = 1; number <= 9 ; number++) {
                        if (checkAll(number, y, x)) {
                            tab[y][x] = number;
                            if (solve()) {
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

    private boolean checkRow (int number, int row) {
        for (int x = 0; x < 9; x++) {
            if (tab[row][x] == number)
                return true;
        }
        return false;
    }

    private boolean checkColumn (int number, int column) {
        for (int y = 0; y < 9; y++) {
            if (tab[y][column] == number)
                return true;
        }
        return false;
    }

    private boolean checkSquare (int number, int row, int column) {
        for (int y = 3*(row/3); y < 3*(row/3) + 3; y++) {
            for (int x = 3*(column/3); x < 3*(column/3) + 3; x++) {
                if (tab[y][x] == number)
                    return true;
            }
        }
        return false;
    }

    private boolean checkAll(int number, int row, int column) {
        if (checkRow(number, row) || checkColumn(number, column) || checkSquare(number, row, column))
            return false;
        return true;
    }

    // hiding the selected number of items
    private int amount = 0;
    private void hide(int i) {
        init(81);
        while (amount < 81-i) {
            int cover = get();
            tab[cover/9][cover%9] = 0;
            amount++;
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

    public static void main(String[] args) {
        Generator generator = new Generator(20);
        System.out.println("Wygenerowana plansza sudoku:\n");
        generator.print();
    }
}
