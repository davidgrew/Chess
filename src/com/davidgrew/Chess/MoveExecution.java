/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

import java.util.Map;

/**
 *
 * @author davidgrew
 */
public class MoveExecution {
    
    private final ChessBoardSquare initialSquare;
    private final ChessBoardSquare futureSquare;
    private final ChessPiece initialSquareOriginalPiece;
    private final ChessPiece futureSquareOriginalPiece;
    private final Map<String, ChessPiece> activePieces;
    
    public MoveExecution(ChessBoardSquare initialSquare, ChessBoardSquare futureSquare, Map<String, ChessPiece> activePieces) {
        this.initialSquare = initialSquare;
        this.futureSquare = futureSquare;
        this.initialSquareOriginalPiece = initialSquare.currentPiece;
        this.futureSquareOriginalPiece = futureSquare.currentPiece;
        this.activePieces = activePieces;
    }
    
    public MoveExecution(ChessBoardSquare initialSquare, ChessBoardSquare futureSquare) {
        this.initialSquare = initialSquare;
        this.futureSquare = futureSquare;
        this.initialSquareOriginalPiece = initialSquare.currentPiece;
        this.futureSquareOriginalPiece = futureSquare.currentPiece;
        this.activePieces = null;
    }
    
    public void execute() {
        
        initialSquareOriginalPiece.updateCurrentSquare(futureSquare);
        futureSquare.currentPiece = initialSquare.currentPiece;
        initialSquare.currentPiece = null;
        initialSquare.isSquareEmpty = true;
        futureSquare.isSquareEmpty = false;
        if(activePieces != null && futureSquareOriginalPiece != null)
            activePieces.remove(futureSquareOriginalPiece.getUniqueName());
    }
    
    public void reverse() {
        
        initialSquareOriginalPiece.updateCurrentSquare(initialSquare);
        initialSquare.currentPiece = initialSquareOriginalPiece;
        futureSquare.currentPiece = futureSquareOriginalPiece;
        initialSquare.isSquareEmpty = false;
        futureSquare.isSquareEmpty = futureSquareOriginalPiece == null;
        if (activePieces != null && futureSquareOriginalPiece != null)
            activePieces.put(futureSquareOriginalPiece.getUniqueName(), futureSquareOriginalPiece);
    }
}
