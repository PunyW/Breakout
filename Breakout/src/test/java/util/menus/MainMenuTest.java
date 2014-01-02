/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.menus;

import breakout.Breakout;
import gamestate.GameStateManager;
import gamestate.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 *
 * @author Joel
 */
public class MainMenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    
    private final MainMenu menu;
    private final Breakout breakout;
    private final GameStateManager gsm;
    private final ArrayList<String> choices;

    public MainMenuTest() {
        breakout = new Breakout(500, 500);
        gsm = new GameStateManager(breakout);
        menu = new MainMenu(breakout, gsm);
        choices = menu.getChoices();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void initWorks() {
        assertEquals("New Game", choices.get(0));
        assertEquals("Quit Game", choices.get(choices.size() - 1));
    }

    @Test
    public void newGameWorks() {
        breakout.getPaddle().move(100);
        menu.start(0);
        assertEquals(220, breakout.getPaddle().getX());
        assertEquals(gsm.getState(), GameStates.PLAYSTATE);
    }

    @Test
    public void helpWorks() {
        menu.start(1);
        assertEquals(gsm.getState(), GameStates.HELP);
    }

    @Test
    public void quitWorks() {
        exit.expectSystemExitWithStatus(0);
        menu.start(2);
    }

}
