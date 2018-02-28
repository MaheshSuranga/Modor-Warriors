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
public abstract class Warrior extends Inhabitor{
    private WalkingStick ws;
    private boolean mobility;
    private boolean immortality;
    private boolean life;
    //keep track of number of Warriors exsisting in the game.
    private static int noOfWar = 0;
    private int x,y;
    private boolean acquire;
    
    
    public Warrior(String name,int age){
        //Warrior constructor and Call the parent class's constricter
        super(name,age);
        mobility = true;
        immortality = false;
        life = true;
        noOfWar++;
        MountDoom.addWarriors(this);
        
        //To start the warrior position in boundry.
        Random rand = new Random();
        if(rand.nextBoolean()){
            x = rand.nextInt(1)*9;
            y = rand.nextInt(10);
        }else{
            y = rand.nextInt(1)*9;
            x = rand.nextInt(10);
        }
        setPosition(x,y);
        
    }
    public boolean getMobility(){
        return mobility;
    }
        
    public void eatFruit(Tree t){
        //eat magic fruit for get immortality.So that monsters cannot kill him.
        if(t.getFruit()){
            this.immortality = true;
            System.out.println(this.getName() + " ate magic fruit. " + this.getName()+ " is now Immortal..");
        }
        else{
            System.out.println("Oops..No fruits to eat.");
            }
        }
    private void changeX(){
        //change the X cordinates according the position and walk toward the mount doom (5,5)
        if(getPosition()[0]<5){
            if(!checkposition(getPosition()[0]+1,getPosition()[1])){
            setPosition(getPosition()[0]+1, getPosition()[1]);
            System.out.println(this.getName()+"   "+"("+this.getPosition()[0]+" "+this.getPosition()[1]+")");
            }
        }
        else if(getPosition()[0]>5){
            if(!checkposition(getPosition()[0]-1, getPosition()[1])){
            setPosition(getPosition()[0]-1, getPosition()[1]);
            System.out.println(this.getName()+"   "+"("+this.getPosition()[0]+" "+this.getPosition()[1]+")");
            }
        }
        else{
            //if he is in the vertical line lies through the (5,5)cordinate.
            changeY();
        }
    }
    private void changeY(){
        //change the Y cordinates according the position and walk toward the mount doom (5,5)
        if(getPosition()[1]<5){
            if(!checkposition(getPosition()[0], getPosition()[1]+1)){
            setPosition(getPosition()[0], getPosition()[1]+1);
            System.out.println(this.getName()+"   "+"("+this.getPosition()[0]+" "+this.getPosition()[1]+")");
            }
        }
        else if(getPosition()[1]>5){
            if(!checkposition(getPosition()[0], getPosition()[1]-1)){
            setPosition(getPosition()[0], getPosition()[1]-1);
            System.out.println(this.getName()+"   "+"("+this.getPosition()[0]+" "+this.getPosition()[1]+")");
            }
        }
        else{
            //if he is in the horizontal line lies through the (5,5)cordinate.
            changeX();
        }
    }
    private void win(){
        //if someone reach the mount doom then notify it and terminate the game.
        //synchronized(Thread.currentThread()){
            //System.out.println("   ****  CONGARTULATION  ****" + "\n" + this.getName() + " wins!!!");
            //System.exit(0);
        //}
    }
    public void walk() throws InterruptedException{
        while(mobility){
            Random rand = new Random();
            //only a single move at one run. 
            if(rand.nextBoolean()){
                changeX();
            }
            else{
                changeY();
            }
            if(getPosition()[0]==5 && getPosition()[1]==5 ){
                //win();
                MountDoom.notifyall();
                
            }
            else if(Grid.getGrid()[x][y] instanceof Tree && !immortality){
                    Tree t = (Tree)Grid.getGrid()[x][y];
                    eatFruit(t);
            }
            else if(Grid.getGrid()[x][y] instanceof DreadfulMonster){
                    DreadfulMonster D = (DreadfulMonster)Grid.getGrid()[x][y];
                    D.kill(this);
            }
            else if(Grid.getGrid()[x][y] instanceof NormalMonster){
                    NormalMonster N = (NormalMonster)Grid.getGrid()[x][y];
                    N.steal(this);
            }
            Thread.sleep(2000);
        }
    }
        
    /**
     *
     * @return
     */
    public static int getNoOfWar(){
        return noOfWar;
    }
     
    public WalkingStick loseStick(){
	mobility = false;
        //way that loose particular warrrior's walkingstick.
	WalkingStick tempws = ws;
	ws = null;
	return tempws;
    }
    public boolean getImmortality(){
        return immortality;
    }
    public void update(){
        this.mobility = false;
    }
    public boolean checkposition(int pos1,int pos2){
        if(Grid.getGrid()[pos1][pos2] instanceof Warrior){
            acquire = true;
        }
        else{
            acquire = false;
        }
        return acquire;
    }

}
