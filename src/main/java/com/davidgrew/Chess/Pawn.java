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
public class Pawn extends Piece {
    
    public Pawn(String colour, ChessBoardSquare currentSquare) {
        this.chessPieceType = "Pawn";
        this.currentSquare = currentSquare;
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BP";
        }
        else {
            this.colour = "white";
            this.shortName = "WP";
        }
        this.addUniqueName(this.shortName, currentSquare.getSquareName());
    }
    
    @Override
    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {  
        
        String movementType = newMovement.getMovementType();
        String movementDirection = newMovement.getMovementDirection().getDirection();
        int movementDistance = newMovement.getMovementDistance();
        
        if (movementType.equals("vertical") && movementDistance == 1) {
            if(colour.equals("white") && movementDirection.equals("up"))
                return newMovement.getFutureSquare().isSquareEmpty;
            else if(colour.equals("black") && movementDirection.equals("down"))
                return newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else if (movementType.equals("vertical") && movementDistance == 2) {
            if(colour.equals("white") && newMovement.getCurrentSquare().getYAxisLocation() == 1)
                return newMovement.getFutureSquare().isSquareEmpty;
            else if (colour.equals("black") && newMovement.getCurrentSquare().getYAxisLocation() == 6)
                return newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else if (movementType.equals("diagonal") && movementDistance == 1) {
            if (colour.equals("white") && (movementDirection.equals("leftup") || movementDirection.equals("rightup")))
                return !newMovement.getFutureSquare().isSquareEmpty;
            else if (colour.equals("black") && (movementDirection.equals("leftdown") || movementDirection.equals("rightdown")))
                return !newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else
            return false;
    }
}
