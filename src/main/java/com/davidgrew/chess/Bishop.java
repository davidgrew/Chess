/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;

/**
 *
 * @author David
 */
public class Bishop extends Piece implements ChessPiece {
    
    public Bishop(PieceColour colour) {
        this.initialisePiece(colour, null);
    }
    
    public Bishop(PieceColour colour, ChessBoardSquare currentSquare) {
        this.initialisePiece(colour, currentSquare);
    }
    
    @Override
    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {
        
        String movementType = newMovement.getMovementType();
        
        if (movementType.equals("diagonal"))
            return board.isPathClear(newMovement); 
        else 
            return false;
    }
}
