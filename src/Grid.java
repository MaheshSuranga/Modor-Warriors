/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class Grid {
    //place the inhabitors on the game grid 
    private static Object[][] grid = new Object[10][10];
    
    public static Object[][] getGrid(){
        synchronized(Thread.currentThread()){
        return grid;
        }
    }
    public static void setGrid(int x, int y,Object obj){
        synchronized(Thread.currentThread()){
        grid[x][y] = obj;
        }
    }
   
    
}
