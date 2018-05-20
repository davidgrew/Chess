/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

/**
 *
 * @author davidgrew
 */
public class ChessGame {
    
    private ChessPlayer player1;
    private ChessPlayer player2;
    private Boolean isPlayerOnesTurn;
    private ChessPlayer winner = null;
    
    public ChessGame(ChessPlayer player1, ChessPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        
        if (player1.getPieceColour().equals("white"))
            this.isPlayerOnesTurn = true;
        else
            this.isPlayerOnesTurn = false;
    }
    
    public void updatePlayersTurn() {
        this.isPlayerOnesTurn = !this.isPlayerOnesTurn;
    }
    
    public ChessPlayer getPlayersTurn() {
        if (this.isPlayerOnesTurn)
            return this.player1;
        else
            return this.player2;
    }
    
    public void updateWinner() {
        if (this.isPlayerOnesTurn)
            winner = player1;
        else
            winner = player2;
    }
    
    public ChessPlayer getWinner() {
        return winner;
    }
}
