/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.Chess;

/**
 *
 * @author David
 */
public class Direction {
    
    private String direction;
    private int maxXAxisLocation;
    private int maxYAxisLocation;
    
    Direction(String direction) {
        this.direction = direction;
        
        switch (direction) {
            case "left":
                this.maxXAxisLocation = 0;
                this.maxYAxisLocation = 99;
                break;
            case "leftdown":
                this.maxXAxisLocation = 0;
                this.maxYAxisLocation = 0;
                break;
            case "leftup":
                this.maxXAxisLocation = 0;
                this.maxYAxisLocation = 7;
                break;
            case "down":
                this.maxXAxisLocation = 99;
                this.maxYAxisLocation = 0;
                break;
            case "up":
                this.maxXAxisLocation = 99;
                this.maxYAxisLocation = 7;
                break;
            case "right":
                this.maxXAxisLocation = 7;
                this.maxYAxisLocation = 99;
                break;
            case "rightdown":
                this.maxXAxisLocation = 7;
                this.maxYAxisLocation = 0;
                break;
            case "rightup":
                this.maxXAxisLocation = 7;
                this.maxYAxisLocation = 7;
                break;
        }
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
