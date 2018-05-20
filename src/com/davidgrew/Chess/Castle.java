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
        
//        if ((distanceMovedXAxis != 0 && distanceMovedYAxis == 0) || (distanceMovedXAxis == 0 && distanceMovedYAxis != 0)) {
//            String whichAxis;
//            if (distanceMovedXAxis == 0)
//                whichAxis = "getYAxisLocation";
//            else
//                whichAxis = "getXAxisLocation";
//            try {
//                Class noparams[] = {};
//                Class cls = Class.forName("com.davidgrew.BoardGames.Chess.ChessBoardSquare");
//                Method newMethod = cls.getMethod("getYAxisLocation", noparams);
//                int currentSquareLocation = (int) newMethod.invoke(currentSquare, (Object) null);
//                int futureSquareLocation = (int) newMethod.invoke(futureSquare, (Object) null);
//                int counter = currentSquareLocation;
//                while (counter != futureSquareLocation) {
//                    if (distanceMovedXAxis > 0 && !board.board[currentSquare.getYAxisLocation()][counter].isSquareEmpty)
//                        return false;
//                    else if (!board.board[counter][currentSquare.getXAxisLocation()].isSquareEmpty)
//                        return false;
//                    else
//                        if (currentSquareLocation > futureSquareLocation)
//                            counter++;
//                        else
//                            counter--;
//                }
//                return true;
//            } catch (Exception e) { 
//                return false;
//            }            
//        }
//        else
//            return false;

        
        
        if (distanceMovedXAxis != 0 && distanceMovedYAxis == 0) {
            int xAxisStart;
            int xAxisEnd;
            if (distanceMovedXAxis > 0) {
                xAxisStart = currentSquare.xAxisLocation+1;
                xAxisEnd = futureSquare.xAxisLocation;
            }
            else {
                xAxisStart = futureSquare.xAxisLocation+1;
                xAxisEnd = currentSquare.xAxisLocation;
            }
            for (int i = xAxisStart; i < xAxisEnd; i++) {
                if (!board.board[currentSquare.yAxisLocation][i].isSquareEmpty)
                    return false;
            }
            return true;
        }
        else if (distanceMovedXAxis == 0 && distanceMovedYAxis != 0) {
            int yAxisStart;
            int yAxisEnd;
            if (distanceMovedYAxis < 0) {
                yAxisStart = currentSquare.yAxisLocation+1;
                yAxisEnd = futureSquare.yAxisLocation;
            }
            else {
                String s = "yAxisLocation";
                yAxisStart = futureSquare.yAxisLocation+1;
                yAxisEnd = currentSquare.yAxisLocation;
            }
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
