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
        System.out.println(model.getSzektor(0));
        view.doGeneral(model.getSzektor(0), model.getSorHossz(), model.getLightCount()%32);
        init();
    }
    
    public final void init(){
        LightOnPoliformController.addEventListener(this);
    }
}
