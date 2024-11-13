/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
        //5bit:(32/sorhossz)[eltérés], 
        //5bit:(32%sorhossz)[különbözet], 
        //10bit:(sorhossz), 
        //5bit:(utolso szektorhoz negatív korrigáló érték)
    
    public LightOn(){
        this(4, 8);
    }
    
    public LightOn(int sorszam, int sorhossz){
        allapot = new int[((sorszam*sorhossz)/32)+1];
        for (int i = 0; i < allapot.length; i++) {
            allapot[i] = (int)((Math.random() * Integer.MAX_VALUE*2)-Integer.MAX_VALUE);
        }
        // System.out.println(0xFFFFFFFE);
        // this.adatok = adatok & ((1<<15)+(1<<5)-1);
        // System.out.println(Integer.toBinaryString(((1<<15)+(1<<5)-1)));
        // this.adatok = sorhossz < 2048 ? adatok + (sorhossz << 5) : adatok + ((1<<15)-1);
        // System.out.println(Integer.toBinaryString(adatok));
        // System.out.println(Integer.toBinaryString((~(0b010)) & ((1<<3)-1)));
        // System.out.println(Integer.toBinaryString((0b101^((1<<3)-1))));
        // System.out.println(Integer.toBinaryString(0b111));
        adatok = 0;
        adatok = ((sorszam*sorhossz)%32) ^ // getNegativ()
                 ((sorhossz&0b1111111111) << 5) ^ // getSorHossz()
                 ((sorhossz%32)<<15) ^ // getKulonbozet
                 ((sorhossz/32)<<20); // getElteres
        
    }
    
    public boolean doKapcsol(int szektor, int lampa){
        //int ertek = (lampa)+1;
        //System.out.println(allapot[szektor]);
        // allapot[szektor] = ~((((allapot[szektor] >> lampa)-1) & (1<<3) -1) << lampa+1) 
        //         + (allapot[szektor] & ((1 << 3)-1)<<lampa-1);
       
        //allapot[szektor] ^= ((1 << 3) - 1) << (lampa - 2);
        //allapot[szektor] ^= ((1 << (getSorHossz() * 2)) + 1) << (((szektor * 32 + lampa) % getSorHossz()));
        if(false){
            // sorHossz%32==0: A szektorszámok közötti eltérés biztos, hogy 0.
            // (sorHosz%32==x)&0b1111: A szektorszámok közötti eltérés akkor lép fel, ha az alapszektor 
            //                 egyik szélétől kissebb a távolság, mint az x.
            // ((lampa + 1)%32)&0b1111<2: A megjelölt lámpa az egyik szektor szélén van.
            // 
        }
        // Lepesek:
        // 
       
        int local = 0; //1bit:(1 szektorral lóg ki mindkét oldalon), 1bit:(Nem tér ki), 1bit:(32-es tartományon belül)
        //local = getKulonbozet() & 1 | getKulonbozet() + 0b11110;
        local = getElteresMertek();
        // Szélső bit.
        // allapot[szektor] = 
      
        int allit = ((0-szektor)>>31)^((szektor-allapot.length)>>30);
        lampa = lampa&0b11111; // 
        szektor = szektor & allapot.length;
        //System.out.println(getElteresMertek());
        //System.out.println(Integer.toBinaryString(((lampa&0b11111)^((lampa>>5&0b1<<5)-1))&0b1111));
        //LightOnMVC.doMegjelenitBit((lampa ^ (((~(lampa>>4)&1))-1)&0b1111));
        //System.out.println(((lampa& 0b1111) ^ (((~(lampa>>4)&1))-1)&0b1111));
       //LightOnMVC.doMegjelenitBit(((lampa ^ (((lampa>>4)&1)<<5)-1) & 0b1111));
        
       // System.out.println(Integer.toBinaryString((~(lampa ^ (((lampa>>5)&1)<<5)-1) & 0b1111)));
        int local2 = szektor + 1 - (~(lampa>>4) & 1) * 2;
        int local3 = ((lampa & 0b1111) ^ (((~(lampa>>4)&1))-1)&0b1111);
       // System.out.println(local2);
        if(getElteresMertek() == 0 && local3 >= getKulonbozet()){
            allapot[szektor] ^= ((1<<(getSorHossz()*2))+1)<<((lampa-getSorHossz()));
        }
        else if (getElteresMertek() == 0 && local3 < getKulonbozet()){
            allapot[szektor] ^= 1 << (lampa + (getSorHossz() * (1 - (2 * ((lampa>>4) & 1)))));
            //System.out.println(((lampa - getSorHossz()) & 0b11111));
            //LightOnMVC.doMegjelenitBit((((~((lampa>>4)&1))-1)&0b11111));
            if((local2 >= 0 && local2<allapot.length))
                allapot[local2] ^= 1 << ((getSorHossz() - local3 -1) ^ (((((lampa>>4)&1))-1)&0b11111));
            //LightOnMVC.doMegjelenitBit(1 << (getSorHossz() - local3 - 1));
        }
       /*
        if (szektor + getElteresMertek() < allapot.length) 
            allapot[szektor+getElteresMertek()] ^= 1<<(getKulonbozet());
        if (szektor - getElteresMertek() >= 0) 
            allapot[szektor-getElteresMertek()] ^= 1<<(~(getKulonbozet()))&0b11111;
        */
        
       
      
       // Mellette
        if(lampa==31 || lampa == 0){
            if((lampa == 31 && szektor + 1 < allapot.length) || (lampa == 0 && szektor-1 >= 0)){
                allapot[szektor + (lampa > 0 ? 1 : -1)] ^= 1 << (~(lampa) & 0b11111);
            }
            allapot[szektor] ^= 0b11 << (lampa + (lampa > 0 ? -1:0));
        }
        else{
            allapot[szektor] ^= 0b111 << lampa-1;
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
    
    public int getSzektorSzam(){
        return allapot.length;
    }
    
    public int getLightCount(){
        return (allapot.length * 32) - (adatok & ((1<<5)-1));
    }
    
    public boolean getGyozelem(){
        boolean both = false;
        for (int i = 0; i < this.allapot.length-1 && both; i++) {
            both = allapot[i] == 0;
        }
        both = both ? (allapot[this.allapot.length-1] & ((1<<(32-getNegativ()))-1)) == 0 : false;
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
