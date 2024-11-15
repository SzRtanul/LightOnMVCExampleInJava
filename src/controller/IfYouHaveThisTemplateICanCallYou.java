/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import view.LightOnViewInterface;

/**
 *
 * @author Roland
 */
public interface IfYouHaveThisTemplateICanCallYou {
    public void addEventListener(LightOnViewInterface liserner);
    void doGeneral(int szektor, int sor);
    void doGeneral(int szektor, int sor, int utolso);
    void doMegjelenit();
    void doUpdate(int[] szektorok, int negativ);
    void doVege();
    void doClear();
}
