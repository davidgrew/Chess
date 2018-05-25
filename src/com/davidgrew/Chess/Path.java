/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

/**
 *
 * @author davidgrew
 */
public class Path {
        
    public boolean isPathClear(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, Movement movement) {
        
        int xAxisCounter = currentSquare.getXAxisLocation();
        int yAxisCounter = currentSquare.getYAxisLocation();
        boolean endReached = false;
          
        while (!endReached) {
            switch (movement.getMovementDirection()) {
                case "left":
                    xAxisCounter--;
                    break;
                case "leftdown":
                    xAxisCounter--;
                    yAxisCounter--;
                    break;
                case "leftup":
                    xAxisCounter--;
                    yAxisCounter++;
                    break;
                case "down":
                    yAxisCounter--;
                    break;
                case "up":
                    yAxisCounter++;
                    break;
                case "right":
                    xAxisCounter++;
                    break;
                case "rightdown":
                    xAxisCounter++;
                    yAxisCounter--;
                    break;
                case "rightup":
                    xAxisCounter++;
                    yAxisCounter++;
                    break;
            }
            if (xAxisCounter == futureSquare.getXAxisLocation() && yAxisCounter == futureSquare.getYAxisLocation())
                endReached = true;
            else if (!board.board[yAxisCounter][xAxisCounter].isSquareEmpty)
                return false;
        }
        return true;
    }
 
    public ChessPiece nextPiece(ChessBoard board, ChessBoardSquare rootSquare, Direction direction) {
        int xAxisCounter = rootSquare.getXAxisLocation();
        int yAxisCounter = rootSquare.getYAxisLocation();
        int xAxisMax = direction.getMaxXAxisLocation();
        int yAxisMax = direction.getMaxYAxisLocation();
        
        if(xAxisCounter == xAxisMax || yAxisCounter == yAxisMax)
            return null;
        
        boolean edgeReached = false;
        
        while (!edgeReached) {
            switch (direction.getDirection()) {
                case "left":
                    xAxisCounter--;
                    break;
                case "leftdown":
                    xAxisCounter--;
                    yAxisCounter--;
                    break;
                case "leftup":
                    xAxisCounter--;
                    yAxisCounter++;
                    break;
                case "down":
                    yAxisCounter--;
                    break;
                case "up":
                    yAxisCounter++;
                    break;
                case "right":
                    xAxisCounter++;
                    break;
                case "rightdown":
                    xAxisCounter++;
                    yAxisCounter--;
                    break;
                case "rightup":
                    xAxisCounter++;
                    yAxisCounter++;
                    break;
            }
            if(!board.board[yAxisCounter][xAxisCounter].isSquareEmpty)
                return board.board[yAxisCounter][xAxisCounter].currentPiece;
            else if (xAxisCounter == xAxisMax || yAxisCounter == yAxisMax)
                return null;
        }
        return null;
    }
}

//        int distanceMovedXAxis = currentSquare.xAxisLocation - futureSquare.xAxisLocation;
//        int distanceMovedYAxis = currentSquare.yAxisLocation - futureSquare.yAxisLocation;
//        int unsignedDistanceMovedXAxis = distanceMovedXAxis < 0 ? distanceMovedXAxis * -1 : distanceMovedXAxis;
//        int unsignedDistanceMovedYAxis = distanceMovedYAxis < 0 ? distanceMovedYAxis * -1 : distanceMovedYAxis;
//        
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

    


