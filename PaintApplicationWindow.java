/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package shapes;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class PaintApplicationWindow extends javax.swing.JFrame implements Node {
    Node parent;
    int i=1;
    int j;
    private CircleDialog circleDialog;
    private LineSegmentDialog lineDialog;
    private RectangleDialog rectangleDialog;
    //private SquareDialog squareDialog;
    private TriangleData triangleData;
   // private Colorize colorize;
    private Shape shape;
   

    /**
     * Creates new form PaintApplicationWindow
     */
    public PaintApplicationWindow() {
        initComponents();
    }
    public void setComboBox(int x)
    {
        if(x==1)
            jComboBox1.addItem("Circle" + i);
        if(x==2)
            jComboBox1.addItem("Line" + i);
        if(x==3)
            jComboBox1.addItem("Rectangle" + i);
        if(x==4)
            jComboBox1.addItem("Triangle" + i);
        i++;
    }
    private void save(File path)
   {    Circle c;
        Rectangle r;
        Triangle t;
        LineSegment l;
      JsonArray ja= new JsonArray();
      for(Shape s:canvas.getShapes())
      {
          if(s instanceof Circle)
          {   c=(Circle)s; 
          ja.add(c.toJsonObject());}
          else if(s instanceof Rectangle)
          { r=(Rectangle) s;
            ja.add(r.toJsonObject());  
          }
          else if(s instanceof Triangle)
          {   t=(Triangle)s;
              ja.add(t.toJsonObject());
          }
          else {
              l=(LineSegment)s;
              ja.add(l.toJsonObject());
          }
          
      }
      String text= Jsoner.serialize(ja);
      try
      {    Path p=Paths.get(path.getAbsolutePath());
          Files.write(p, text.getBytes(), StandardOpenOption.CREATE);        }
      catch(IOException e)
              {
                    JOptionPane.showMessageDialog(null,"ERROR SAVING TO FILE!!!!!!");
              
              }
      
       
       
   }
    private void load(File path)
   {   Path p=Paths.get(path.getAbsolutePath());
       String data=null;
       JsonArray ja=null;
      // Shape ss;
        try {
             data = new String(Files.readAllBytes(p));
             //System.out.println(data);
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"ERROR READING FROM  FILE!!!!!!");
//   Logger.getLogger(PaintApplicationWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             ja = (JsonArray)Jsoner.deserialize(data);
           //  System.out.println(ja);
        } catch (JsonException ex) {
            JOptionPane.showMessageDialog(null,"ERROR Deserializing!!!!!!");
//Logger.getLogger(PaintApplicationWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        int m=0;
        for(Object o:ja)
        {   
            JsonObject ob= (JsonObject)o;
            String type=(String)ob.get("type");
            System.out.println(type);
            if(type.equals("Circle"))
            {   System.out.println("1");
                Circle cc= new Circle();
                cc.fromJsonObject(ob);
                canvas.addShape(cc);
                jComboBox1.addItem(type + m);
            }
           else if(type.equals("Rectangle")){
                System.out.println("2");
               Rectangle cc= new Rectangle();
                cc.fromJsonObject(ob);
                canvas.addShape(cc);
                jComboBox1.addItem(type + m);
           
           }
           else if(type.equals("Triangle"))
           {   System.out.println("3");
               Triangle cc= new Triangle();
                cc.fromJsonObject(ob);
                canvas.addShape(cc);
                jComboBox1.addItem(type + m);
           }
            else if (type.equals("LineSegment"))
            {   System.out.println("4");
                LineSegment cc= new LineSegment();
                cc.fromJsonObject(ob);
                canvas.addShape(cc);
                jComboBox1.addItem(type + m);
            }
            if(type==null)
                System.out.println("NULLLLLLL");
          m++;  
          i=m;
        }
        canvas.refresh(canvas.getGraphics());
       
       
   }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        circle = new javax.swing.JButton();
        lineSegment = new javax.swing.JButton();
        rectangle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        colorizeButton = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        canvas = new shapes.DrawingEngineA();
        Triangle = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint Application");

        circle.setText("Oval");
        circle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleActionPerformed(evt);
            }
        });

        lineSegment.setText("LineSegment");
        lineSegment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineSegmentActionPerformed(evt);
            }
        });

        rectangle.setText("Rectangle");
        rectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Shape");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        colorizeButton.setText("Colorize");
        colorizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizeButtonActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        canvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvasMouseDragged(evt);
            }
        });
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvasMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        Triangle.setText("Triangle");
        Triangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TriangleActionPerformed(evt);
            }
        });

        copyButton.setText("Copy");
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Load");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(copyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorizeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete)))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(circle)
                        .addGap(26, 26, 26)
                        .addComponent(lineSegment)
                        .addGap(29, 29, 29)
                        .addComponent(rectangle)
                        .addGap(30, 30, 30)
                        .addComponent(Triangle))
                    .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(circle)
                    .addComponent(lineSegment)
                    .addComponent(rectangle)
                    .addComponent(Triangle))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(colorizeButton)
                            .addComponent(delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copyButton))
                    .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lineSegmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineSegmentActionPerformed
        // TODO add your handling code here:
         try{
        setVisible(false);
        lineDialog=new LineSegmentDialog(canvas,this);
        lineDialog.setParentNode(this);  
        canvas.refresh(null);
        }catch(Exception e){}
    }//GEN-LAST:event_lineSegmentActionPerformed

    private void circleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleActionPerformed
        // TODO add your handling code here:
        try{
        setVisible(false);
        System.out.println(canvas.getShapes().length);
        circleDialog=new CircleDialog(canvas,this);
        circleDialog.setParentNode(this); 
        canvas.refresh(null);
        }catch(Exception e){}
    }//GEN-LAST:event_circleActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void rectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleActionPerformed
        // TODO add your handling code here:
        try{
        setVisible(false);  
        rectangleDialog=new RectangleDialog(canvas,this);
        rectangleDialog.setParentNode(this);  
        canvas.refresh(null);
        }catch(Exception e){}
    }//GEN-LAST:event_rectangleActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try{
        Shape s=canvas.getShapes()[jComboBox1.getSelectedIndex()];
        canvas.removeShape(s);
        jComboBox1.removeItemAt(jComboBox1.getSelectedIndex());
        canvas.refresh(canvas.getGraphics());
        
        i--;}
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"There are no shapes to delete");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void colorizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizeButtonActionPerformed
        // TODO add your handling code here:
        try{
        Shape s=canvas.getShapes()[jComboBox1.getSelectedIndex()];
        setVisible(false);
        Color fillColor,borderColor,fColor=s.getFillColor(),bColor=s.getColor();
        fillColor=JColorChooser.showDialog(null, " Fill Color", Color.BLACK);
        if(fillColor==null)
            fillColor=fColor;
        borderColor=JColorChooser.showDialog(null, "Border Color", Color.BLACK);
        if(borderColor==null)
            borderColor=bColor;
        s.setColor(borderColor);
        s.setFillColor(fillColor);
        setVisible(true);
        canvas.refresh(canvas.getGraphics());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No Shape Selected");
        }
    }//GEN-LAST:event_colorizeButtonActionPerformed

    private void canvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMousePressed

         Point p=evt.getPoint();
         Circle s2;
         Triangle s3;
         LineSegment s4;
         Rectangle s5;
         for(j=canvas.getShapes().length-1;j>=0;j--){
            shape=canvas.getShapes()[j];
         
          if(shape instanceof Circle)
           { s2=(Circle)shape;
                if (s2.contains(p))
                { 
                jComboBox1.setSelectedIndex(j);
                   s2.setDraggedPoint(p);
                   s2.setBorderColor(Color.BLACK);
                   s2.isSelected=1;
                   s2.isEdge=0;
                   break;
                }
                else if(s2.isInsideBorder(p))
                {
                    s2.setDraggedPoint(p);
                    s2.isEdge=1;
                    break;
                
                }
                else 
                {
                    s2.setBorderColor(Color.WHITE);
                    s2.isSelected=0;
                    s2.isEdge=0;
                }
               
           
           }
            else if(shape instanceof Rectangle)
            {s5=(Rectangle)shape;
            if (s5.contains(p))
                { 
                jComboBox1.setSelectedIndex(j);
                   s5.setDraggedPoint(p);
                   s5.setBorderColor(Color.BLACK);
                   s5.isSelected=1;
                   s5.isEdge=0;
                   break;
                }
                else if(s5.isInsideBorder(p))
                {
           
                    s5.setDraggedPoint(p);
                    s5.isEdge=1;
                    break;
                
                }
                else 
                {
                    s5.setBorderColor(Color.WHITE);
                    s5.isSelected=0;
                    s5.isEdge=0;
                }}
            else if(shape instanceof Triangle)
            {s3=(Triangle)shape;
            if (s3.contains(p))
                { 
                jComboBox1.setSelectedIndex(j);
                   s3.setDraggedPoint(p);
                   s3.setBorderColor(Color.BLACK);
                   s3.isSelected=1;
                   s3.isEdge=0;
                   break;
                }
                else if(s3.isInsideBorder(p))
                {
           
                    s3.setDraggedPoint(p);
                    s3.isEdge=1;
                    break;
                
                }
                else 
                {
                    s3.setBorderColor(Color.WHITE);
                    s3.isSelected=0;
                    s3.isEdge=0;

                }}
            else 
            { s4=(LineSegment)shape;
              if (s4.contains(p))
              {
                 jComboBox1.setSelectedIndex(j);
                   s4.setDraggedPoint(p);
                   s4.setBorderColor(Color.BLACK);
                   s4.isSelected=1;
                   s4.isEdge=0;
                   break;
              }
              else if(s4.isInsideBorder(p))
                {
           
                    s4.setDraggedPoint(p);
                    s4.isEdge=1;
                    break;
                
                }
                else 
                {
                    s4.setBorderColor(Color.WHITE);
                    s4.isSelected=0;
                    s4.isEdge=0;
                }}
               
            
         }
        for(int k=j-1;k>=0;k--){
             shape=canvas.getShapes()[k];
            if(shape instanceof Circle)
            {
                Circle c=(Circle)shape;
                c.setBorderColor(Color.WHITE);
                c.isSelected=0;
                c.isEdge=0;
            }
            else if(shape instanceof LineSegment)
            {
                LineSegment l=(LineSegment)shape;
                l.setBorderColor(Color.WHITE);
                l.isSelected=0;
                l.isEdge=0;
            } 
            else if(shape instanceof Rectangle)
            {
                Rectangle r=(Rectangle)shape;
                r.setBorderColor(Color.WHITE);
                r.isSelected=0;
                r.isEdge=0;
            }
            else
            {
                if(shape instanceof Triangle){
                Triangle t=(Triangle)shape;
                t.setBorderColor(Color.WHITE);
                t.isSelected=0;
                t.isEdge=0;
                }
            }
        }
         
       
    }//GEN-LAST:event_canvasMousePressed

    private void canvasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseReleased
        // TODO add your handling code here:
       
        Point P=evt.getPoint();
