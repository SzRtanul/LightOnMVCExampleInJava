/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

/**
 *
 * @author Roland
 */
public interface LightOnViewInterface {
    int randomValtozo = 0;
    static void valamiStatikusKod(){
        // Eddig nem tudtam, hogy lehet ilyet is
        System.out.println(LightOnViewInterface.randomValtozo);
    }
    void doRestart();
    void doAtallit(int szektor, int lampa);
}
