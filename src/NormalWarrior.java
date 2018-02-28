
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
//inherit from Warrior class and Behaviour interfave
public class NormalWarrior extends Warrior implements Runnable, Behaviour {
    public NormalWarrior(String name,int age){
        super(name,age);
        
    }
    
    public void run(){
        
        try {
            walk();
        } catch (InterruptedException ex) {
            Logger.getLogger(NormalWarrior.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void eat(){
        //eat like normal Warrior
    }
    public void drink(){
        //drink like normal Warrior
    }
    public void sleep(){
        //s;eep like normal Warrior
    }
}
