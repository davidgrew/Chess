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
public class ChessBoardSquare {
    private String squareName;
    private int xAxisLocation;
    private int yAxisLocation;
    public Boolean isSquareEmpty;
    public ChessPiece currentPiece;
    
    public ChessPiece initialiseSquare(int y, int x) {
        
        this.xAxisLocation = x;
        this.yAxisLocation = y;
        Character yAsChar = (char) (y+65);
        Character xAsChar = (char) (x+49);
        squareName = yAsChar.toString() + xAsChar.toString();
        
        if((y == 0 || y == 7) && (x == 0 || x == 7)) {
            if(y == 0)
                currentPiece = new Castle("white", this);
            else
                currentPiece = new Castle("black", this);
            isSquareEmpty = false;
        }
        else if((y == 0 || y == 7) && (x == 1 || x == 6)) {
            if(y == 0)
                currentPiece = new Horse("white", this);
            else
                currentPiece = new Horse("black", this);
            isSquareEmpty = false;
        }
        else if((y == 0 || y == 7) && (x == 2 || x == 5)) {
            if(y == 0)
                currentPiece = new Bishop("white", this);
            else
                currentPiece = new Bishop("black", this);
            isSquareEmpty = false;
        }
        else if((y == 0 || y == 7) && x == 3) {
            if(y == 0)
                currentPiece = new King("white", this);
            else
                currentPiece = new Queen("black", this);
            isSquareEmpty = false;
        }
        else if((y == 0 || y == 7) && x == 4) {
            if(y == 0)
                currentPiece = new Queen("white", this);
            else
                currentPiece = new King("black", this);
            isSquareEmpty = false;
        }
        else if (y == 1 || y == 6) {
            if(y == 1)
                currentPiece = new Pawn("white", this);
            else
                currentPiece = new Pawn("black", this);
            isSquareEmpty = false;
        }
        else {
            isSquareEmpty = true;
        }
        return this.currentPiece;
    }
    
    void initialiseSquare(int y, int x, ChessPiece piece) {
        
        this.xAxisLocation = x;
        this.yAxisLocation = y;
        Character yAsChar = (char) (y+65);
        Character xAsChar = (char) (x+49);
        squareName = yAsChar.toString() + xAsChar.toString();
        
        if(x == 3 && y == 3){
            this.currentPiece = piece;
            this.isSquareEmpty = false;
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
