/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

import java.lang.reflect.Method;

/**
 *
 * @author David
 */
public class Castle extends ChessPiece {
    
    public Castle(String colour) {
        this.chessPieceType = "Castle";
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BC";
        }
        else {
            this.colour = "white";
            this.shortName = "WC";
        }
    }

    public Boolean isMoveValid(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, ChessPlayer currentPlayer) {
        
        if (!futureSquare.isSquareEmpty && futureSquare.currentPiece.colour.equals(currentPlayer.getPieceColour()))
            return false;         
        
        int distanceMovedXAxis = currentSquare.xAxisLocation - futureSquare.xAxisLocation;
        int distanceMovedYAxis = currentSquare.yAxisLocation - futureSquare.yAxisLocation;
                
        if (distanceMovedXAxis != 0 && distanceMovedYAxis == 0) {
            boolean positiveMovement = distanceMovedXAxis > 0;
            int xAxisStart = positiveMovement ? currentSquare.xAxisLocation+1 : futureSquare.xAxisLocation+1;
            int xAxisEnd = positiveMovement ? futureSquare.xAxisLocation : currentSquare.xAxisLocation;
            for (int i = xAxisStart; i < xAxisEnd; i++) {
                if (!board.board[currentSquare.yAxisLocation][i].isSquareEmpty)
                    return false;
            }
            return true;
        }
        else if (distanceMovedXAxis == 0 && distanceMovedYAxis != 0) {
            boolean positiveMovement = distanceMovedYAxis < 0;
            int yAxisStart = positiveMovement ? currentSquare.yAxisLocation+1 : futureSquare.yAxisLocation+1;
            int yAxisEnd = positiveMovement ? futureSquare.yAxisLocation : currentSquare.yAxisLocation;
            for (int i = yAxisStart; i < yAxisEnd; i++) {
                if (!board.board[i][currentSquare.xAxisLocation].isSquareEmpty)
                    return false;
            }
            return true;
        }
        else 
            return false;
    }
    

}
