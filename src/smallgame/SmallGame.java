/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Демьян
 */
public class SmallGame  {
    static GameFrame gui;
    static Result res;
    static long speed =100;
    static Thread thr = new Thread(new MyThread());
    static int[][] field = new int[20][20];
    private static final int[][] winField ={
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
{2,2,0,0,0,2,0,0,2,0,0,2,0,2,0,0,0,0,0,0},
{2,0,2,0,2,0,0,2,0,2,0,2,0,2,0,0,0,0,0,0},
{3,0,0,2,0,0,0,2,0,2,0,2,0,2,0,0,0,0,0,0},
{4,0,0,2,0,0,0,2,0,2,0,2,0,2,0,0,0,0,0,0},
{5,0,0,2,0,0,0,2,0,2,0,2,0,2,0,0,0,0,0,0},
{6,0,0,2,0,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0},
{7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
{8,0,0,0,0,0,0,0,2,0,0,0,0,0,0,2,0,0,0,0},
{9,0,2,0,2,0,2,0,0,0,2,0,0,2,0,2,0,0,0,0},
{20,0,2,0,2,0,2,0,2,0,2,0,2,2,0,2,0,0,0,0},
{22,0,2,0,2,0,2,0,2,0,2,0,2,2,0,2,0,0,0,0},
{22,0,2,0,2,0,2,0,2,0,2,2,0,2,0,2,0,0,0,0},
{23,0,2,0,2,0,2,0,2,0,2,2,0,2,0,2,0,0,0,0},
{24,0,0,2,0,2,0,0,2,0,2,0,0,2,0,0,0,0,0,0},
{25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0},
{26,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
{27,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
{28,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
{29,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  
    };
    private static final int[][] looseField = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,1,0,0,1,0,0,1,0,1,0,0,0,0,0,0},
            {0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},
            {0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0},
            {0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0},
            {0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,0,1,1,1},
            {0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0},
            {0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0},
            {0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}   
    };
    static Player pl = new Player(field);
    static int count;
    static RandomAutomobileFactory raf = new RandomAutomobileFactory(field);
    static List<Automobile> autoArray = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void resetField() {
        field = new int[20][20];
    }

    public static void fillAuto() {
        count=1;
        outer:
        for (int j = 1;; j++) {
            int i;
            for (i = j; i > 0; i--) {
                if (count > field.length) {
                    break outer;
                }
                ++count;
                autoArray.add(raf.getRandomAutoForY(count));
            }
            ++count;
        }
    }
    public static void repaintField(){
        //edit array field[][] and repaint gui
        while (!pl.loose && !pl.win) {
           
            resetField();
            for (Automobile autoN : autoArray) {
                for (int i = autoN.x; i <= autoN.endX; i++) {
                    field[autoN.y - 1][i - 1] = 1;
                
                }
            }
            int posX = pl.getX() - 1;
            int posY = pl.getY() - 1;
            if (field[posY][posX] == 1) {
                pl.loose = true;
            } else {
                field[posY][posX] = 2;

                gui.setField(field);
            }
        }
        if (pl.loose) {
            System.out.print("loose");
            gui.setField(looseField);
            
            
        } else {
            
            gui.setField(winField);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        gui = new GameFrame(field);
        gui.setVisible(true);
        gui.addKeyListener(pl);
        fillAuto();
        thr.start();
        repaintField();
        
        
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
           
            int count = 0;
            while (!pl.loose && !pl.win) {
                try {
                    sleep(speed);
                } catch (Exception e) {
                    
                }
                count++;
                for (Automobile auto : autoArray) {
                    if (auto.speed >= count) {
                       auto.move();
                    }

                }
                if (count == 2){
                    count = 0;
                }
            }
            
        }

    }
    static class EnterKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key==KeyEvent.VK_ENTER){
             //field = new int[20][20];
             pl = new Player(field);
             autoArray = new ArrayList();
             fillAuto();
             thr = new Thread(new MyThread());
             thr.start();
             //res.setVisible(false);
             //System.out.println(pl.getX() + " " +pl.getY());
             //gui.setVisible(true);
             //gui.update(g);
             repaintField();
            }
            
//To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //To change body of generated methods, choose Tools | Templates.
        }
        
    }

}
