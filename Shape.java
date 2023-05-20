package shapes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author HP
 */
public interface Shape {
/* set position */
    
public void setPosition(java.awt.Point position);
public java.awt.Point getPosition();

/* colorize */

public void setColor(java.awt.Color color);
public java.awt.Color getColor();
public void setFillColor(java.awt.Color color);
public java.awt.Color getFillColor();
public void setBorderColor(java.awt.Color color);
 
    /**
     *
     * @return
     */
    public java.awt.Color getBorderColor(); 

/* redraw the shape on the canvas */

public void draw(java.awt.Graphics canvas);
public Shape copy();
    
}
