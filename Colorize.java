/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package shapes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Colorize extends javax.swing.JFrame implements Node{

    /**
     * Creates new form Colorize
     */
    Node parent;
    Shape s;
    public Colorize(Shape s) {
        this.s=s;
        initComponents();
        setVisible(true);
    }
    public boolean checkRadios()
    {
        if((colorRadioButton.isSelected()==false)&&(fillRadioButton.isSelected()==false))
            return false;
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorRadioButton = new javax.swing.JRadioButton();
        fillRadioButton = new javax.swing.JRadioButton();
        jColorChooser1 = new javax.swing.JColorChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Colorize");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        colorRadioButton.setText("Color");
        colorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorRadioButtonActionPerformed(evt);
            }
        });

        fillRadioButton.setText("Fill Color");
        fillRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(colorRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fillRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(colorRadioButton)
                .addGap(18, 18, 18)
                .addComponent(fillRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void colorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorRadioButtonActionPerformed
        // TODO add your handling code here:
        s.setColor(jColorChooser1.getColor());
    }//GEN-LAST:event_colorRadioButtonActionPerformed

    private void fillRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillRadioButtonActionPerformed
        // TODO add your handling code here:
        s.setFillColor(jColorChooser1.getColor());
    }//GEN-LAST:event_fillRadioButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
       if(checkRadios()==false)
           JOptionPane.showMessageDialog(null,"Please select which color would you like to change");
       else
       {
           setVisible(false);
            ((JFrame)getParentNode()).setVisible(true);
       }
           
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton colorRadioButton;
    private javax.swing.JRadioButton fillRadioButton;
    private javax.swing.JColorChooser jColorChooser1;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        return parent;
    }

    @Override
    public void setParentNode(Node node) {
        parent=node;
    }
}