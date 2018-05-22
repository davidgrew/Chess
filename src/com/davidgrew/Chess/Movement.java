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
    
    private int movementDistance;
    private String movementType;
    private String movementDirection;
    
    public Movement(ChessBoardSquare currentSquare, ChessBoardSquare futureSquare) {
        
        int distanceMovedXAxis = currentSquare.xAxisLocation - futureSquare.xAxisLocation;
        int distanceMovedYAxis = currentSquare.yAxisLocation - futureSquare.yAxisLocation;
        int unsignedDistanceMovedXAxis = distanceMovedXAxis < 0 ? distanceMovedXAxis * -1 : distanceMovedXAxis;
        int unsignedDistanceMovedYAxis = distanceMovedYAxis < 0 ? distanceMovedYAxis * -1 : distanceMovedYAxis;
        
        if (distanceMovedXAxis > 0 && distanceMovedYAxis == 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "horizontal";
            this.movementDirection = "left"; 
        }
        else if (distanceMovedXAxis > 0 && distanceMovedYAxis > 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "diagonal";
            this.movementDirection = "leftdown";
        }
        else if (distanceMovedXAxis > 0 && distanceMovedYAxis < 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "diagonal";
            this.movementDirection = "leftup";
        }
        else if (distanceMovedXAxis == 0 && distanceMovedYAxis > 0){
            this.movementDistance = unsignedDistanceMovedYAxis;
            this.movementType = "vertical";
            this.movementDirection = "down";
        }
        else if (distanceMovedXAxis == 0 && distanceMovedYAxis < 0){
            this.movementDistance = unsignedDistanceMovedYAxis;
            this.movementType = "vertical";
            this.movementDirection = "up";
        }
        else if (distanceMovedXAxis < 0 && distanceMovedYAxis == 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "horizontal";
            this.movementDirection = "right";
        }
        else if (distanceMovedXAxis < 0 && distanceMovedYAxis > 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "diagonal";
            this.movementDirection = "rightdown"; 
        }
        else if (distanceMovedXAxis < 0 && distanceMovedYAxis < 0){
            this.movementDistance = unsignedDistanceMovedXAxis;
            this.movementType = "diagonal";
            this.movementDirection = "rightup"; 
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
    
    public String getMovementDirection() {
        return this.movementDirection;
    }
}
