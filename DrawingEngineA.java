/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


/**
 *
 * @author HP
 */
public class DrawingEngineA extends JPanel implements DrawingEngine {
    private ArrayList<Shape> shapes=new ArrayList<>();
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i=0;i<shapes.size();i++)
            shapes.get(i).draw(g);
        
        
    }
    @Override
    public void addShape(Shape shape) {
       shapes.add(shape);
    }
    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[shapes.size()]);
    }

    @Override
    public void refresh(Graphics canvas) {
       this.repaint();
    }
    
}
