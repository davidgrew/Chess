/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;

/**
 *
 * @author David
 */
public class Direction {
    
    private final String directionType;
    private String direction;
    private final int maxXAxisLocation;
    private final int maxYAxisLocation;
    
    Direction(String direction) {
        this.direction = direction.toLowerCase();
        
        switch (this.direction) {
            case "left":
                this.maxXAxisLocation = 0;
                this.maxYAxisLocation = 99;
                this.directionType = "horizontal";
                break;
            case "leftdown":
                this.maxXAxisLocation = 0;
                this.maxYAxisLocation = 0;
                this.directionType = "diagonal";
                break;
            case "leftup":
                this.maxXAxisLocation = 0;
                this.maxYAxisLocation = 7;
                this.directionType = "diagonal";
                break;
            case "down":
                this.maxXAxisLocation = 99;
                this.maxYAxisLocation = 0;
                this.directionType = "vertical";
                break;
            case "up":
                this.maxXAxisLocation = 99;
                this.maxYAxisLocation = 7;
                this.directionType = "vertical";
                break;
            case "rightdown":
                this.maxXAxisLocation = 7;
                this.maxYAxisLocation = 0;
                this.directionType = "diagonal";
                break;
            case "rightup":
                this.maxXAxisLocation = 7;
                this.maxYAxisLocation = 7;
                this.directionType = "diagonal";
                break;
            case "right":
                this.maxXAxisLocation = 7;
                this.maxYAxisLocation = 99;
                this.directionType = "horizontal";
                break;
            default:
                this.maxXAxisLocation = 99;
                this.maxYAxisLocation = 99;
                this.directionType = "undefined";
        }
    }
    
    public String getDirectionType() {
        return this.directionType;
    }
    
    public String getDirection() {
        return this.direction;
    }
    
    public int getMaxXAxisLocation() {
        return this.maxXAxisLocation;
    }
    
    public int getMaxYAxisLocation() {
        return this.maxYAxisLocation;
    }
}
