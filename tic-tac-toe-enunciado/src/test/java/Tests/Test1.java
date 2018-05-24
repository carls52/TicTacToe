package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.codeurjc.ais.tictactoe.Player;
import es.codeurjc.ais.tictactoe.TicTacToeGame;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;








/**
 *
 * @author Carlos Gil Sabrido
 */
public class Test1 {


    Player p1;
    Player p2;
    
    TicTacToeGame juego;
    TicTacToeGame.WinnerResult winner;
    int [] solucion = {0,1,2};
        
    @Before
    public void setUp(){
        
        p1 = new Player(0,"cross","pepe");
        p2 = new Player(1,"circle","juan");
        juego = new TicTacToeGame();
        juego.addPlayer(p1);
        juego.addPlayer(p2);
        
    }
    
    
    @Test
    public void testPlayer1Wins() throws Exception {                        

       
        juego.mark(0);// PLAYER 1
        juego.mark(5);// PLAYER 2
        juego.mark(1);// PLAYER 1
        juego.mark(6);// PLAYER 2
        juego.mark(2);// PLAYER 1
        winner = juego.checkWinner();
        Assert.assertArrayEquals(winner.pos,solucion);
        assertTrue(winner.win);
    }
    @Test
    public void testPlayer2Wins() throws Exception {                        
        
      
        juego.mark(8);// PLAYER 1
        juego.mark(0);// PLAYER 2
        juego.mark(7);// PLAYER 1
        juego.mark(1);// PLAYER 2
        juego.mark(4);// PLAYER 1
        juego.mark(2);// PLAYER 2
        juego.checkWinner();
        winner = juego.checkWinner();
        Assert.assertArrayEquals(winner.pos,solucion);
        assertTrue(winner.win);
    }
    @Test
    public void testCheck() throws Exception {                        

        juego.mark(0);// PLAYER 1
        juego.mark(2);// PLAYER 2
        juego.mark(1);// PLAYER 1
        juego.mark(3);// PLAYER 2
        juego.mark(5);// PLAYER 1
        juego.mark(4);// PLAYER 2
        juego.mark(6);// PLAYER 1
        juego.mark(8);// PLAYER 2
        juego.mark(7);// PLAYER 1
        
        assertTrue("empate",juego.checkDraw());       
    }
}
