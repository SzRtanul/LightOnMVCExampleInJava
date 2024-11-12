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
    LightOn model;
    LightOnGUI1View view;
    public LightOnPoliformController(LightOnGUI1View view, LightOn model){
        this.view = view;
        this.model = model;
        init();
        view.doMegjelenit();
        
        for (int i = 0; i < model.getSzektorSzam(); i++) {
            view.doGeneral(model.getSzektor(i), model.getSorHossz(), 
                    i == model.getSzektorSzam()-1 ? 32-model.getNegativ() : 32);
        }
    }
    
    public final void init(){
        view.addEventListener(this);
    }
    
    @Override
    public void doAllit(int szektor, int lampa){
        model.doKapcsol(szektor, lampa);
        int szektorszam = model.getSzektorSzam();
        int[] szektorok = new int[szektorszam];
        for (int i = 0; i < szektorszam; i++) {
            szektorok[i] = model.getSzektor(i);
        }
        view.doUpdate(szektorok, model.getNegativ());
    }
}
