/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author David
 */
public class King extends ChessPiece {
    
    public Check check = new Check();
    
    public King(String colour, ChessBoardSquare currentSquare) {
        this.chessPieceType = "King";
        this.currentSquare = currentSquare;
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BK";
        }
        else {
            this.colour = "white";
            this.shortName = "WK";
        }
        this.addUniqueName(this.shortName, currentSquare.getSquareName());
    }
    
//    @Override
//    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {
//    
//        return newMovement.getMovementDistance() == 1;
//    }
    
    public Boolean KingInCheck(ChessBoard board) {
        check.refreshCheckStatus();
        ArrayList<NearestPiece> nearestPieces = board.nearestPiecesAllVectors(currentSquare);
        for (NearestPiece piece: nearestPieces) {
            if (!piece.getPiece().getChessPieceColour().equals(this.colour)) {
                String directionType = piece.getDirection().getDirectionType();
                String direction = piece.getDirection().getDirection();
                String pieceType = piece.getPiece().getChessPieceType();
                int pieceDistance = piece.getDistance();

                if ((directionType.equals("horizontal") || directionType.equals("vertical")) && (pieceType.equals("Castle") || pieceType.equals("Queen") || (pieceType.equals("King") && pieceDistance == 1)))
                    check.addPieceCausingCheck(piece.getPiece());
                else if (directionType.equals("diagonal")) {
                    if (pieceType.equals("Queen") || pieceType.equals("Bishop") || (pieceType.equals("King") || pieceDistance == 1))
                        check.addPieceCausingCheck(piece.getPiece());
                    else if (pieceType.equals("Pawn") && pieceDistance == 1){
                        if (piece.getPiece().colour.equals("white") && (direction.equals("leftup") || direction.equals("rightup")))
                           check.addPieceCausingCheck(piece.getPiece());
                        else if (piece.getPiece().colour.equals("black") && (direction.equals("leftdown") || direction.equals("rightdown")))
                           check.addPieceCausingCheck(piece.getPiece());
                    }
                }              
            }
        }
        System.out.println(check.getCheckStatus());
        return check.getCheckStatus();
    }

    public Boolean KingInCheckmate(ChessBoard board, Map<String, ChessPiece> activePieces) {
        
        if (!this.KingInCheck(board))
            return false;
        
        //check if there are moves available to the king by moving to adjacent squares
        ArrayList<ChessBoardSquare> availableSquares = board.surroundingSquaresAllVectors(currentSquare);
        
        for (ChessBoardSquare nextSquare : availableSquares) {
            if (nextSquare.isSquareEmpty || !nextSquare.currentPiece.colour.equals(this.colour)) {
                MoveExecution move = new MoveExecution(this.currentSquare, nextSquare);
                move.execute();
                Boolean inCheck = this.KingInCheck(board);
                move.reverse();
                if (!inCheck)
                    return false;
            }
        }
        
        int numberOfPiecesCausingCheck = check.getPiecesCausingCheck().size();
        int counter = 0;
        ArrayList<ChessBoardSquare>[] squaresToCheck = new ArrayList[numberOfPiecesCausingCheck];
        Set<ChessBoardSquare> squaresToIntercept = new HashSet<>();
        
        for (ChessPiece piece : check.getPiecesCausingCheck()) {
            squaresToCheck[counter] = board.allSquaresBetweenTwoPoints(this.currentSquare, piece.getCurrentSquare());
        }
        
        if (numberOfPiecesCausingCheck > 1) {
            for (int i = 0, j = 1; j > squaresToCheck.length; i++, j++) {
                for (ChessBoardSquare element : squaresToCheck[i]) {
                    if (squaresToCheck[j].contains(element))
                        squaresToIntercept.add(element);
                }
            }
        }
        else
            squaresToIntercept.addAll(squaresToCheck[0]);
        
        for (ChessBoardSquare square : squaresToIntercept) {
            for (ChessPiece piece : activePieces.values()) {
                if (piece.isMoveValid(board, new Movement(piece.getCurrentSquare(), square))) 
                    return false;
            }
        }
        return true;
    }
}



