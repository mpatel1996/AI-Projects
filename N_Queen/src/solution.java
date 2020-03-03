/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

public class solution {
    
    static final int MAX_QUEENS = 8;
    static int squares[][];
    
    public static void main(String[] args){
        solution sol = new solution();
        
        sol.newSolution();       
    }
    
    
    private static boolean solvedNQueens(int[][] squares, int currCol) {
        Random rand = new Random();
        int randomIndex;
        
        randomIndex = rand.nextInt(8); // random first row and same everything else

        if(currCol >= MAX_QUEENS) return true;
        
        for(int i = 0; i < MAX_QUEENS; i++){
            
            // Random for each col index for each row. 
//            randomIndex = rand.nextInt(8);
            
            
            System.out.println("### RANDOM INT ### -> " + randomIndex);
            if(notAttacking(squares, randomIndex, currCol)){
                squares[randomIndex][currCol] = 1;
                System.out.println("### RANDOM INT ACCEPTED ### -> " + randomIndex);
                
                if (solvedNQueens(squares, currCol +1) == true){
                    return true;
                }else{
                    squares[randomIndex][currCol] = 0;
                }
                
            }
        }
        return false;//To change body of generated methods, choose Tools | Templates.
    }

    private static boolean notAttacking(int[][] squares, int currRow, int currCol) {
        
         int i, j; 
  
        // Check for horizontal attacks
        for (i = 0; i < currCol; i++) 
            if (squares[currRow][i] == 1) 
                return false; 
  
        // check for diagonal attacks 
        for(i = 0; i < MAX_QUEENS; i++)
        {
            for(j = 0;j < MAX_QUEENS; j++)
            {
                if(((i+j) == (currRow + currCol)) || ((i-j) == (currRow - currCol)))
                {
                    if(squares[i][j] == 1)
                        return false;
                }
            }
        }
        
        return true;
    }

    public void newSolution() {
        squares = new int[8][8];
        Queen q = new Queen();
        
        
        for (int[] square : squares) {
            for (int j = 0; j < square.length; j++) {
                square[j] = 0;
            }
        }
      
        if(solvedNQueens(squares, 0) == false){
            System.out.println("No Solution Found");
            q.PopUpDialog();
        }
        
        System.out.println("*** A New Solution ***");
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


