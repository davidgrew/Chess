/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.BoardGames.Chess;

/**
 *
 * @author David
 */
public class Horse extends ChessPiece {
    
    Horse(String colour) {
        this.chessPieceType = "Horse";
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BH";
        }
        else {
            this.colour = "white";
            this.shortName = "WH";
        }
    }
    
    @Override
    public Boolean isMoveValid(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, ChessPlayer currentPlayer) {
        
        if (!futureSquare.isSquareEmpty && futureSquare.currentPiece.colour.equals(currentPlayer.getPieceColour()))
            return false;         
        
        int distanceMovedXAxis = currentSquare.xAxisLocation - futureSquare.xAxisLocation;       
        int distanceMovedYAxis = currentSquare.yAxisLocation - futureSquare.yAxisLocation;

        if ((distanceMovedYAxis == 1 || distanceMovedYAxis == -1) && (distanceMovedXAxis == 2 || distanceMovedXAxis == -2))
            return true;
        else return (distanceMovedYAxis == 2 || distanceMovedYAxis == -2) && (distanceMovedXAxis == 1 || distanceMovedXAxis == -1);
    }
}
