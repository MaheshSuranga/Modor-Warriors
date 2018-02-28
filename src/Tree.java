/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author asus
 */
//inherit from Inhbitor class.
public class Tree {
    private int noOfFruits;
    private int[] position;
    
    public Tree(){
        position = new int[2];
        Random rand = new Random(); 
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        setPosition(x,y);
        noOfFruits  = rand.nextInt(10);
    }
    
    public boolean getFruit(){
        //check the tree for fruit and reduce the fruit count one by one.
        if(noOfFruits>0){
            noOfFruits--;
            return true;
        }
        else{
            return false;
        }
    }
    public void setPosition(int x,int y){
       position[0] = x;
       position[1] = y;
       Grid.setGrid(x, y, this);
    }
}
