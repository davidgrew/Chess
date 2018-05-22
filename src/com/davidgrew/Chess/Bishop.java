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
    
    public Bishop(String colour) {
        this.chessPieceType = "Bishop";
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
    public Boolean isMoveValid(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, ChessPlayer currentPlayer) {
    
        Movement newMovement = new Movement(currentSquare, futureSquare);
        String movementType = newMovement.getMovementType();
        
        if (movementType.equals("diagonal"))
            return new Path().isPathClear(board, currentSquare, futureSquare, newMovement); 
        else 
            return false;
    }
}
