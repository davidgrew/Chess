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
public class ChessMove {
    
    public ChessBoard board;
    public ChessBoardSquare currentSquare;
    public ChessBoardSquare futureSquare;
    private ChessPlayer currentPlayer;
    
    public ChessMove(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, ChessPlayer currentPlayer) {
        this.currentSquare = currentSquare;
        this.futureSquare = futureSquare;
        this.currentPlayer = currentPlayer;
        this.board = board;
    }
    
    public Boolean isMoveValid() {
    if((currentSquare.isSquareEmpty == false && currentSquare.currentPiece.colour.equals(currentPlayer.getPieceColour())))
        return currentSquare.currentPiece.isMoveValid(board, currentSquare, futureSquare, currentPlayer);
    else
        return false;
    }
    
    public void executeMove() {
        futureSquare.currentPiece = currentSquare.currentPiece;
        currentSquare.currentPiece = null;
        currentSquare.isSquareEmpty = true;
        futureSquare.isSquareEmpty = false;
    }
    
    public void checkForWinningMove() {
        
    }
    
}