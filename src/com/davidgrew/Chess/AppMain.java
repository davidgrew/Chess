/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

import java.util.Scanner;

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

        Player player1 = new AppMain().getPlayerFromUser(1);
        Player player2 = new AppMain().getPlayerFromUser(2);
        Boolean playerOneWhite = new AppMain().getPieceColourFromUser().equalsIgnoreCase("white");
        player1.updatePieceColour(playerOneWhite ? "white" : "black");
        player2.updatePieceColour(playerOneWhite ? "black" : "white");

        Game game = new Game(player1, player2);
        
        ChessBoard board = new ChessBoard();
        board.initialiseChessBoard(player1, player2);
        board.printChessBoard();

        do {
            Player currentPlayer = game.getPlayersTurn();
            System.out.println("\n"+game.getPlayersTurn().getPlayerName()+"'s turn\n");

            ChessBoardSquare currentSquare = new AppMain().getSquareFromUser(board, "Select piece to move (e.g. C4)");
            ChessBoardSquare futureSquare = new AppMain().getSquareFromUser(board, "Select square to move to (e.g. D4)");

            if(currentSquare == null || futureSquare == null)
                break;
            else {
                Player oppositionPlayer = currentPlayer == player1 ? player2 : player1;
                Move currentMove = new Move(board, currentSquare, futureSquare, currentPlayer, oppositionPlayer);
                if (currentMove.executeMove()) {
                    if (currentMove.winningMove()) {
                        game.updateWinner();
                    }
                    game.updatePlayersTurn();
                    board.printChessBoard();
                }
                else {
                    System.out.println("move not valid");
                }
            }
        } while(game.getWinner() == null);  
        
        System.out.println(game.getWinner().getPlayerName() + " wins!");
    }

    private Player getPlayerFromUser(int playerNumber) {
        
        System.out.println("Player "+playerNumber+"'s name please");
        String playerName = new Scanner(System.in).next();
        return new Player(playerName);
    }
    
    private String getPieceColourFromUser() {
        String playerOneColour;
            do {
                System.out.println("Player One colour please - black or white");
                playerOneColour = new Scanner(System.in).next();
            } while (!playerOneColour.equalsIgnoreCase("white") && !playerOneColour.equals("black"));
        return playerOneColour;
    }
    
    private ChessBoardSquare getSquareFromUser(ChessBoard board, String textToPrint) {
        System.out.println(textToPrint);
        Boolean validSquare;
        
        do {
            String squareName = new Scanner(System.in).next();
            validSquare = board.isSquareValid(squareName);
            if (validSquare)
                return board.getSquare(squareName);
            else
                System.out.println("not a valid square");
        } while (!validSquare);
        
        return null;
    }
    
}
