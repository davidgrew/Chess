/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David
 */

public class ChessBoard {
    public ChessBoardSquare[][] board;
    private char[] leftEdgeIndex = {'A','B','C','D','E','F','G','H'};
    private int[] bottomEdgeIndex = {1,2,3,4,5,6,7,8};      
    public static final int CHESS_BOARD_WIDTH = 8;
    public static final String[] POSSIBLE_DIRECTIONS = new String[] {"left", "leftdown", "leftup", "up", "down", "right", "rightup", "rightdown"} ;
    
    public ChessBoard() {
        
        board = new ChessBoardSquare[CHESS_BOARD_WIDTH][CHESS_BOARD_WIDTH];
    }
    
    public void initialiseChessBoard(ChessPlayer player1, ChessPlayer player2) {
            
            String player1Colour = player1.getPieceColour();
            
            for(int i = 0; i < CHESS_BOARD_WIDTH; i++) {
            for(int j = 0; j < CHESS_BOARD_WIDTH; j++) {
                this.board[i][j] = new ChessBoardSquare();
                ChessPiece temp = this.board[i][j].initialiseSquare(i,j);
                if (temp != null)  {
                    if (temp.getChessPieceColour().equals(player1Colour))
                        player1.getActivePieces().put(temp.getUniqueName(), temp);
                    else
                        player2.getActivePieces().put(temp.getUniqueName(), temp);
                }
            }
        }
    }
    
