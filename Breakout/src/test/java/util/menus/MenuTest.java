/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.menus;

import breakout.Breakout;
import gamestate.GameStateManager;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Joel
 */
public class MenuTest {

    private final MainMenu menu;

    public MenuTest() {
        Breakout breakout = new Breakout(500, 500);
        menu = new MainMenu(breakout, new GameStateManager(breakout));
    }

    @Before
    public void setUp() {
    }
    
    @Test
    public void constructorWorking() {
        assertEquals(3, menu.choices.size());
        testChoice(0);
    }
    
    @Test
    public void increaseChoiceWorks() {
        menu.increaseChoice();
        testChoice(1);
    }
    
    @Test
    public void increaseChoiceWrapsAround() {
        for(int i = 0; i < 3; i++) {
            menu.increaseChoice();
        }
        testChoice(0);
    }
    
    @Test
    public void changeChoiceWorks() {
        menu.changeChoice(2);
        testChoice(2);
    }
    
    @Test
    public void decreaseChoiceWorks() {
        menu.changeChoice(2);
        menu.decreaseChoice();
        testChoice(1);
    }
    
    @Test
    public void decreaseChoiceWrapsAround() {
        menu.decreaseChoice();
        testChoice(3);
    }
    
    @Test
    public void menuResetWorks() {
        menu.increaseChoice();
        menu.resetMenu();
        testChoice(0);
    }
    
    @Test
    public void getChoices() {
        ArrayList<String> test = menu.getChoices();
        assertEquals("New Game", test.get(0));
    }
    
    
    private void testChoice(int choice) {
        assertEquals(choice, menu.getCurrentChoice());
    }

}
