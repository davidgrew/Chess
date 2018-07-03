/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;


/**
 *
 * @author David
 */
public class Piece {
    protected String chessPieceType;
    protected String shortName;
    protected String uniqueName;
    protected PieceColour colour;
    protected ChessBoardSquare currentSquare;

    public Boolean isMoveValid(ChessBoard board, Movement newMovement) {
        return false;
    }
    
    public String getChessPieceType() {
        return this.chessPieceType;
    }
    
    public PieceColour getChessPieceColour() {
        return this.colour;
    }
    
    public ChessBoardSquare getCurrentSquare() {
        return this.currentSquare;
    }
    
    public void updateCurrentSquare(ChessBoardSquare newSquare) {
        this.currentSquare = newSquare;
    }
    
    public String getShortName() {
        return this.shortName;
    }
    
    public String getUniqueName() {
        return this.uniqueName;
    }
    
    protected final void initialisePiece(PieceColour colour, ChessBoardSquare currentSquare) {
        this.chessPieceType = this.getClass().getSimpleName();
        this.colour = colour;
        String colourFirstLetter = this.colour == PieceColour.WHITE ? "W" : "B";
        this.shortName = colourFirstLetter + chessPieceType.substring(0, 1);
        this.currentSquare = currentSquare;
        if (currentSquare != null)
            this.uniqueName = shortName + currentSquare.getSquareName();
    }

}