for(j=canvas.getShapes().length-1;j>=0;j--){
           shape=canvas.getShapes()[j];
     if(shape instanceof Rectangle)
     {Rectangle s1=(Rectangle)shape;
     if(s1.isEdge==1)
         s1.resize(P); 
     else
         if(s1.isSelected==1)
           s1.moveTo(P);
     }
     else if(shape instanceof Circle)
     { Circle s1=(Circle)shape;
     if(s1.isEdge==1)
         s1.resize(P);
     else
         if(s1.isSelected==1)
           s1.moveTo(P);
     }
     else if(shape instanceof Triangle)
     {
         Triangle s1=(Triangle)shape;
     if(s1.isEdge==1)
         s1.resize(P);
     else
         if(s1.isSelected==1)
           s1.moveTo(P);
     }
     else{
        LineSegment s1=(LineSegment)shape;
     if(s1.isEdge==1)
         s1.resize(P);
      else
         if(s1.isSelected==1)
           s1.moveTo(P);
     }
     canvas.refresh(canvas.getGraphics());}
    }//GEN-LAST:event_canvasMouseReleased

    private void canvasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseDragged
        // TODO add your handling code here:
      Point P=evt.getPoint();
      for(j=canvas.getShapes().length-1;j>=0;j--){
            shape=canvas.getShapes()[j];
     
     if(shape instanceof Rectangle)
     {Rectangle s1=(Rectangle)shape;
        if(s1.isEdge==1)
         {
         s1.resize(P);
         s1.setDraggedPoint(P);
         }
        else
            if(s1.isSelected==1)
             {
              s1.moveTo(P);
              s1.setDraggedPoint(P);
             }
     }
     else if(shape instanceof Circle)
     { Circle s1=(Circle)shape;
         if(s1.isEdge==1)
          {
         s1.resize(P);
         s1.setDraggedPoint(P);
          }
        else
             if(s1.isSelected==1)
          {
            s1.moveTo(P);
            s1.setDraggedPoint(P);
          }
         
     }
     else if(shape instanceof Triangle)
     {
         Triangle s1=(Triangle)shape;
         if(s1.isEdge==1)
          {
           s1.resize(P);
           s1.setDraggedPoint(P);
          }
         else
             if(s1.isSelected==1)
          {
            s1.moveTo(P);
            s1.setDraggedPoint(P);
          }
     }
     else
     {
        LineSegment s1=(LineSegment)shape;
     if(s1.isEdge==1)
     {
         s1.resize(P);
         s1.setDraggedPoint(P);
     }
     else
         if(s1.isSelected==1)
         {
          s1.moveTo(P);
          s1.setDraggedPoint(P);
         }
     }
     canvas.refresh(canvas.getGraphics());}
    }//GEN-LAST:event_canvasMouseDragged

    private void TriangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TriangleActionPerformed
        // TODO add your handling code here:
        try{
        setVisible(false);
        triangleData=new TriangleData(canvas,this);
        triangleData.setParentNode(this);  
        canvas.refresh(null);
        }catch(Exception e){}
    }//GEN-LAST:event_TriangleActionPerformed

    private void canvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseClicked
        // TODO add your handling code here:
        Point p=evt.getPoint();
         Square s1;
         Circle s2;
         Triangle s3;
         LineSegment s4;
         Rectangle s5;
         for(int i=canvas.getShapes().length-1;i>=0;i--){
            shape=canvas.getShapes()[i];
            if (shape instanceof Square)
            { 
                s1=(Square)shape;
              if (s1.contains(p))
              {   
                  jComboBox1.setSelectedIndex(i);
             
                 break;
              
            }
            }
           else if(shape instanceof Circle)
           { 
               s2=(Circle)shape;
                if (s2.contains(p))
                { 
                    jComboBox1.setSelectedIndex(i);
                    break;
                }   
               
           
           }
            else if(shape instanceof Rectangle)
            {
                s5=(Rectangle)shape;
            if (s5.contains(p))
            { 
                jComboBox1.setSelectedIndex(i);
                break;
            }
            }
            else if(shape instanceof Triangle)
            {
                s3=(Triangle)shape;
            
            if (s3.contains(p))
            { 
                jComboBox1.setSelectedIndex(i);
                break;
            }
            }
            else 
            { s4=(LineSegment)shape;
              if (s4.contains(p))
              {
                  jComboBox1.setSelectedIndex(i);
                  break;
              }
             }
            }
        
    }//GEN-LAST:event_canvasMouseClicked

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        // TODO add your handling code here:
        try{
        Shape s=canvas.getShapes()[jComboBox1.getSelectedIndex()];
        s=s.copy();
        canvas.addShape(s);
        if(s instanceof Circle){
        jComboBox1.addItem("Circle" + i);
        }
        if(s instanceof LineSegment){
        jComboBox1.addItem("Line" + i);
        }
        if(s instanceof Square){
        jComboBox1.addItem("Square" + i);
        }
        if(s instanceof Rectangle){
        jComboBox1.addItem("Rectangle" + i);
        }
        if(s instanceof Triangle){
        jComboBox1.addItem("Triangle" + i);
        }
        canvas.refresh(canvas.getGraphics());
        i++;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No Shapes to Copy");
        }
    }//GEN-LAST:event_copyButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser f = new JFileChooser();

        String fileName1;
        f.setCurrentDirectory(new File(System.getProperty("user.home")));
        int r= f.showSaveDialog(null);
        if(r==JFileChooser.APPROVE_OPTION)
        {
            File f1= new File(f.getSelectedFile().getAbsolutePath());
            save(f1);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.out.println("length"+canvas.getShapes().length);
        int n=canvas.getShapes().length;
       for(int k=n-1;k>=0;k--)
       { canvas.removeShape(canvas.getShapes()[k]);
        jComboBox1.removeItemAt(k);
           System.out.println("shape"+k+" is deleted");
        
       }
       //canvas.refresh(canvas.getGraphics());
       
       JFileChooser f = new JFileChooser();
        File f1;
        String fileName2;
        //f.setCurrentDirectory(new File(System.getProperty("user.home")));
        int r= f.showOpenDialog(null);
        if(r==JFileChooser.APPROVE_OPTION)
        {
           File f2= new File(f.getSelectedFile().getAbsolutePath());
           load(f2);
          // canvas.refresh(canvas.getGraphics());
           
        }
        //canvas.refresh(canvas.getGraphics());
        System.out.println(canvas.getShapes().length);
        for(int i=0;i<canvas.getShapes().length;i++)
         System.out.println(canvas.getShapes()[i]);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(PaintApplicationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaintApplicationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaintApplicationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaintApplicationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaintApplicationWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Triangle;
    private shapes.DrawingEngineA canvas;
    private javax.swing.JButton circle;
    private javax.swing.JButton colorizeButton;
    private javax.swing.JButton copyButton;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JButton lineSegment;
    private javax.swing.JButton rectangle;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        return this;
    }

    @Override
    public void setParentNode(Node node) {
        parent=node;
    }
}
