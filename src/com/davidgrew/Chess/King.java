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
    
//    @Override
//    public Boolean isMoveValid(ChessBoard board, ChessBoardSquare currentSquare, ChessBoardSquare futureSquare, ChessPlayer currentPlayer) {
//    
//        if(new Movement(currentSquare, futureSquare).getMovementDistance() == 1) {
//            
//        }  
//        else
//            return false;
//    }
//    
//    public Boolean isKingInCheck(ChessBoard board, ChessBoardSquare rootSquare) {
//        ChessPiece nextPieceUp = new Path().nextPiece(board, rootSquare, new Direction("up"));
//        if (!nextPieceUp.getChessPieceColour().equals(this.colour) && nextPieceUp.getChessPieceType()
//    }
}
