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
public class Pawn extends ChessPiece {
    
    Pawn(String colour) {
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
    public Boolean isMoveValid(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, ChessPlayer currentPlayer) {
        
        if (!futureSquare.isSquareEmpty && futureSquare.currentPiece.colour.equals(currentPlayer.getPieceColour()))
            return false;     
        
        int distanceMovedXAxis = currentSquare.xAxisLocation - futureSquare.xAxisLocation;
        int distanceMovedYAxis = currentSquare.yAxisLocation - futureSquare.yAxisLocation;
        int unsigneddistanceMovedYAxis = distanceMovedYAxis < 0 ? -distanceMovedYAxis : distanceMovedYAxis;
   
        if (distanceMovedXAxis == 0 && unsigneddistanceMovedYAxis == 1) {
            return futureSquare.isSquareEmpty; 
        }
        else if (distanceMovedXAxis == 1 && unsigneddistanceMovedYAxis == 1) {
            return !futureSquare.isSquareEmpty;
        }
        else if (unsigneddistanceMovedYAxis == 2 && distanceMovedXAxis == 0 && (currentSquare.yAxisLocation == 1 || currentSquare.yAxisLocation == 6)) {
            if (distanceMovedYAxis < 0)
                return board.board[currentSquare.yAxisLocation+1][currentSquare.xAxisLocation].isSquareEmpty;
            else
                return board.board[futureSquare.yAxisLocation+1][currentSquare.xAxisLocation].isSquareEmpty;
        }
        else {
            return false;
        }
    }
}
