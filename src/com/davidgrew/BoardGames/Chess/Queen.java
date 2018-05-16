/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.BoardGames.Chess;

/**
 *
 * @author David
 */
public class Queen extends ChessPiece {
    
    Queen(String colour) {
        this.chessPieceType = "Queen";
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BQ";
        }
        else {
            this.colour = "white";
            this.shortName = "WQ";
        }
    }
}
