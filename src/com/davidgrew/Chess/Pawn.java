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
public class Pawn extends ChessPiece {
    
    public Pawn(String colour) {
        this.chessPieceType = "Pawn";
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BP";
        }
        else {
            this.colour = "white";
            this.shortName = "WP";
        }
    }
    
    @Override
    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {  
        
        String movementType = newMovement.getMovementType();
        String movementDirection = newMovement.getMovementDirection().getDirection();
        int movementDistance = newMovement.getMovementDistance();
        
        if (movementType == "vertical" && movementDistance == 1) {
            if(colour.equals("white") && movementDirection == "up")
                return newMovement.getFutureSquare().isSquareEmpty;
            else if(colour.equals("black") && movementDirection == "down")
                return newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else if (movementType == "vertical" && movementDistance == 2) {
            if(colour.equals("white") && newMovement.getCurrentSquare().getYAxisLocation() == 1)
                return newMovement.getFutureSquare().isSquareEmpty;
            else if (colour.equals("white") && newMovement.getCurrentSquare().getYAxisLocation() == 1)
                return newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else if (movementType == "diagonal" && movementDistance == 1) {
            if (colour.equals("white") && (movementDirection == "leftup" || movementDirection == "rightup"))
                return !newMovement.getFutureSquare().isSquareEmpty;
            else if (colour.equals("black") && (movementDirection == "leftdown" || movementDirection == "rightdown"))
                return !newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else
            return false;
    }
}
