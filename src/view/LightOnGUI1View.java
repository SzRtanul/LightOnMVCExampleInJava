/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Roland
 */
public class LightOnGUI1View extends javax.swing.JFrame {
    private LightOnGUI1View listener;
    
    public void addEventListener(LightOnGUI1View listener){
        //System.out.println(this.getClass());
        this.listener = listener;
        //System.out.println(listener.getClass());
        //listener.doAllit(0, 1);
    }
    
    private LightButton[] buttons = new LightButton[0];    
    private int sorszamlal = 0;
    private int sor = 0;
    private int szektorszamlal = 0;
    /**
     * Creates new form LightOnGUI1View
     */
    public LightOnGUI1View() {
        listener=this;
        initComponents();
    }
    
    public void doGeneral(int szektor, int sor){
        doGeneral(szektor, sor, 32);
    }
    
    public void doGeneral(int szektor, int sor, int utolso){
        LightButton[] newButtons = new LightButton[buttons.length+utolso];
        System.arraycopy(buttons, 0, newButtons, 0, buttons.length);
        buttons = newButtons;
        int start = buttons.length - utolso;
        this.PnJatekTer.setLayout(new GridLayout(0, sor));
        for (int i = start; i < start+utolso; i++) {
            buttons[i] = new LightButton(((szektor>>i) & 1) == 1, new Point(sorszamlal*90, sor*90));
            final int iconst = i;
            final int szektorsza =this.szektorszamlal;
            buttons[i].setText("%d, %d".formatted(szektorsza, i));
            buttons[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionButton(szektorsza, iconst);
                }
            });
            JPanel jp = new JPanel(new FlowLayout());
            jp.add(buttons[i]);
            this.PnJatekTer.add(jp);
            sorszamlal++;
            if (sorszamlal==sor){
                sorszamlal = 0;
                this.sor++;
            }
        }
        this.PnJatekTer.validate();
        this.PnJatekTer.repaint();
        szektorszamlal++;
    }
    
    public void doMegjelenit(){
        this.setVisible(true);
    }

    public void actionButton(int szektorszam, int lampa){
        listener.doAllit(szektorszam, lampa);
    }
    
    public void doClear(){
        this.PnJatekTer.removeAll();
    }

    protected void doAllit(int szektor, int lampa){
        System.out.println("Ez lefut.");
    }
    
    public void doUpdate(int[] szektorok, int negativ){
        if(szektorok.length > 0){
            int szektor = 0;
            int szektorszam = 0;
            for(int i = 0, tolas = 0; i < buttons.length; i++, tolas++) {
                if(tolas % 32 == 0){
                    szektor=szektorok[szektorszam];
                    szektorszam++;
                    tolas=0;
                }
                buttons[i].setLigth(((szektor>>tolas)&1) == 1);
            }
        }
    }
    
    public void doVege(){
        JOptionPane.showMessageDialog(this, "Gratulálok! Győztél!");
        listener.doRestart();
    }
    
    protected void doRestart(){}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PnJatekTer = new javax.swing.JPanel();
        Bt_restart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnJatekTer.setAutoscrolls(true);
        PnJatekTer.setInheritsPopupMenu(true);
        PnJatekTer.setName(""); // NOI18N

        javax.swing.GroupLayout PnJatekTerLayout = new javax.swing.GroupLayout(PnJatekTer);
        PnJatekTer.setLayout(PnJatekTerLayout);
        PnJatekTerLayout.setHorizontalGroup(
            PnJatekTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );
        PnJatekTerLayout.setVerticalGroup(
            PnJatekTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(PnJatekTer);

        Bt_restart.setText("Restart");
        Bt_restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_restartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Bt_restart)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bt_restart)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bt_restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_restartActionPerformed
        listener.doRestart();
    }//GEN-LAST:event_Bt_restartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LightOnGUI1View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LightOnGUI1View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LightOnGUI1View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LightOnGUI1View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LightOnGUI1View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bt_restart;
    private javax.swing.JPanel PnJatekTer;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
