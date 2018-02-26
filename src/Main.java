public class Main {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.fill();
        System.out.println("Rozwiązanie prostej tablicy sudoku");
        sudoku.print();

        System.out.println("\n\n\n");

        SudokuBacktracking sudokuBacktracking = new SudokuBacktracking();
        sudokuBacktracking.fill();
        System.out.println("Rozwiązanie sudoku - algorytm z nawrotami");
        sudokuBacktracking.print();
    }
}
