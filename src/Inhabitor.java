/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
//make the class abstract.
public abstract class Inhabitor {
    //Initialize common attributes of Warriors,Monsters and Trees
    private String name;
    private int age;
    private int[] position;
    
    public Inhabitor(String name,int age){
        //build main constructor
        this.name = name;
        this.age = age;
        position = new int[2];
    }
    public void setPosition(int x,int y){
       synchronized(this){
        position[0] = x;
        position[1] = y;
        Grid.setGrid(x, y, this);
       }
    }
    public int[] getPosition(){
        return position;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
