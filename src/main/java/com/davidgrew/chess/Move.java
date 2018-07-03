/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;

import java.util.Map;

/**
 *
 * @author davidgrew
 */
public class Move {
    
    private final Movement movement;
    private final ChessBoard board;
    private final ChessBoardSquare currentSquare;
    private final ChessBoardSquare futureSquare;
    private final Piece currentSquareOriginalPiece;
    private final Piece futureSquareOriginalPiece;
    private final Player currentPlayer;
    private final Map<String, Piece> currentPlayerPieces;
    private final Map<String, Piece> oppositionPieces;
    
    public Move(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, Player currentPlayer, Player oppositionPlayer) {
        this.movement = new Movement(currentSquare, futureSquare);
        this.currentSquare = currentSquare;
        this.futureSquare = futureSquare;
        this.currentPlayer = currentPlayer;
        this.board = board;
        this.currentPlayerPieces = currentPlayer.getActivePieces();
        this.oppositionPieces = oppositionPlayer.getActivePieces();
        this.currentSquareOriginalPiece = currentSquare.currentPiece;
        this.futureSquareOriginalPiece = futureSquare.currentPiece;
    }
    
    public void attemptMove() throws IllegalArgumentException {
        
        if(currentSquare.isSquareEmpty || !currentSquare.currentPiece.colour.equals(currentPlayer.getPieceColour()))
            throw new IllegalArgumentException("cannot move from this square"); 
        else if (!futureSquare.isSquareEmpty && futureSquare.currentPiece.colour.equals(currentPlayer.getPieceColour()))
            throw new IllegalArgumentException("cannot move to this square");
        else if (!currentSquare.currentPiece.isMoveValid(board, movement))
            throw new IllegalArgumentException("illegal movement for this piece");
        
        this.executeMove();
        
        King currentPlayerKing = currentPlayer.getPieceColour() == PieceColour.WHITE ? (King) currentPlayerPieces.get("WKA4") : (King) currentPlayerPieces.get("BKH5");
       
        if (currentPlayerKing.KingInCheck(board, oppositionPieces)) {
            this.reverseMove();
            throw new IllegalArgumentException("cannot move into check");
        }   
    }
    
    public Boolean winningMove() {
        King oppositionKing = currentPlayer.getPieceColour() == PieceColour.WHITE ? (King) oppositionPieces.get("BKH5") : (King) oppositionPieces.get("WKA4");
        return oppositionKing.KingInCheckmate(board, oppositionPieces, currentPlayerPieces);
    }
    
    private void executeMove() {
        currentSquareOriginalPiece.updateCurrentSquare(futureSquare);
        futureSquare.currentPiece = currentSquare.currentPiece;
        currentSquare.currentPiece = null;
        currentSquare.isSquareEmpty = true;
        futureSquare.isSquareEmpty = false;
        if(futureSquareOriginalPiece != null)
            oppositionPieces.remove(futureSquareOriginalPiece.getUniqueName());
    }
    
    public void reverseMove() {
        currentSquareOriginalPiece.updateCurrentSquare(currentSquare);
        currentSquare.currentPiece = currentSquareOriginalPiece;
        futureSquare.currentPiece = futureSquareOriginalPiece;
        currentSquare.isSquareEmpty = false;
        futureSquare.isSquareEmpty = futureSquareOriginalPiece == null;
        if (oppositionPieces != null && futureSquareOriginalPiece != null)
            oppositionPieces.put(futureSquareOriginalPiece.getUniqueName(), futureSquareOriginalPiece);
    }
    
    
    
}
