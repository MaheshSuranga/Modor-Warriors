/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
//inherit from Monster class
public class DreadfulMonster extends Monster{
    public DreadfulMonster(String name, int age){
        super(name,age);
    }
    public void kill(Warrior w){
        if(!w.getImmortality()){
            steal(w);
            MountDoom.removeWarriors(w);
            String warriorName = w.getName();
            w = null;
            System.out.println("Warrior "+warriorName + " is killed by Monster " + this.getName());
            int no_war = w.getNoOfWar();
            no_war--;
        }
    }
    
}
