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
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(1, 1));
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 1)); // Vizsgálat szükséges
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 2));
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 3));
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 4));
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 31));
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 32));
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 33));
        // new LightOnPoliformController(new LightOnGUI1View(), new LightOn(8, 1023));
         new LightOnPoliformController(new LightOnGUI1View(), new LightOn(9, 8));
    }
    
    public final static void doMegjelenitBit(int szam){
        System.out.println(Integer.toBinaryString(szam));
    }
    
}
