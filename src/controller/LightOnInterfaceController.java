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
    public LightOnInterfaceController(IfYouHaveThisTemplateICanCallYou view, LightOn model){
        view.addEventListener(this);
    }

    @Override
    public void doAtallit(int szektor, int lampa) {
        System.out.println("Ez lefutott.");
    }
    
    
}
