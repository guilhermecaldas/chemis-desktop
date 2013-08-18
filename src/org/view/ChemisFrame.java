/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.view;

import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import org.view.components.ChemisSideBar;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.UIManager;
import org.model.ChemisTools;

/**
 *
 * @author guilherme
 */
public class ChemisFrame extends javax.swing.JFrame {

    private CardLayout cardLayout=new CardLayout();
    private JPanel panelCentral=new JPanel();
    private ChemisSideBar chemisSideBar=new ChemisSideBar();
    private HashMap<String,JPanel> modules=new HashMap<>();
    
    /**
     * Creates new form ChemisFrame
     */
    public ChemisFrame() {
        try{
            UIManager.setLookAndFeel(new GTKLookAndFeel());
        }catch(Exception e){
            e.printStackTrace();
        }
        
        initComponents();
        setTitle("Chemis");
        setSize(700,500);
        setIconImage(ChemisTools.getInstance().getImage("/org/view/icons/chemis-icon.png").getImage());
        
        panelCentral.setLayout(cardLayout);
        
        add(chemisSideBar);
        add(panelCentral);
        
        openModule(new DixonPanel(),"dixon");
    }
    
    /**
     * Open a JPanel in the component panelCentral.
     * This method also tests if the given module is already saved in cache, 
     * saving memory.
     * 
     * @param panel
     * @param name 
     */
    
    private void openModule(JPanel panel,String name){
        if(!modules.containsKey(name)){
            modules.put(name, panel);
            panelCentral.add(name,panel);
        }
        cardLayout.show(panelCentral,name);
    }

    /**Test if a JPanel of a Chemis' module is already in the cache,
     * returning <code>true</code> if the opened and <code>false</code> if 
     * not running yet.
     * 
     * @param name
     * @return 
     */
    private boolean isModuleOpen(String name){
        return modules.containsKey(name);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        menuAbout.setText("About");
        jMenuBar1.add(menuAbout);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAbout;
    // End of variables declaration//GEN-END:variables
}
