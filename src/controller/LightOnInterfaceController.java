/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.LightOn;
import view.LightOnViewInterface;

/**
 *
 * @author Roland
 */
public class LightOnInterfaceController implements LightOnViewInterface {
    IfYouHaveThisTemplateICanCallYou view;
    LightOn model;
    
    public LightOnInterfaceController(IfYouHaveThisTemplateICanCallYou view, LightOn model){
        this.view = view;
        this.model = model;
        init();
        view.doMegjelenit();
        
        for (int i = 0; i < model.getSzektorSzam(); i++) {
            view.doGeneral(model.getSzektor(i), model.getSorHossz(), 
                    i == model.getSzektorSzam()-1 ? model.getNegativ() : 32);
        }
    }

    
    private final void init(){
        view.addEventListener(this);
    }
    
    @Override
    public void doAtallit(int szektor, int lampa){
        model.doKapcsol(szektor, lampa);
        //model.getSzektor(0);
       this.doingUpdate();
        if(model.getGyozelem()) view.doVege();
    }
    
    @Override
    public void doRestart(){
        model.doRestart();
        this.doingUpdate();
    }
    
    private void doingUpdate(){
        view.doUpdate(model.getSzektorok(), model.getNegativ());
    }
}
