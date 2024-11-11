/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.LightOn;
import view.LightOnGUI1View;
import view.LightOnViewInterface;

/**
 *
 * @author Roland
 */
public class LightOnPoliformController extends LightOnGUI1View {
    public LightOnPoliformController(LightOnGUI1View view, LightOn model){
        view.doMegjelenit();
        System.out.println("Sorhossz: " + model.getSorHossz());
        System.out.println(Integer.toBinaryString(model.getSorHossz()));
        
        int szektor = 2;
        System.out.println(model.getSzektorSzam());
        view.doGeneral(model.getSzektor(szektor), model.getSorHossz(), szektor == model.getSzektorSzam()-1 ? 32-model.getNegativ() : 32);
        init();
    }
    
    public final void init(){
        this.addEventListener(this);
    }
    
    @Override
    public void doAllit(){
        System.out.println("Ez fut le.");
    }
}
