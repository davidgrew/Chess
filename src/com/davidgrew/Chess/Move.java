/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

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
    }
    
    public Boolean executeMove() {
        
        if(currentSquare.isSquareEmpty || !currentSquare.currentPiece.colour.equals(currentPlayer.getPieceColour()) || (!futureSquare.isSquareEmpty && futureSquare.currentPiece.colour.equals(currentPlayer.getPieceColour())))
            return false; 
        
        if (!currentSquare.currentPiece.isMoveValid(board, movement))
            return false;
        
        MoveExecution move = new MoveExecution(currentSquare, futureSquare, oppositionPieces);
        move.execute();
        
        King currentPlayerKing = currentPlayer.getPieceColour().equals("white") ? (King) currentPlayerPieces.get("WKA4") : (King) currentPlayerPieces.get("BKH5");
       
        if (currentPlayerKing.KingInCheck(board, oppositionPieces)) {
            move.reverse();
            return false;
        }   
        return true;
    }
    
    public Boolean winningMove() {
        King oppositionKing = currentPlayer.getPieceColour().equals("white") ? (King) oppositionPieces.get("BKH5") : (King) oppositionPieces.get("WKA4");
        return oppositionKing.KingInCheckmate(board, oppositionPieces, currentPlayerPieces);
    }
    
}
