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
public class King extends ChessPiece {
    
    public King(String colour) {
        this.chessPieceType = "King";
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BK";
        }
        else {
            this.colour = "white";
            this.shortName = "WK";
        }
    }
    
    public Boolean isMoveValid(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, ChessPlayer currentPlayer) {

        if (!futureSquare.isSquareEmpty && futureSquare.currentPiece.colour.equals(currentPlayer.getPieceColour()))
            return false; 
    
        int distanceMovedXAxis = currentSquare.xAxisLocation - futureSquare.xAxisLocation;
        int distanceMovedYAxis = currentSquare.yAxisLocation - futureSquare.yAxisLocation;
        int unsignedDistanceMovedXAxis = distanceMovedXAxis < 0 ? distanceMovedXAxis * -1 : distanceMovedXAxis;
        int unsignedDistanceMovedYAxis = distanceMovedYAxis < 0 ? distanceMovedYAxis * -1 : distanceMovedYAxis;

        return (unsignedDistanceMovedXAxis < 2 && unsignedDistanceMovedYAxis < 2 && (unsignedDistanceMovedXAxis + unsignedDistanceMovedYAxis) > 0);  
    }
}
