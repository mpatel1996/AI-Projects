/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

public class solution {
    
//    static String QUEEN_SOLUTION;
    static final int MAX_QUEENS = 8;
    static int squares[][];
    static Queen q;
    
    public static void main(String[] args){
        solution sol = new solution();
        sol.newSolution();
       
    }

    public static boolean solvedNQueens(int[][] squares, int currCol) {
        Random rand = new Random();
        int randomIndex;
        
        if(currCol >= MAX_QUEENS) return true;
        
        for(int i = 0; i < MAX_QUEENS; i++){
            randomIndex = rand.nextInt(8);
            if(safeForPlacement(squares, randomIndex, currCol)){
                squares[randomIndex][currCol] = 1;
                
                if (solvedNQueens(squares, currCol +1) == true){
                    return true;
                }
                    squares[randomIndex][currCol] = 0;
                
            }
        }
        return false;//To change body of generated methods, choose Tools | Templates.
    }

    private static boolean safeForPlacement(int[][] squares, int currRow, int currCol) {
        
         int i, j; 
  
        /* Check this row on left side */
        for (i = 0; i < currCol; i++) 
            if (squares[currRow][i] == 1) 
                return false; 
  
        /* Check upper diagonal on left side */
        for (i = currRow, j = currCol; i >= 0 && j >= 0; i--, j--) 
            if (squares[i][j] == 1) 
                return false; 
  
        /* Check lower diagonal on left side */
        for (i = currRow, j = currCol; j >= 0 && i < MAX_QUEENS; i++, j--) 
            if (squares[i][j] == 1) 
                return false; 

        return true;
    }

    public void newSolution() {
        squares = new int[8][8];
        q = new Queen();
        for (int[] square : squares) {
            for (int j = 0; j < square.length; j++) {
                square[j] = 0;
            }
        }
        
        System.out.println("Before the functions");
        for (int[] square : squares) {
            for (int j = 0; j < square.length; j++) {
                System.out.print(square[j] + " ");
            }
            System.out.println();
        }        
        
        if(solvedNQueens(squares, 0) == false){
            System.out.println("No Solution Found");
        }
        
        System.out.println("After the functions");
        for (int[] square : squares) {
            for (int j = 0; j < square.length; j++) {
                System.out.print(square[j] + " ");
            }
            System.out.println();
        }   
         
        q.DrawQueen(squares);
        q.revalidate();
       
    }
}


