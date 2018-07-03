/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;

import java.lang.reflect.Constructor;

/**
 *
 * @author David
 */
public class ChessBoardSquare {
    private String squareName;
    private int xAxisLocation;
    private int yAxisLocation;
    public Boolean isSquareEmpty;
    public Piece currentPiece;
    
    public Piece initialiseSquare(int y, int x) {
        
        this.xAxisLocation = x;
        this.yAxisLocation = y;
        Character yAsChar = (char) (y+65);
        Character xAsChar = (char) (x+49);
        squareName = yAsChar.toString() + xAsChar.toString();
        
        if((y == 0 || y == 7) && (x == 0 || x == 7)) {
            if(y == 0)
                currentPiece = new Castle(PieceColour.WHITE, this);
            else
                currentPiece = new Castle(PieceColour.BLACK, this);
            isSquareEmpty = false;
        }
        else if((y == 0 || y == 7) && (x == 1 || x == 6)) {
            if(y == 0)
                currentPiece = new Horse(PieceColour.WHITE, this);
            else
                currentPiece = new Horse(PieceColour.BLACK, this);
            isSquareEmpty = false;
        }
        else if((y == 0 || y == 7) && (x == 2 || x == 5)) {
            if(y == 0)
                currentPiece = new Bishop(PieceColour.WHITE, this);
            else
                currentPiece = new Bishop(PieceColour.BLACK, this);
            isSquareEmpty = false;
        }
        else if((y == 0 || y == 7) && x == 3) {
            if(y == 0)
                currentPiece = new King(PieceColour.WHITE, this);
            else
                currentPiece = new Queen(PieceColour.BLACK, this);
            isSquareEmpty = false;
        }
        else if((y == 0 || y == 7) && x == 4) {
            if(y == 0)
                currentPiece = new Queen(PieceColour.WHITE, this);
            else
                currentPiece = new King(PieceColour.BLACK, this);
            isSquareEmpty = false;
        }
        else if (y == 1 || y == 6) {
            if(y == 1)
                currentPiece = new Pawn(PieceColour.WHITE, this);
            else
                currentPiece = new Pawn(PieceColour.BLACK, this);
            isSquareEmpty = false;
        }
        else {
            isSquareEmpty = true;
        }
        return this.currentPiece;
    }
    
    void initialiseSquare(int y, int x, String pieceType) {
        
        this.xAxisLocation = x;
        this.yAxisLocation = y;
        Character yAsChar = (char) (y+65);
        Character xAsChar = (char) (x+49);
        squareName = yAsChar.toString() + xAsChar.toString();
        
        if(x == 3 && y == 3){
            try {
                Class<?> pieceToTest = Class.forName("com.davidgrew.chess."+pieceType);
                Constructor pieceConstructor = pieceToTest.getConstructor(String.class, ChessBoardSquare.class);
                this.currentPiece = (Piece) pieceConstructor.newInstance("white", this);
                this.isSquareEmpty = false;
            } catch (Exception e) {}
        }
        else
            this.isSquareEmpty = true;
        
    }
    
    public String getSquareName() {
        return this.squareName;
    }
    
    public int getXAxisLocation() {
        return this.xAxisLocation;
    }
    
    public int getYAxisLocation() {
        return this.yAxisLocation;
    }
    
}
