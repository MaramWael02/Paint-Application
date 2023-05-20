/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Graphics;
import java.awt.Point;
import java.math.BigDecimal;

/**
 *
 * @author HP
 */
public class Circle extends SuperShape {
   private int radius;
   private int horizontalRadius;
    public Circle(){}
    public Circle(Point point,int radius,int horizontalRadius)
    {
        super(point);
        this.radius=radius;
        this.horizontalRadius=horizontalRadius;
    }
  

    /**
     *
     * @param canvas
     */

    @Override
    public void draw(Graphics canvas) { 
        canvas.setColor(getColor());
        canvas.drawOval((int)(getPosition().x), (int)(getPosition().y) ,horizontalRadius*2,radius*2);
        canvas.setColor(getFillColor());
        canvas.fillOval((int)getPosition().x, (int)getPosition().y,horizontalRadius*2,radius*2);
        if(this.isSelected==1){
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x, this.getPosition().y, 2*horizontalRadius, 2*radius);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5+2*horizontalRadius, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5+2*horizontalRadius, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5,this.getPosition().y-5+2*radius, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5, this.getPosition().y-5+2*radius, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5+2*horizontalRadius, this.getPosition().y-5+2*radius, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5+2*horizontalRadius, this.getPosition().y-5+2*radius, 10, 10);
        }
        
        
       
    }

    @Override
    public boolean contains(Point point) {
        return Math.pow((getPosition().x + radius)-point.x, 2)+Math.pow((getPosition().y + radius)-point.y, 2) <= Math.pow(radius, 2);
    
    }

    @Override
    public void moveTo(Point point) {
        int dfx=getDraggedPoint().x-point.x;
        int dfy=getDraggedPoint().y-point.y;
        Point newPosition=new Point();
        newPosition.x=getPosition().x-dfx;
        newPosition.y=getPosition().y-dfy;
        setPosition(newPosition);
       
    }
   @Override
    public boolean isInsideBorder(Point point)
    {
        Square s=new Square(new Point(this.getPosition().x-5, this.getPosition().y-5),10);
        if(s.contains(point))
        {
            edgeNumber=1;
            return true;
        }
        s.setPosition(new Point(this.getPosition().x-5+2*horizontalRadius, this.getPosition().y-5));
        if(s.contains(point))
        {
            edgeNumber=2;
            return true;
        }
        s.setPosition(new Point(this.getPosition().x-5, this.getPosition().y-5+2*radius));
        if(s.contains(point))
        {
            edgeNumber=3;
            return true;
        }
        s.setPosition(new Point(this.getPosition().x-5+2*horizontalRadius, this.getPosition().y-5+2*radius));  
        if(s.contains(point))
        {
            edgeNumber=4;
            return true;
        }
        return false;
        
    }
   @Override
    public void resize(Point point)
    {
        int dfx=getDraggedPoint().x-point.x;
        int dfy=getDraggedPoint().y-point.y;
        Point newPosition=new Point();
        if(edgeNumber==1){
        radius=radius+dfy;
        horizontalRadius=horizontalRadius+dfx;
        if(horizontalRadius<=0)
            horizontalRadius=1;
        if(radius<=0)
            radius=1;
        newPosition.x=getPosition().x-dfx;
        newPosition.y=getPosition().y-dfy;
        }
        if(edgeNumber==2){
        radius=radius+dfy;
        horizontalRadius=horizontalRadius-dfx;
        if(horizontalRadius<=0)
            horizontalRadius=1;
        if(radius<=0)
            radius=1;
        newPosition.x=getPosition().x+dfx;
        newPosition.y=getPosition().y-dfy;
        }
        if(edgeNumber==3)
        {
            radius=radius-dfy;
            horizontalRadius=horizontalRadius+dfx;
            if(horizontalRadius<=0)
             horizontalRadius=1;
            if(radius<=0)
             radius=1;
            newPosition.x=getPosition().x-dfx;
            newPosition.y=getPosition().y+dfy;
        }
        if(edgeNumber==4)
        {
        radius=radius-dfy;
        horizontalRadius=horizontalRadius-dfx;
        if(horizontalRadius<=0)
            horizontalRadius=1;
        if(radius<=0)
            radius=1;
        newPosition.x=getPosition().x+dfx;
        newPosition.y=getPosition().y+dfy;
        }
        setPosition(newPosition);        
    }

    @Override
    public Shape copy() {
        Circle c=new Circle(this.getPosition(),this.radius,this.horizontalRadius);
        c.setColor(this.getColor());
        c.setFillColor(this.getFillColor());
        return c;
    }
     @Override
    public JsonObject toJsonObject() {
        JsonObject jo=super.toJsonObject();
        jo.put("radius",radius);
        jo.put("horizontalRadius", horizontalRadius);
        return jo;
        }

    @Override
    public void fromJsonObject(JsonObject j) {
        super.fromJsonObject(j);
        radius=((BigDecimal)j.get("radius")).intValue();
        horizontalRadius=((BigDecimal)j.get("horizontalRadius")).intValue();
        
        }
    
    
}
