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
public class Castle extends Piece implements ChessPiece {
    
    public Castle(PieceColour colour) {
        this.initialisePiece(colour, null);
    }
    
    public Castle(PieceColour colour, ChessBoardSquare currentSquare) {
        this.initialisePiece(colour, currentSquare);
    }

    @Override
    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {
        
        String movementType = newMovement.getMovementType();
                
        if (movementType.equals("vertical") || movementType.equals("horizontal"))
            return board.isPathClear(newMovement); 
        else 
            return false;
    }
}
