/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author davidgrew
 */
public class Player {
    
    private String name;
    private Boolean pieceColourIsWhite;
    private Map<String, Piece> activePieces = new HashMap<>();
    
    public Player() {
        name = null;
        pieceColourIsWhite = true;
    }
    
    public Player(String name) {
        this.name = name;
        this.pieceColourIsWhite = true;
    }
    
    public Player(String name, String colour) {
        this.name = name;
        if (colour.equals("white"))
            pieceColourIsWhite = true;
        else
            pieceColourIsWhite = false;
    }
    
    public String getPlayerName() {
        return name;
    }
    
    public void updatePlayerName(String name) {
        this.name = name;
    }
    
    public String getPieceColour() {
        if (this.pieceColourIsWhite)
            return "white";
        else
            return "black"; 
    }
    
    public void updatePieceColour(String pieceColour) {
        if (pieceColour.equalsIgnoreCase("white"))
            this.pieceColourIsWhite = true;
        else
            this.pieceColourIsWhite = false;
    }
    
    public Map<String, Piece> getActivePieces() {
        return this.activePieces;
    }
}