    public void initialiseChessBoard(ChessPiece piece) {
    
            for(int i = 0; i < CHESS_BOARD_WIDTH; i++) {
            for(int j = 0; j < CHESS_BOARD_WIDTH; j++) {
                this.board[i][j] = new ChessBoardSquare();
                this.board[i][j].initialiseSquare(i,j,piece);
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
    
    public boolean isPathClear(Movement movement) {
        
        Map<String, Integer> axisCounters = new HashMap<>();
        axisCounters.put("x", movement.getCurrentSquare().getXAxisLocation());
        axisCounters.put("y", movement.getCurrentSquare().getYAxisLocation());
        boolean endReached = false;
          
        while (!endReached) {
            
        axisCounters = ChessBoard.incrementAxisCounters(movement.getMovementDirection(), axisCounters);
           
            if (axisCounters.get("x") == movement.getFutureSquare().getXAxisLocation() && axisCounters.get("y") == movement.getFutureSquare().getYAxisLocation())
                endReached = true;
            else if (!board[axisCounters.get("y")][axisCounters.get("x")].isSquareEmpty)
                return false;
        }
        return true;
    }
    
//    public ArrayList<NearestPiece> nearestPiecesAllVectors(ChessBoardSquare rootSquare) {
//        
//        ArrayList<NearestPiece> nearestPieceList = new ArrayList<>();
//        int arrayCounter = 0;
//        
//        for (String directions: POSSIBLE_DIRECTIONS) {
//            Direction nextDirection = new Direction(POSSIBLE_DIRECTIONS[arrayCounter]);
//            NearestPiece temp = this.nearestPieceSingleVector(rootSquare, nextDirection);
//            if (temp != null)   
//                nearestPieceList.add(temp);
//            arrayCounter++;
//        }
//        return nearestPieceList;
//    }
//    
//    private NearestPiece nearestPieceSingleVector(ChessBoardSquare rootSquare, Direction direction) {
//        
//        Map<String, Integer> axisCounters = new HashMap<>();
//        axisCounters.put("x", rootSquare.getXAxisLocation());
//        axisCounters.put("y", rootSquare.getYAxisLocation());
//        int xAxisMax = direction.getMaxXAxisLocation();
//        int yAxisMax = direction.getMaxYAxisLocation();
//        
//        if(axisCounters.get("x") == xAxisMax || axisCounters.get("y") == yAxisMax)
//            return null;
//        
//        boolean edgeReached = false;
//        int distance = 0;
//        
//        while (!edgeReached) {
//            
//            axisCounters = ChessBoard.incrementAxisCounters(direction, axisCounters);
//            distance++;
//            
//            if(!board[axisCounters.get("y")][axisCounters.get("x")].isSquareEmpty)
//                return new NearestPiece(board[axisCounters.get("y")][axisCounters.get("x")].currentPiece, distance, direction);
//            else if (axisCounters.get("y") == yAxisMax || axisCounters.get("x") == xAxisMax)
//                return null;
//        }
//        return null;
//    }
    
    public ArrayList<ChessBoardSquare> surroundingSquaresAllVectors(ChessBoardSquare rootSquare) {
        
        ArrayList<ChessBoardSquare> availableSquares = new ArrayList<>();
        int arrayCounter = 0;
        
        for (String directions: POSSIBLE_DIRECTIONS) {
            Direction nextDirection = new Direction(POSSIBLE_DIRECTIONS[arrayCounter]);
            ChessBoardSquare temp = this.nearestSquareSingleVector(rootSquare, nextDirection);
            if (temp != null)   
                availableSquares.add(temp);
            arrayCounter++;
        }
        return availableSquares;
    }
    
    private ChessBoardSquare nearestSquareSingleVector(ChessBoardSquare rootSquare, Direction direction) {
        
        Map<String, Integer> axisCounters = new HashMap<>();
        axisCounters.put("x", rootSquare.getXAxisLocation());
        axisCounters.put("y", rootSquare.getYAxisLocation());
        int xAxisMax = direction.getMaxXAxisLocation();
        int yAxisMax = direction.getMaxYAxisLocation();
        
        if(axisCounters.get("x") != xAxisMax || axisCounters.get("y") != yAxisMax) {
            axisCounters = ChessBoard.incrementAxisCounters(direction, axisCounters);
            return board[axisCounters.get("y")][axisCounters.get("x")];
        }
        else
            return null;
    }
    
    public ArrayList<ChessBoardSquare> allSquaresBetweenTwoPoints(ChessBoardSquare rootSquare, ChessBoardSquare targetSquare) {
        
        ArrayList<ChessBoardSquare> availableSquares = new ArrayList<>();
        Movement movementRequired = new Movement(rootSquare, targetSquare);
        Map<String, Integer> axisCounters = new HashMap<>();
        axisCounters.put("x", rootSquare.getXAxisLocation());
        axisCounters.put("y", rootSquare.getYAxisLocation());
        int xAxisMax = targetSquare.getXAxisLocation();
        int yAxisMax = targetSquare.getYAxisLocation();
        
        do {
            axisCounters = ChessBoard.incrementAxisCounters(movementRequired.getMovementDirection(), axisCounters);
            availableSquares.add(board[axisCounters.get("y")][axisCounters.get("x")]);
        } while ((axisCounters.get("x") < xAxisMax) && axisCounters.get("y") < yAxisMax);
        
        return availableSquares;
    }
     
    private static Map<String, Integer> incrementAxisCounters(Direction direction, Map<String, Integer> axisCounters) {
        
        switch (direction.getDirection()) {
                case "left":
                    axisCounters.put("x", (axisCounters.get("x") - 1));
                    break;
                case "leftdown":
                    axisCounters.put("x", (axisCounters.get("x") - 1));
                    axisCounters.put("y", (axisCounters.get("y") - 1));
                    break;
                case "leftup":
                    axisCounters.put("x", (axisCounters.get("x") - 1));
                    axisCounters.put("y", (axisCounters.get("y") + 1));
                    break;
                case "down":
                    axisCounters.put("y", (axisCounters.get("y") - 1));
                    break;
                case "up":
                    axisCounters.put("y", (axisCounters.get("y") + 1));
                    break;
                case "right":
                    axisCounters.put("x", (axisCounters.get("x") + 1));
                    break;
                case "rightdown":
                    axisCounters.put("x", (axisCounters.get("x") + 1));
                    axisCounters.put("y", (axisCounters.get("y") - 1));
                    break;
                case "rightup":
                    axisCounters.put("x", (axisCounters.get("x") + 1));
                    axisCounters.put("y", (axisCounters.get("y") + 1));
                    break;
        }
        return axisCounters;
    }
}
