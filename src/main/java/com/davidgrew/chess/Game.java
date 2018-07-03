/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;

/**
 *
 * @author davidgrew
 */
public class Game {
    
    private final Player player1;
    private final Player player2;
    private Player playersTurn;
    private Player winner = null;
    
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        playersTurn = player1.getPieceColour() == PieceColour.WHITE ? player1 : player2;
    }
    
    public void updatePlayersTurn() {
        this.playersTurn = playersTurn == player1 ? player2 : player1;
    }
    
    public Player getPlayersTurn() {
        return playersTurn;
    }
    
    public void updateWinner() {
        winner = playersTurn == player1 ? player1 : player2;
    }
    
    public Player getWinner() {
        return winner;
    }
}
