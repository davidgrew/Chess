/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

import java.util.ArrayList;

/**
 *
 * @author davidgrew
 */
public class Check {
    
    private Boolean checkStatus;
    private ArrayList<Piece> piecesCausingCheck = new ArrayList<>();
    
    public Check() {
        this.checkStatus = false;
    }
    
    public Boolean getCheckStatus() {
        return this.checkStatus;
    }
    
    public void refreshCheckStatus() {
        
        if (this.checkStatus == true) {
            piecesCausingCheck.clear();
            this.checkStatus = false;
        }
    }
    
    public void addPieceCausingCheck(Piece newPiece) {
        if (this.checkStatus == false)
            this.checkStatus = true;
        piecesCausingCheck.add(newPiece);
    }
    
    public ArrayList<Piece> getPiecesCausingCheck() {
        return this.piecesCausingCheck;
    }
    
    
}
