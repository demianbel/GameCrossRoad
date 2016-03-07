/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallgame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Демьян
 */
public class GameFrame extends JFrame {

    int[][] field;
    int rectSize = 20;

    public GameFrame() {
        super("Game CrossRoad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GameFrame(int[][] field) {
        this();
        this.field = field;
        setBounds(300, 50, field[1].length * rectSize, field.length * rectSize + 25);
        setResizable(false);
    }

    public void setField(int[][] field) {

        this.field = field;
        repaint();
    }

    public void paint(Graphics g) {

        int y = 25;
        for (int i[] : field) {
            int x = 0;
            for (int j : i) {
                switch (j) {
                    //field
                    case 0:
                        g.setColor(Color.BLACK);
                        break;
                    //automobile
                    case 1:
                        g.setColor(Color.red);
                        break;
                    //player
                    case 2:
                        g.setColor(Color.GREEN);
                        break;
                    default:
                        break;
                }
                g.fillRect(x, y, rectSize, rectSize);
                x += rectSize;
            }
            y += rectSize;
        }
    }
}
