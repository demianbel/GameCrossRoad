/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallgame;

/**
 *
 * @author Демьян
 */
public class Automobile {

    int width, length, speed, x, y, numb, endX;
    boolean direction;

    public Automobile(int[][] field, int y, int length, int speed, boolean toRight) {
        this.width = field[1].length;
        this.length = length;
        this.speed = speed;
        this.direction = toRight;
        if (direction) {
            x = 1;
        } else {
            x = width - length + 1;
        }
        this.y = y;
        this.endX = x + length - 1;
    }

    public void move() {

        if (direction) {
            if (endX < width) {
                x++;
                endX++;
            } else {
                x = 1;
                endX = length;
            }
        } else if (x > 1) {
            x--;
            endX--;
        } else {
            x = width - length + 1;
            endX = width;
        }
    }
}
