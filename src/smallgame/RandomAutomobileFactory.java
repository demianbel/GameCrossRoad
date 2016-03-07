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
public class RandomAutomobileFactory {

    int[][] field;

    public RandomAutomobileFactory(int[][] field) {
        this.field = field;
    }

    public Automobile getRandomAutoForY(int y) {
        return new Automobile(field, y, (int) (Math.random() * 3 + 1), (int) (Math.random() * 2 + 1), getBoolean((int) (Math.random() * 2 + 1)));
    }

    private boolean getBoolean(int i) {
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }
}
