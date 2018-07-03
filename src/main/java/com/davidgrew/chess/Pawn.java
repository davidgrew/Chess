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
public class Pawn extends Piece {
    
    public Pawn(PieceColour colour) {
        this.initialisePiece(colour, null);
    }
    
    public Pawn(PieceColour colour, ChessBoardSquare currentSquare) {
        this.initialisePiece(colour, currentSquare);
    }
    
    @Override
    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {  
        
        String movementType = newMovement.getMovementType();
        String movementDirection = newMovement.getMovementDirection().getDirection();
        int movementDistance = newMovement.getMovementDistance();
        
        if (movementType.equals("vertical") && movementDistance == 1) {
            if(colour == PieceColour.WHITE && movementDirection.equals("up"))
                return newMovement.getFutureSquare().isSquareEmpty;
            else if(colour == PieceColour.BLACK && movementDirection.equals("down"))
                return newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else if (movementType.equals("vertical") && movementDistance == 2) {
            if(this.colour == PieceColour.WHITE && newMovement.getCurrentSquare().getYAxisLocation() == 1)
                return newMovement.getFutureSquare().isSquareEmpty;
            else if (colour == PieceColour.BLACK && newMovement.getCurrentSquare().getYAxisLocation() == 6)
                return newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else if (movementType.equals("diagonal") && movementDistance == 1) {
            if (colour == PieceColour.WHITE && (movementDirection.equals("leftup") || movementDirection.equals("rightup")))
                return !newMovement.getFutureSquare().isSquareEmpty;
            else if (colour == PieceColour.BLACK && (movementDirection.equals("leftdown") || movementDirection.equals("rightdown")))
                return !newMovement.getFutureSquare().isSquareEmpty;
            else
                return false;
        }
        else
            return false;
    }
}
