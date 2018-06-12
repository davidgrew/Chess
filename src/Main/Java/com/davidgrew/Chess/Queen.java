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
public class Queen extends Piece {
    
    public Queen(String colour, ChessBoardSquare currentSquare) {
        this.chessPieceType = "Queen";
        this.currentSquare = currentSquare;
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BQ";
        }
        else {
            this.colour = "white";
            this.shortName = "WQ";
        }
        this.addUniqueName(this.shortName, currentSquare.getSquareName());
    }
    
    @Override
    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {
    
        return acceptableMovement(newMovement) && board.isPathClear(newMovement);
    }

    private static Boolean acceptableMovement(Movement newMovement) {
        
        String movementType = newMovement.getMovementType();
        return (movementType.equals("diagonal") || movementType.equals("horizontal") || movementType.equals("vertical"));
    }

}
    
        
//        int distanceMovedXAxis = currentSquare.xAxisLocation - futureSquare.xAxisLocation;
//        int distanceMovedYAxis = currentSquare.yAxisLocation - futureSquare.yAxisLocation;
//        int unsignedDistanceMovedXAxis = distanceMovedXAxis < 0 ? distanceMovedXAxis * -1 : distanceMovedXAxis;
//        int unsignedDistanceMovedYAxis = distanceMovedYAxis < 0 ? distanceMovedYAxis * -1 : distanceMovedYAxis;    
        
//        if (unsignedDistanceMovedXAxis == unsignedDistanceMovedYAxis) {
//            int yAxisCounter = distanceMovedYAxis < 0 ? currentSquare.yAxisLocation+1 : currentSquare.yAxisLocation-1;
//            int xAxisCounter = distanceMovedXAxis < 0 ? currentSquare.xAxisLocation+1 : currentSquare.xAxisLocation-1;
//            for (int i = 1; i < unsignedDistanceMovedXAxis; i++) {
//                if (!board.board[yAxisCounter][xAxisCounter].isSquareEmpty)
//                    return false;
//            }
//            return true;
//        }
//        else if (distanceMovedXAxis != 0 && distanceMovedYAxis == 0) {
//            boolean positiveMovement = distanceMovedXAxis > 0;
//            int xAxisStart = positiveMovement ? currentSquare.xAxisLocation+1 : futureSquare.xAxisLocation+1;
//            int xAxisEnd = positiveMovement ? futureSquare.xAxisLocation : currentSquare.xAxisLocation;
//            for (int i = xAxisStart; i < xAxisEnd; i++) {
//                if (!board.board[currentSquare.yAxisLocation][i].isSquareEmpty)
//                    return false;
//            }
//            return true;
//        }
//        else if (distanceMovedXAxis == 0 && distanceMovedYAxis != 0) {
//            boolean positiveMovement = distanceMovedYAxis < 0;
//            int yAxisStart = positiveMovement ? currentSquare.yAxisLocation+1 : futureSquare.yAxisLocation+1;
//            int yAxisEnd = positiveMovement ? futureSquare.yAxisLocation : currentSquare.yAxisLocation;
//            for (int i = yAxisStart; i < yAxisEnd; i++) {
//                if (!board.board[i][currentSquare.xAxisLocation].isSquareEmpty)
//                    return false;
//            }
//            return true;
//        }
//        else
//            return false;
//    }

