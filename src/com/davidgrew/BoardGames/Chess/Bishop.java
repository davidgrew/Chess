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
public class Bishop extends ChessPiece {
    
    Bishop(String colour) {
        this.chessPieceType = "Bishop";
        if(colour.equals("black")) {
            this.colour = "black";
            this.shortName = "BB";
        }
        else {
            this.colour = "white";
            this.shortName = "WB";
        }
    }
}
