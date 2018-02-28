
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
//inherit from Warrior class and Behaviour interface
public class SuperWarrior extends Warrior implements Runnable, Behaviour {
    private Binocular bn;
    public SuperWarrior(String name, int age){
        super(name,age);
        bn = new Binocular();
        
        
    }
   
    public void walk() throws InterruptedException{
        while(getMobility()){
            int[] bnPos = bn.look(getPosition());
            if(bnPos[0]==getPosition()[0] && bnPos[1]==getPosition()[1]){
                //if warrior at a tree or no any tree in his vicinity,then continue walk to mountdoom.
                super.walk();
               
            }
            else{
                //check the immortality here for avoid the wandering around the magic tree.
                if(Grid.getGrid()[bnPos[0]][bnPos[1]] instanceof Tree && !this.getImmortality()){
                    Tree t = (Tree)Grid.getGrid()[bnPos[0]][bnPos[1]];
                    eatFruit(t);
                    setPosition(bnPos[0], bnPos[1]);
                }
                else{
                    super.walk();
                }
                
            }
        }
        
    }
    public void run(){
        
        try {
            walk();
        } catch (InterruptedException ex) {
            Logger.getLogger(SuperWarrior.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }

     public void eat(){
        //eat like super Warrior
    }
    public void drink(){
        //drink like super Warrior
    }
    public void sleep(){
        //s;eep like super Warrior
    }
    
}
