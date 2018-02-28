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
//inherit from monster class make the monster class abstract.
public abstract class Monster extends Inhabitor{
    //create individual array for each Moster to collect Walkingsticks and keep track on those sticks.
    private WalkingStick[] walkingSticks;
    private int i;
	
	public Monster(String name, int age){
		super(name,age);
		walkingSticks = new WalkingStick[10];
		i = 0;
                Random rand = new Random(); 
                int x = rand.nextInt(10);
                int y = rand.nextInt(10);
                setPosition(x, y);
                
                
	}
	
	public void steal(Warrior w){
            //call the warrior method loosestick() and put the stick into the array.
		walkingSticks[i++] = w.loseStick();
                System.out.println("Monster " + this.getName() + " steals " + w.getName() + "'s walkingstick.");
	}
    
}
