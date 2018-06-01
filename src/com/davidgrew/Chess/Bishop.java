/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

/**
 *
 * @author David
 */
public class Bishop extends ChessPiece {
    
    public Bishop(String colour, ChessBoardSquare currentSquare) {
        this.chessPieceType = "Bishop";
        this.currentSquare = currentSquare;
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BB";
        }
        else {
            this.colour = "white";
            this.shortName = "WB";
        }
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
