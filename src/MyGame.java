/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class MyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MountDoom m1 = new MountDoom();
        
        Thread t1 = new Thread(new NormalWarrior("A",25));
        Thread t2 = new Thread(new SuperWarrior("B",15));
        Thread t3 = new Thread(new SuperWarrior("C",18));
        Thread t4 = new Thread(new NormalWarrior("D",26));
        Thread t5 = new Thread(new SuperWarrior("E",20));
        
        new NormalMonster("F",80);
        new NormalMonster("G",100);
        new DreadfulMonster("H",650);
        new DreadfulMonster("I",220);
        new DreadfulMonster("J",500);
        
        new Tree();
        new Tree();
        new Tree();
        
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    
}
