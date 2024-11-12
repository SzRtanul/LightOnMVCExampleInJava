/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Roland
 */
public class LightButton extends JButton {
    private boolean kapcsolva;
    public LightButton(boolean vilagit, Point point){
        super();
        this.setPreferredSize(new Dimension(80, 80));
        this.setLocation(point);
        this.kapcsolva = vilagit;
        this.setLigth(kapcsolva);
        this.setVisible(true);
    }
    
    public final void setLigth(boolean kapcsolva){
        this.setBackground(kapcsolva ? Color.yellow : Color.green);
        this.kapcsolva = kapcsolva;
    }
    
    public final boolean getLight(){
        return this.kapcsolva;
    }
}
