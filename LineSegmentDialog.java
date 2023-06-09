/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package shapes;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class LineSegmentDialog extends javax.swing.JFrame implements Node {

    /**
     * Creates new form LineSegmentDialog
     */
    Node parent;
    LineSegment l;
    DrawingEngineA canvas;
    Color colour=Color.BLACK;
    PaintApplicationWindow w = new PaintApplicationWindow();
   // int flag=0;
    public LineSegmentDialog(DrawingEngineA canvas,PaintApplicationWindow w) {
        this.canvas=canvas;
        this.w=w;
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        xCoodrinate1 = new javax.swing.JTextField();
        yCoordinate1 = new javax.swing.JTextField();
        xCoordinate2 = new javax.swing.JTextField();
        yCoordinate2 = new javax.swing.JTextField();
        color = new javax.swing.JButton();
        insert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Line Segment Properties");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("X Coordinate (Point 1)");

        jLabel2.setText("Y Coordinate (Point 1)");

        jLabel3.setText("X Coordinate (Point 2)");

        jLabel4.setText("Y Coordinate (Point 2)");

        yCoordinate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yCoordinate1ActionPerformed(evt);
            }
        });

        color.setBackground(new java.awt.Color(0, 0, 0));
        color.setForeground(new java.awt.Color(255, 255, 255));
        color.setText("Select Color");
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });

        insert.setBackground(new java.awt.Color(0, 0, 0));
        insert.setForeground(new java.awt.Color(255, 255, 255));
        insert.setText("Create Line");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(color))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insert)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(xCoodrinate1)
                        .addComponent(yCoordinate1)
                        .addComponent(xCoordinate2)
                        .addComponent(yCoordinate2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(xCoodrinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(yCoordinate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(xCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(yCoordinate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(color)
                    .addComponent(insert))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yCoordinate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yCoordinate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yCoordinate1ActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
       try{
        String pointX1=xCoodrinate1.getText();
        String pointY1=yCoordinate1.getText();
        String pointX2=xCoordinate2.getText();
        String pointY2=yCoordinate2.getText();
        if(pointX1.equals("")||pointY1.equals("")||pointX2.equals("")||pointY2.equals("")){
            if(pointX1.equals(""))
                xCoodrinate1.setText("Add data here");
            if(pointY1.equals(""))
                yCoordinate1.setText("Add data here");
            if(pointX2.equals(""))
                xCoordinate2.setText("Add data here");
            if(pointY2.equals(""))
                yCoordinate2.setText("Add data here");
            
        }
        else{
            int  x1 = Integer.parseInt(pointX1);
        int  y1 = Integer.parseInt(pointY1);
        int  x2 = Integer.parseInt(pointX2);
        int  y2 = Integer.parseInt(pointY2);
         if(x1<0||y1<0||x2<0||y2<0)
          JOptionPane.showMessageDialog(null,"Please enter a positive number");
         else{
        l= new LineSegment(new Point(x1,y1),new Point(x2,y2)); 
        l.setColor(colour);
        canvas.addShape(l);
        w.setComboBox(2);
        setVisible(false);
        ((JFrame)getParentNode()).setVisible(true);
         } }
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,"Please check the entered data");
       }
        
    }//GEN-LAST:event_insertActionPerformed

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        // TODO add your handling code here:
        colour=JColorChooser.showDialog(null, "Choose color", Color.black);
        if(colour==null)
            colour=Color.BLACK;
        //l.setColor(colour);
        //flag=1;
    }//GEN-LAST:event_colorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
               this.setVisible(false);
        ((JFrame)getParentNode()).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

   
    
    @Override
    public Node getParentNode() {
        return parent;
    }

    @Override
    public void setParentNode(Node node) {
        parent=node;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton color;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField xCoodrinate1;
    private javax.swing.JTextField xCoordinate2;
    private javax.swing.JTextField yCoordinate1;
    private javax.swing.JTextField yCoordinate2;
    // End of variables declaration//GEN-END:variables
}
