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
public class NearestPiece {
    
    private ChessPiece piece;
    private int distance;
    private Direction direction;
    
    public NearestPiece(ChessPiece piece, int distance, Direction direction) {
        this.piece = piece;
        this.distance = distance;
        this.direction = direction;
    }
    
    public ChessPiece getPiece() {
        return this.piece;
    }
    
    public int getDistance() {
        return this.distance;
    }
    
    public Direction getDirection() {
        return this.direction;
    }
}
