/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Демьян
 */
public class Result extends JFrame {
           private boolean win;
           Font font = new Font("Arial",0,40);
    public Result(boolean win) {
        super("Game CrossRoad result");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,50,500,500);
        this.win = win; 
        setResizable(false);
        //repaint();
    }
    public void paint(Graphics g){
        System.out.println("перерисовка окна 2");
        g.clearRect(1, 1, 500, 500);
        g.setFont(font);
        g.setColor(Color.black);
        if (!win)
        g.drawString("You loose!", 150 , 100);
        else
        g.drawString("You win!", 170 , 100);    
        g.drawString("Press enter to try again!",50,150);
    }
}
