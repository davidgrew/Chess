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
import com.davidgrew.BoardGames.Base.Board;

public class ChessBoard {
    public ChessBoardSquare[][] board;
    private char[] leftEdgeIndex = {'A','B','C','D','E','F','G','H'};
    private int[] bottomEdgeIndex = {1,2,3,4,5,6,7,8};      
    private static final int CHESS_BOARD_WIDTH = 8;
    
    public ChessBoard() {
        
        board = new ChessBoardSquare[CHESS_BOARD_WIDTH][CHESS_BOARD_WIDTH];
    }
    
    public void initialiseChessBoard() {
    
            for(int i = 0; i < CHESS_BOARD_WIDTH; i++) {
            for(int j = 0; j < CHESS_BOARD_WIDTH; j++) {
                this.board[i][j] = new ChessBoardSquare();
                this.board[i][j].initialiseSquare(i,j);
            }
        }
    }
    
    public void printChessBoard() {
        
        System.out.print("\033[H\033[2J");
        System.out.println("   |----|----|----|----|----|----|----|----|");
        for(int i = CHESS_BOARD_WIDTH-1; i >= 0; i--) {
            System.out.print(leftEdgeIndex[i]+"  ");
            for(int j = 0; j < CHESS_BOARD_WIDTH; j++) {
                if(this.board[i][j].isSquareEmpty == true)
                    System.out.print("|    ");
                else
                    System.out.print("| " + this.board[i][j].currentPiece.shortName + " ");
            }
            System.out.println("|");
            System.out.println("   |----|----|----|----|----|----|----|----|");
        }  
        System.out.print("   ");
        for(int k = 0; k < bottomEdgeIndex.length; k++) {
            System.out.print("  "+bottomEdgeIndex[k]+"  ");
        }
        System.out.println();
    }
    
    public Boolean isSquareValid(String squareName) {
        for (int i = 0; i < CHESS_BOARD_WIDTH; i++) {
            for (int j = 0; j < CHESS_BOARD_WIDTH; j++) {
                if(this.board[i][j].getSquareName().equalsIgnoreCase(squareName)) {
                    return true;
                }
            }
        }
        return false;
    }    
    
    public ChessBoardSquare getSquare(String squareName) {
        for (int i = 0; i < CHESS_BOARD_WIDTH; i++) {
            for (int j = 0; j < CHESS_BOARD_WIDTH; j++) {
                if(this.board[i][j].getSquareName().equalsIgnoreCase(squareName)) {
                    return this.board[i][j];
                }
            }
        }
        return null;
    }
}
