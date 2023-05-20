/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shapes;

import java.awt.Point;

/**
 *
 * @author HP
 */
public interface Moveable {
    
   public void setDraggedPoint(Point point);
   public Point getDraggedPoint();;
   public boolean contains(Point point);
   public void moveTo(Point point);
   public boolean isInsideBorder(Point point);
   public void resize(Point point);
}
