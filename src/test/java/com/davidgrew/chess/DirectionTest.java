/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidgrew.chess;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author davidgrew
 */
public class DirectionTest {
    
    @Test
    public void leftTest() {
        //given
        Direction left = new Direction("left");
        
        //then
        assertEquals(0, left.getMaxXAxisLocation());
        assertEquals(99, left.getMaxYAxisLocation());
        assertEquals("left", left.getDirection());
        assertEquals("horizontal", left.getDirectionType());
    }
    
    @Test
    public void leftUp() {
        //given
        Direction left = new Direction("leftUp");
        
        //then
        assertEquals(0, left.getMaxXAxisLocation());
        assertEquals(7, left.getMaxYAxisLocation());
        assertEquals("leftup", left.getDirection());
        assertEquals("diagonal", left.getDirectionType());
    }
    
    @Test
    public void leftDown() {
        //given
        Direction left = new Direction("leftDown");
        
        //then
        assertEquals(0, left.getMaxXAxisLocation());
        assertEquals(0, left.getMaxYAxisLocation());
        assertEquals("leftdown", left.getDirection());
        assertEquals("diagonal", left.getDirectionType());
    }
    
    @Test
    public void right() {
        //given
        Direction left = new Direction("right");
        
        //then
        assertEquals(7, left.getMaxXAxisLocation());
        assertEquals(99, left.getMaxYAxisLocation());
        assertEquals("right", left.getDirection());
        assertEquals("horizontal", left.getDirectionType());
    }
    
    @Test
    public void rightUp() {
        //given
        Direction left = new Direction("rightUp");
        
        //then
        assertEquals(7, left.getMaxXAxisLocation());
        assertEquals(7, left.getMaxYAxisLocation());
        assertEquals("rightup", left.getDirection());
        assertEquals("diagonal", left.getDirectionType());
    }
    
    @Test
    public void rightDown() {
        //given
        Direction left = new Direction("rightDown");
        
        //then
        assertEquals(7, left.getMaxXAxisLocation());
        assertEquals(0, left.getMaxYAxisLocation());
        assertEquals("rightdown", left.getDirection());
        assertEquals("diagonal", left.getDirectionType());
    }
    
    @Test
    public void up() {
        //given
        Direction left = new Direction("up");
        
        //then
        assertEquals(99, left.getMaxXAxisLocation());
        assertEquals(7, left.getMaxYAxisLocation());
        assertEquals("up", left.getDirection());
        assertEquals("vertical", left.getDirectionType());
    }
    
    @Test
    public void down() {
        //given
        Direction left = new Direction("down");
        
        //then
        assertEquals(99, left.getMaxXAxisLocation());
        assertEquals(0, left.getMaxYAxisLocation());
        assertEquals("down", left.getDirection());
        assertEquals("vertical", left.getDirectionType());
    }
}
