
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class MountDoom{
    private int[] position;
    private static ArrayList<Warrior> warriors;
    
    public MountDoom(){
        position = new int[]{5,5};
        Grid.setGrid(5,5,this);
        warriors = new ArrayList<Warrior>();
    }
    public static void addWarriors(Warrior w){
        warriors.add(w);
    }
    public static void removeWarriors(Warrior w){
        warriors.remove(w);
    }
    
    
    public static void notifyall(){
        for(Warrior w: warriors){
            w.update();
        }
        announce();
    }
    public static void announce(){
        Warrior w = (Warrior)Grid.getGrid()[5][5];
        System.out.println("   ****  CONGARTULATION  ****" + "\n" + w.getName() + " wins!!!");
        System.out.println("Game End !!! A warrior reach the MOUNT DOOM");
        try { 
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Result.txt")));
            pw.println(w.getName() + " won the game."+ "\n"+" he is " + w.getAge() + " years old." );
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(MountDoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
