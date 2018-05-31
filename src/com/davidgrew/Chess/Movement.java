/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

/**
 *
 * @author davidgrew
 */
public class Movement {
    
    private ChessBoardSquare currentSquare;
    private ChessBoardSquare futureSquare;
    private int movementDistance;
    private String movementType;
    private Direction movementDirection;
    
    public Movement(ChessBoardSquare currentSquare, ChessBoardSquare futureSquare) {
        
        this.currentSquare = currentSquare;
        this.futureSquare = futureSquare;
        int distanceMovedXAxis = currentSquare.getXAxisLocation() - futureSquare.getXAxisLocation();
        int distanceMovedYAxis = currentSquare.getYAxisLocation() - futureSquare.getYAxisLocation();
        int unsignedDistanceMovedXAxis = distanceMovedXAxis < 0 ? distanceMovedXAxis * -1 : distanceMovedXAxis;
        int unsignedDistanceMovedYAxis = distanceMovedYAxis < 0 ? distanceMovedYAxis * -1 : distanceMovedYAxis;
        
        if (distanceMovedXAxis > 0 && distanceMovedYAxis == 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "horizontal";
            this.movementDirection = new Direction("left"); 
        }
        else if (distanceMovedXAxis > 0 && distanceMovedYAxis > 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "diagonal";
            this.movementDirection = new Direction("leftdown");
        }
        else if (distanceMovedXAxis > 0 && distanceMovedYAxis < 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "diagonal";
            this.movementDirection = new Direction("leftup");
        }
        else if (distanceMovedXAxis == 0 && distanceMovedYAxis > 0){
            this.movementDistance = unsignedDistanceMovedYAxis;
            this.movementType = "vertical";
            this.movementDirection = new Direction("down");
        }
        else if (distanceMovedXAxis == 0 && distanceMovedYAxis < 0){
            this.movementDistance = unsignedDistanceMovedYAxis;
            this.movementType = "vertical";
            this.movementDirection = new Direction("up");
        }
        else if (distanceMovedXAxis < 0 && distanceMovedYAxis == 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "horizontal";
            this.movementDirection = new Direction("right");
        }
        else if (distanceMovedXAxis < 0 && distanceMovedYAxis > 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "diagonal";
            this.movementDirection = new Direction("rightdown"); 
        }
        else if (distanceMovedXAxis < 0 && distanceMovedYAxis < 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "diagonal";
            this.movementDirection = new Direction("rightup"); 
        }
        else {
            this.movementDistance = 0;
            this.movementType = "invalid";
            this.movementType = "invalid";
        }
    }
    
    public int getMovementDistance() {
        return this.movementDistance;
    }
    
    public String getMovementType() {
        return this.movementType;
    }
    
    public Direction getMovementDirection() {
        return this.movementDirection;
    }
    
    public ChessBoardSquare getCurrentSquare() {
        return this.currentSquare;
    }
    
    public ChessBoardSquare getFutureSquare() {
        return this.futureSquare;
    }
}
