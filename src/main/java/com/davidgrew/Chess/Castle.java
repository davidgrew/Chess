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
public class Castle extends Piece {
    
    public Castle(String colour, ChessBoardSquare currentSquare) {
        this.chessPieceType = "Castle";
        this.currentSquare = currentSquare;
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BC";
        }
        else {
            this.colour = "white";
            this.shortName = "WC";
        }
        this.addUniqueName(this.shortName, currentSquare.getSquareName());
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
