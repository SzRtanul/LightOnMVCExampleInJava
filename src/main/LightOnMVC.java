/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.LightOnPoliformController;
import model.LightOn;
import view.LightOnGUI1View;

/**
 *
 * @author Roland
 */
public class LightOnMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new LightOn(3, 3);
        
        //System.out.println(Integer.toBinaryString(31%32));
        //int muvelet = 15%32;
        //System.out.println((muvelet^(((muvelet>>5)&0b1)<<5)-1) &0b11111);
        //System.out.println(Integer.toBinaryString(((muvelet&0b11111)^((muvelet>>5&0b1<<5)-1))&0b1111));
        //System.out.println(Integer.toBinaryString((muvelet^(((muvelet>>5)&0b1)<<5)-1) &0b11111));
        //doMegjelenitBit(1);
        //doMegjelenitBit(1<<45);
        new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 8));
    }
    
    public final static void doMegjelenitBit(int szam){
        System.out.println(Integer.toBinaryString(szam));
    }
    
}
