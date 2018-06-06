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
public class Horse extends ChessPiece {
    
    public Horse(String colour, ChessBoardSquare currentSquare) {
        this.chessPieceType = "Horse";
        this.currentSquare = currentSquare;
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BH";
        }
        else {
            this.colour = "white";
            this.shortName = "WH";
        }
        this.addUniqueName(this.shortName, currentSquare.getSquareName());
    }
    
    @Override
    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {       
        
        int distanceMovedXAxis = newMovement.getCurrentSquare().getXAxisLocation() - newMovement.getFutureSquare().getXAxisLocation();       
        int distanceMovedYAxis = newMovement.getCurrentSquare().getYAxisLocation() - newMovement.getFutureSquare().getYAxisLocation();

        if ((distanceMovedYAxis == 1 || distanceMovedYAxis == -1) && (distanceMovedXAxis == 2 || distanceMovedXAxis == -2))
            return true;
        else return (distanceMovedYAxis == 2 || distanceMovedYAxis == -2) && (distanceMovedXAxis == 1 || distanceMovedXAxis == -1);
    }
}
