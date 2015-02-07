
//package gnanqa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sudoku {

    BufferedReader br;
    int[][] sudoku = new int[9][9];
    int prod = 362880;
    int rp;

    public static void main(String[] args) {
        Sudoku sk = new Sudoku();
        sk.begin(args[0]);
    }

    void begin(String fn) {
        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(fn)));

            char[] row;
            for (int i = 0; i < 9; i++) {
                row = br.readLine().toCharArray();

                for (int j = 0; j < 9; j++) {
                    //System.out.println(Character.getNumericValue(row[j]));
                    sudoku[i][j] = Character.getNumericValue(row[j]);

                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(checkSudokuSolution(sudoku, 3))
        {
            System.out.println("Valid");
        }
        else
        {
            System.out.println("Invalid");
        }

        //System.err.println(sudoku);
    }

    public static boolean checkSudokuSolution(int[][] grid, int subSquareSize) {
        //System.out.println("checkSudokuSolution");
        final int size = grid.length;
        //System.out.println("size "+size);

        // First make sure all the values are in the right range.
        if (!checkValues(grid, 1, size)) {
            return false;
        }

        // Check that the rows contain no duplicate values
        for (int row = 0; row < size; ++row) {
            if (!checkRow(grid, row)) {
                return false;
            }
        }

        // Check that the columns contain no duplicate values
        for (int col = 0; col < size; ++col) {
            if (!checkColumn(grid, col)) {
                return false;
            }
        }

        // Check that the subsquares contain no duplicate values
        for (int baseRow = 0; baseRow < size; baseRow += subSquareSize) {
            for (int baseCol = 0; baseCol < size; baseCol += subSquareSize) {
                if (!checkSquare(grid, baseRow, baseCol, subSquareSize)) {
                    return false;
                }
            }
        }

        // If we made it to this point, everything is correct!
        return true;
    }

    
    private static boolean checkValues(int[][] grid, int min, int max) {
        //System.out.println("checkValues");
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[0].length; ++col) {
                if (grid[row][col] < min || grid[row][col] > max) {
                    //System.out.println("row col "+row+col);
                    //System.out.println("fail "+grid[row][col]);
                    return false;
                }
            }
        }
        return true;
    }

    
    private static boolean checkRow(int[][] grid, int whichRow) {
        //System.out.println("checkRow");
        final int size = grid.length;
        boolean[] found = new boolean[size];
        for (int col = 0; col < size; ++col) {
            // set found[x - 1] to be true if we find x in the row
            int index = grid[whichRow][col] - 1;
            if (!found[index]) {
                found[index] = true;
            } else {
                // found it twice, so return false
                return false;
            }
        }

        // didn't find any number twice, so return true
        return true;
    }

    
    private static boolean checkColumn(int[][] grid, int whichCol) {
        //System.out.println("checkColumn");
        final int size = grid.length;
        boolean[] found = new boolean[size];
        for (int row = 0; row < size; ++row) {
            // set found[x - 1] to be true if we find x in the row
            int index = grid[row][whichCol] - 1;
            if (!found[index]) {
                found[index] = true;
            } else {
                // found it twice, so return false
                return false;
            }
        }

        // didn't find any number twice, so return true
        return true;
    }

    
    private static boolean checkSquare(int[][] grid, int baseRow, int baseCol, int subSquareSize) {
        //System.out.println("checkSquare");
        boolean[] found = new boolean[grid.length];
        for (int row = baseRow; row < (baseRow + subSquareSize); ++row) {
            for (int col = baseCol; col < (baseCol + subSquareSize); ++col) {
                // set found[x - 1] to be true if we find x in the row
                int index = grid[row][col] - 1;
                if (!found[index]) {
                    found[index] = true;
                } else {
                    // found it twice, so return false
                    return false;
                }
            }
        }

        return true;
    }
}
