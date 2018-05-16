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
public class King extends ChessPiece {
    
    King(String colour) {
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
}
