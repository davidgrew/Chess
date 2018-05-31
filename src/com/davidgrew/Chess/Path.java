/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author davidgrew
 */
public class Path {
        
    public boolean isPathClear(ChessBoard board, Movement movement) {
        
        Map<String, Integer> axisCounters = new HashMap<>();
        axisCounters.put("x", movement.getCurrentSquare().getXAxisLocation());
        axisCounters.put("y", movement.getCurrentSquare().getYAxisLocation());
        boolean endReached = false;
          
        while (!endReached) {
            
        axisCounters = Path.incrementAxisCounters(movement.getMovementDirection(), axisCounters);
           
            if (axisCounters.get("x") == movement.getFutureSquare().getXAxisLocation() && axisCounters.get("y") == movement.getFutureSquare().getYAxisLocation())
                endReached = true;
            else if (!board.board[axisCounters.get("y")][axisCounters.get("x")].isSquareEmpty)
                return false;
        }
        return true;
    }
 
    public ChessPiece nextPiece(ChessBoard board, ChessBoardSquare rootSquare, Direction direction) {
        
        Map<String, Integer> axisCounters = new HashMap<>();
        axisCounters.put("x", rootSquare.getXAxisLocation());
        axisCounters.put("y", rootSquare.getYAxisLocation());
        int xAxisMax = direction.getMaxXAxisLocation();
        int yAxisMax = direction.getMaxYAxisLocation();
        
        if(axisCounters.get("x") == xAxisMax || axisCounters.get("y") == yAxisMax)
            return null;
        
        boolean edgeReached = false;
        
        while (!edgeReached) {
            
            axisCounters = Path.incrementAxisCounters(direction, axisCounters);
            
            if(!board.board[axisCounters.get("y")][axisCounters.get("x")].isSquareEmpty)
                return board.board[axisCounters.get("y")][axisCounters.get("x")].currentPiece;
            else if (axisCounters.get("y") == xAxisMax || axisCounters.get("x") == yAxisMax)
                return null;
        }
        return null;
    }
    
    private static Map<String, Integer> incrementAxisCounters(Direction direction, Map<String, Integer> axisCounters) {
        
        switch (direction.getDirection()) {
                case "left":
                    axisCounters.put("x", (axisCounters.get("x") - 1));
                    break;
                case "leftdown":
                    axisCounters.put("x", (axisCounters.get("x") - 1));
                    axisCounters.put("y", (axisCounters.get("y") - 1));
                    break;
                case "leftup":
                    axisCounters.put("x", (axisCounters.get("x") - 1));
                    axisCounters.put("y", (axisCounters.get("y") + 1));
                    break;
                case "down":
                    axisCounters.put("y", (axisCounters.get("y") - 1));
                    break;
                case "up":
                    axisCounters.put("y", (axisCounters.get("y") + 1));
                    break;
                case "right":
                    axisCounters.put("x", (axisCounters.get("x") + 1));
                    break;
                case "rightdown":
                    axisCounters.put("x", (axisCounters.get("x") + 1));
                    axisCounters.put("y", (axisCounters.get("y") - 1));
                    break;
                case "rightup":
                    axisCounters.put("x", (axisCounters.get("x") + 1));
                    axisCounters.put("y", (axisCounters.get("y") + 1));
                    break;
        }
        return axisCounters;
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

    


