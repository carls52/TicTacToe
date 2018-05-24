/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import es.codeurjc.ais.tictactoe.Connection;
import es.codeurjc.ais.tictactoe.Player;
import es.codeurjc.ais.tictactoe.TicTacToeGame;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.reset;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;
import static org.hamcrest.CoreMatchers.hasItems;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 *
 * @author Carlos Gil Sabrido
 */
public class TestDoble {
    TicTacToeGame juego = new TicTacToeGame();
    Connection con_1;
    Connection con_2;
    Player p1;
    Player p2;
    ArgumentCaptor<WinnerValue> argument;
    int [] solucion = {0,1,2};
    
    @Before
    public void setUp(){
        con_1 = mock(Connection.class);
        con_2 = mock(Connection.class);
        juego.addConnection(con_1); 
        juego.addConnection(con_2); 
        
        p1 = new Player(0,"cross","pepe");
        p2 = new Player(1,"circle","juan");
        
        juego.addPlayer(p1);
        verify(con_1).sendEvent(
                            eq(EventType.JOIN_GAME), argThat(hasItems(p1)));
        verify(con_2).sendEvent(
                            eq(EventType.JOIN_GAME), argThat(hasItems(p1)));  
        reset(con_1);
        reset(con_2);
        juego.addPlayer(p2);

        verify(con_1).sendEvent(
                            eq(EventType.JOIN_GAME), argThat(hasItems(p1,p2)));
        verify(con_2).sendEvent(
                            eq(EventType.JOIN_GAME), argThat(hasItems(p1,p2)));

        verify(con_1).sendEvent(EventType.SET_TURN, p1);
        verify(con_2).sendEvent(EventType.SET_TURN, p1);
    }
    
    @Test
    public void testPlayer1Wins() throws Exception {
        
        reset(con_1);
        reset(con_2);
        juego.mark(0);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(5);// PLAYER 2
        verify(con_1).sendEvent(EventType.SET_TURN,p1);
        verify(con_2).sendEvent(EventType.SET_TURN,p1);
        reset(con_1);
        reset(con_2);
        juego.mark(1);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(6);// PLAYER 2
        verify(con_1).sendEvent(EventType.SET_TURN,p1);
        verify(con_2).sendEvent(EventType.SET_TURN,p1);
        reset(con_1);
        reset(con_2);
        juego.mark(2);// PLAYER 1
        
        argument = ArgumentCaptor.forClass(WinnerValue.class);
        verify(con_1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
        WinnerValue event = argument.getValue();

        Assert.assertArrayEquals(solucion,event.pos);
        assertEquals(event.player,p1);
    }
    @Test
    public void testPlayer2Wins() throws Exception {
        //8 0 7 1 4 2
        
        reset(con_1);
        reset(con_2);
        juego.mark(8);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(0);// PLAYER 2
        verify(con_1).sendEvent(EventType.SET_TURN,p1);
        verify(con_2).sendEvent(EventType.SET_TURN,p1);
        reset(con_1);
        reset(con_2);
        juego.mark(7);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(1);// PLAYER 2
        verify(con_1).sendEvent(EventType.SET_TURN,p1);
        verify(con_2).sendEvent(EventType.SET_TURN,p1);
        reset(con_1);
        reset(con_2);
        juego.mark(4);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(2);// PLAYER 2
        
        argument = ArgumentCaptor.forClass(WinnerValue.class);
        verify(con_1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
        WinnerValue event = argument.getValue();

        Assert.assertArrayEquals(solucion,event.pos);
        assertEquals(event.player,p2);
    }
    @Test
    public void testCheck() throws Exception {
       // 0 2 1 3 5 4 6 8 7
        
        reset(con_1);
        reset(con_2);
        juego.mark(0);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(2);// PLAYER 2
        verify(con_1).sendEvent(EventType.SET_TURN,p1);
        verify(con_2).sendEvent(EventType.SET_TURN,p1);
        reset(con_1);
        reset(con_2);
        juego.mark(1);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(3);// PLAYER 2
        verify(con_1).sendEvent(EventType.SET_TURN,p1);
        verify(con_2).sendEvent(EventType.SET_TURN,p1);
        reset(con_1);
        reset(con_2);
        juego.mark(5);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(4);// PLAYER 2
        verify(con_1).sendEvent(EventType.SET_TURN,p1);
        verify(con_2).sendEvent(EventType.SET_TURN,p1);
        reset(con_1);
        reset(con_2);
        juego.mark(6);// PLAYER 1
        verify(con_1).sendEvent(EventType.SET_TURN,p2);
        verify(con_2).sendEvent(EventType.SET_TURN,p2);
        reset(con_1);
        reset(con_2);
        juego.mark(8);// PLAYER 2
        verify(con_1).sendEvent(EventType.SET_TURN,p1);
        verify(con_2).sendEvent(EventType.SET_TURN,p1);
        reset(con_1);
        reset(con_2);
        juego.mark(7);// PLAYER 1
        
        argument = ArgumentCaptor.forClass(WinnerValue.class);
        verify(con_1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
        WinnerValue event = argument.getValue();

        assertEquals(null,event);


    }

@Test
public void testnada(){}
}


