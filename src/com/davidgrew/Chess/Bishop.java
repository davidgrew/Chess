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
    
    public Boolean isMoveValid(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, ChessPlayer currentPlayer) {
    
        if (!futureSquare.isSquareEmpty && futureSquare.currentPiece.colour.equals(currentPlayer.getPieceColour()))
            return false;  
        
        int distanceMovedXAxis = currentSquare.xAxisLocation - futureSquare.xAxisLocation;
        int distanceMovedYAxis = currentSquare.yAxisLocation - futureSquare.yAxisLocation;
        int unsignedDistanceMovedXAxis = distanceMovedXAxis < 0 ? distanceMovedXAxis * -1 : distanceMovedXAxis;
        int unsignedDistanceMovedYAxis = distanceMovedYAxis < 0 ? distanceMovedYAxis * -1 : distanceMovedYAxis;
        
        if (unsignedDistanceMovedXAxis == unsignedDistanceMovedYAxis) {
            int yAxisCounter = distanceMovedYAxis < 0 ? currentSquare.yAxisLocation+1 : currentSquare.yAxisLocation-1;
            int xAxisCounter = distanceMovedXAxis < 0 ? currentSquare.xAxisLocation+1 : currentSquare.xAxisLocation-1;;
            for (int i = 0; i <unsignedDistanceMovedXAxis; i++) {
                if (!board.board[yAxisCounter][xAxisCounter].isSquareEmpty)
                    return false;
            }
            return true;
        }
        else 
            return false;
    }
}
