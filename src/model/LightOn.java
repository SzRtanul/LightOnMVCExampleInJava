/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;
import java.util.BitSet;
import main.LightOnMVC;

/**
 *
 * @author Roland
 */
public class LightOn {
    private int[] allapot;
    private int adatok; 
        //--1bit:(32%sorhossz>0)
        //5bit:((sorhossz*2+1)/32)[eltérés], 
        //5bit:(32%sorhossz)[különbözet], 
        //10bit:(sorhossz), 
        //5bit:(utolso szektorhoz negatív korrigáló érték)
    
    public LightOn(){
        this(8, 9);
    }
    
    public LightOn(int sorszam, int sorhossz){
        allapot = new int[((sorszam*sorhossz)/32)+1];
        this.doRestart();
        adatok = 0;
        adatok = ((sorszam*sorhossz)%32) ^ // getNegativ()
                 ((sorhossz&0b1111111111) << 5) ^ // getSorHossz()
                 ((sorhossz%32)<<15) ^ // getKulonbozet
                 (((sorhossz)/32)<<20); // getElteres
        
    }
    
    public final void doRestart(){
        for (int i = 0; i < allapot.length; i++) {
            //allapot[i] = (int)((Math.random() * Integer.MAX_VALUE*2)-Integer.MAX_VALUE);
            allapot[i] = (int)(Math.random() * 0xFFFFFFF);
        }
    }
    
    public boolean doKapcsol(int szektor, int lampa){
        lampa = lampa&0b11111; // 
        szektor = szektor>=0 && szektor < allapot.length ? szektor : (szektor >=0 ? 0b1111111111 : 0);
    
        // int local2 = szektor + 1 - (~(lampa>>4) & 1) * 2;
        int local3 = ((lampa & 0b1111) ^ (((~(lampa>>4)&1))-1)&0b1111); // Tavolsag
       
        //Felette
        if(getElteresMertek() == 0 && local3 >= getKulonbozet()){
            allapot[szektor] ^= ((1<<(getSorHossz()*2))+1)<<((lampa-getSorHossz()));
        }
        else{
            // Felső
            if((((szektor * 32)+lampa) - getSorHossz()) >= 0){
                allapot[(((szektor * 32)+lampa) - getSorHossz())/32] ^= 
                        (1 << ((lampa-getSorHossz())&0b11111));
            }
            // Alsó
            if((((szektor * 32)+lampa) + getSorHossz()) < getLightCount()){ 
                allapot[(((szektor * 32)+lampa) + getSorHossz())/32] ^= 
                        (1 << (((lampa+getSorHossz())&0b11111)));
            }
        }
        // Mellette
        int sorbanhol =((szektor*32)+(lampa)) % getSorHossz();
        int local = 0b111;
        if(getSorHossz()-1 > 0 && (((sorbanhol)%(getSorHossz()-1))) == 0){
            local = (sorbanhol == 0 ? 0b110 : 0b011);
        }
        else if (getSorHossz() == 1) local = 0b010;
        if(lampa%31!=0){
            allapot[szektor] ^= ((local) << lampa-1);
        }
        else{
            if(lampa%31==0){
                allapot[szektor] ^= lampa == 0 ? (local & 0b110) >> 1 : (local & 0b011) << lampa-1;
                if(szektor + (lampa==0 ? -1 : 1) >= 0 && szektor + (lampa==0 ? -1 : 1) < allapot.length){
                    allapot[szektor + (lampa==0 ? -1 : 1)] ^= 
                            (lampa!=0 ? (local&0b100)>>2 : local & 1) << (31 - lampa);
                }
            }
        }
        return false;
    }
    
    public int getSorHossz(){
        return adatok >> 5 & ((1<<10)-1);
    }
    
    public int getSzektor(int szektorszam){
        return szektorszam >= 0 && szektorszam < allapot.length ? 
                allapot[szektorszam] : (szektorszam == allapot.length -1 ? 
                allapot[szektorszam] & ((1<<(32-getNegativ()))-1) : 0);
    }
    
    public int[] getSzektorok(){
        return Arrays.copyOf(allapot, allapot.length);
    }
    
    public int getSzektorSzam(){
        return allapot.length;
    }
    
    public int getLightCount(){
        return (allapot.length * 32) - (32-(adatok & ((1<<5)-1)));
    }
    
    public boolean getGyozelem(){
        boolean both = true;
        for (int i = 0; i < this.allapot.length-1 && both; i++) {
            both = allapot[i] == 0;
        }
        both = both ? (allapot[this.allapot.length-1] & ((1<<(getNegativ()))-1)) == 0 : false;
        return both;
    }
    
    public int getNegativ(){
        return adatok & 0b11111;
    }
    
    private int getKulonbozet(){
        return (adatok >> 15) & 0b11111;
    }
    
    private int getElteresMertek(){
        return (adatok >> 20) & 0b11111;
    }
}
