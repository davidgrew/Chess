/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author davidgrew
 */
public class Player {
    
    private String name;
    private PieceColour colour;
    private Map<String, Piece> activePieces = new HashMap<>();
    
    public Player() {
        name = null;
        colour = PieceColour.WHITE;
    }
    
    public Player(String name) {
        this.name = name;
        colour = PieceColour.WHITE;
    }
    
    public Player(String name, PieceColour colour) {
        this.name = name;
        this.colour = colour;
    }
    
    public String getPlayerName() {
        return name;
    }
    
    public void updatePlayerName(String name) {
        this.name = name;
    }
    
    public PieceColour getPieceColour() {
        return this.colour;
    }
    
    public void updatePieceColour(PieceColour colour) {
        this.colour = colour;
    }
    
    public Map<String, Piece> getActivePieces() {
        return this.activePieces;
    }
}
