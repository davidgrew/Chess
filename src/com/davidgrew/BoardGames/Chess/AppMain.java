/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.BoardGames.Chess;

import java.util.Scanner;
import jdk.internal.org.objectweb.asm.commons.Method;

/**
 *
 * @author David
 */
public class AppMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print("\033[H\033[2J");
        
        ChessPlayer player1 = new ChessPlayer();
        ChessPlayer player2 = new ChessPlayer();
        
        for(int i = 1; i < 3; i++) {
            System.out.println("Player "+i+"'s name please");
            String playerName = new Scanner(System.in).next();
            if (i == 1){
                String playerOneColour;
                do {
                    System.out.println("Player One colour please - black or white");
                    playerOneColour = new Scanner(System.in).next();
                } while (!playerOneColour.equalsIgnoreCase("white") && !playerOneColour.equals("black"));
                player1.updatePlayerName(playerName);
                player1.updatePieceColour(playerOneColour);
            }
            else {
                player2.updatePlayerName(playerName);
                if (player1.getPieceColour().equalsIgnoreCase("white")) 
                    player2.updatePieceColour("black");
                else
                    player2.updatePieceColour("white");
            }
                
        }
        ChessGame game = new ChessGame(player1, player2);
                
        ChessBoard board = new ChessBoard();
        board.initialiseChessBoard();
        board.printChessBoard();
        
        do {
            System.out.println("\n"+game.getPlayersTurn().getPlayerName()+"'s turn\n");
            
            ChessBoardSquare currentSquare = null;
            ChessBoardSquare futureSquare = null;
            Boolean isSquareValid = false;
            
            for (int i = 0; i < 2; i++) {
                if (i == 0)
                    System.out.println("Select piece to move (e.g. C4)");
                else
                    System.out.println("Select square to move to (e.g. D4)");
                do {
                    String squareName = new Scanner(System.in).next();
                    isSquareValid = board.isSquareValid(squareName);
                    if (isSquareValid && i == 0)
                        currentSquare = board.getSquare(squareName);
                    else if (isSquareValid && i == 1)
                        futureSquare = board.getSquare(squareName);
                    else
                        System.out.println("not a valid square");
                } while (isSquareValid == false);
            }
            
            if(currentSquare == null || futureSquare == null)
                break;
            else {
                ChessMove currentMove = new ChessMove(board, currentSquare, futureSquare, game.getPlayersTurn());
                if (currentMove.isMoveValid()) {
                    currentMove.executeMove();
                    game.updatePlayersTurn();
                    currentMove.checkForWinningMove();
                    board.printChessBoard();
                }
                else {
                    System.out.println("move not valid");
                }
            }
            
        } while(game.getWinner() == null);        
    }
    
}
