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
public class Horse extends Piece implements ChessPiece {
    
    public Horse(PieceColour colour) {
        this.initialisePiece(colour, null);
    }
    
    public Horse(PieceColour colour, ChessBoardSquare currentSquare) {
        this.initialisePiece(colour, currentSquare);
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
