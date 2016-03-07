/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Демьян
 */
public class Player implements KeyListener {
    private int x,y;
    private final static int MOVE_UP=1, MOVE_LEFT=2, MOVE_RIGHT=3, MOVE_DOWN=4;
    boolean win = false, loose = false;
    int width,hight;
    public Player(int[][] field){
        this.x = field[1].length/2;
        this.y = 1;
        this.width = field[1].length;
        this.hight = field.length;
    }
    private int health = 5;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void move(int i){
        switch(i){
            case MOVE_UP:{
                if(y>=2) --y;
                break;
            }
            case MOVE_DOWN:{
                if(y>=hight){
                    win=true;
                }
                else ++y;
                break;
            }
            case MOVE_LEFT:{
                if(x==1)x=width;
                else x--;
                break;
            }
            case MOVE_RIGHT:{
                if(x==width)x=1;
                else x++;
                break;
            }
            
        }
           System.out.println(getX() + " " +getY());            
    }

    @Override
    public void keyTyped(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    int key = e.getKeyCode();
    switch(key){
        case KeyEvent.VK_UP:
            move(MOVE_UP);
            break;
        case KeyEvent.VK_DOWN:
            move(MOVE_DOWN);
            break;
        case KeyEvent.VK_LEFT:
            move(MOVE_LEFT);
            break;
        case KeyEvent.VK_RIGHT:
            move(MOVE_RIGHT);
            break;
        default: break;
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
