/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class Binocular {
    //keep the positons of the magic trees.
    private int[] treePos;
    public Binocular(){
        treePos = new int[2];
    }
    public synchronized int[] look(int[] position){
        int x = position[0];
        int y = position[1];
        treePos[0] = x;
        treePos[1] = y;
        Object[][] grid = Grid.getGrid();
        if(y+1<10 && grid[x][y+1] instanceof Tree){
            treePos[0] = x;
            treePos[1] = y+1;
        }
        else if(y-1>=0 && grid[x][y-1] instanceof Tree){
            treePos[0] = x;
            treePos[1] = y-1;
        }
        else if(x+1<10 && grid[x+1][y] instanceof Tree){
            treePos[0] = x+1;
            treePos[1] = y;
        }
        else if(x-1>=0 && grid[x-1][y] instanceof Tree){
            treePos[0] = x-1;
            treePos[1] = y;
        }        
        return treePos;
    }
}
