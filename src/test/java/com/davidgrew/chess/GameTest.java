/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;



/**
 *
 * @author davidgrew
 */
public class GameTest {
    
    @Test
    public void player1SetToPlayFirst()
    {
        //given
        Player player1 = new Player("player1", PieceColour.WHITE);
        Player player2 = new Player("player2", PieceColour.BLACK);

        //when
        Game testGame = new Game(player1, player2);
        
        //then
        assertEquals(testGame.getPlayersTurn(), player1);
    }
    
    @Test
    public void player2SetToPlayFirst()
    {
        //given
        Player player1 = new Player("player1", PieceColour.BLACK);
        Player player2 = new Player("player2", PieceColour.WHITE);

        //when
        Game testGame = new Game(player1, player2);
        
        //then
        assertEquals(testGame.getPlayersTurn(), player2);
    }
    
    @Test
    public void updateTurnTest()
    {
        //given
        Player player1 = new Player("player1", PieceColour.WHITE);
        Player player2 = new Player("player2", PieceColour.BLACK);
        Game testGame = new Game(player1, player2);

        //when
        testGame.updatePlayersTurn();
        
        //then
        assertEquals(testGame.getPlayersTurn(), player2);
    }
    
    @Test
    public void updateWinnerTest()
    {
        //given
        Player player1 = new Player("player1", PieceColour.WHITE);
        Player player2 = new Player("player2", PieceColour.BLACK);
        Game testGame = new Game(player1, player2);

        //when
        testGame.updateWinner();
        
        //then
        assertEquals(testGame.getWinner(), player1);
    }
}
