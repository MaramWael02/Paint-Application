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
public class Triangle extends SuperShape {
    private Point point2,point3;
    
    public Triangle(){}
    public Triangle(Point point1,Point point2,Point point3){
        super(point1);
        this.point2=point2;
        this.point3=point3;
    }
    @Override
    public void draw(Graphics canvas) {
   
        int []x={getPosition().x,point2.x,point3.x};
        int []y={getPosition().y,point2.y,point3.y};
        if(isSelected==1){
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(point2.x-5, point2.y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(point2.x-5, point2.y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(point3.x-5, point3.y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(point3.x-5, point3.y-5, 10, 10);
        }
        canvas.setColor(getColor());
        canvas.drawPolygon(x, y, 3);
        canvas.setColor(getFillColor());
        canvas.fillPolygon(x, y, 3);
        
        
    }

    double area(int x1, int y1, int x2, int y2,int x3, int y3)
    {
       return Math.abs((x1*(y2-y3) + x2*(y3-y1)+x3*(y1-y2))/2.0);
    }
    @Override
    public boolean contains(Point point) {
        
       
        double A = area (getPosition().x, getPosition().y, point2.x, point2.y, point3.x,point3.y);
      
        
        double A1 = area (point.x, point.y, point2.x,point2.y ,point3.x ,point3.y );
      
        
        double A2 = area (getPosition().x, getPosition().y,point.x, point.y, point3.x, point3.y);
      
         
        double A3 = area (getPosition().x, getPosition().y, point2.x, point2.y, point.x, point.y);
        
       
        return (A == A1 + A2 + A3);
        }

    @Override
    public void moveTo(Point point) {
        Point newPosition=new Point();
        Point nPoint2=new Point();
        Point nPoint3=new Point();
        int dfx=getDraggedPoint().x-point.x;
        int dfy=getDraggedPoint().y-point.y;
        newPosition.x=getPosition().x-dfx;
        newPosition.y=getPosition().y-dfy;
        setPosition(newPosition);
        nPoint2.x=point2.x-dfx;
        nPoint2.y=point2.y-dfy;
        point2=nPoint2;
        nPoint3.x=point3.x-dfx;
        nPoint3.y=point3.y-dfy;
        point3=nPoint3;
        
    }

    @Override
    public Shape copy() {
        Triangle t=new Triangle(this.getPosition(),point2,point3);
        t.setColor(this.getColor());
        t.setFillColor(this.getFillColor());
        return t;
    }

    @Override
    public boolean isInsideBorder(Point point) {
        Square s=new Square(new Point(this.getPosition().x-5, this.getPosition().y-5),10);
        if(s.contains(point))
        {
            edgeNumber=1;
            return true;
        }
        s.setPosition(new Point(point2.x-5, point2.y-5));
        if(s.contains(point))        {
            edgeNumber=2;
            return true;
        }
        s.setPosition(new Point(point3.x-5,point3.y-5));
        if(s.contains(point))
        {
            edgeNumber=3;
            return true;
        }
return false;
    }

    @Override
    public void resize(Point point) {
        Point newPosition=new Point();
        Point nPoint2=new Point();
        Point nPoint3=new Point();
        int dfx=getDraggedPoint().x-point.x;
        int dfy=getDraggedPoint().y-point.y;
        if(edgeNumber==1)
        {
        newPosition.x=getPosition().x-dfx;
        newPosition.y=getPosition().y-dfy;
        setPosition(newPosition);
        }
        if(edgeNumber==2)
        {
        nPoint2.x=point2.x-dfx;
        nPoint2.y=point2.y-dfy;
        point2=nPoint2; 
        }
        if(edgeNumber==3)
        {
        nPoint3.x=point3.x-dfx;
        nPoint3.y=point3.y-dfy;
        point3=nPoint3;  
        }
    }
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo=super.toJsonObject();
        jo.put("x-coordinate 2", point2.x);
        jo.put("y-coordinate 2", point2.y);
        jo.put("x-coordinate 3", point3.x);
        jo.put("y-coordinate 3", point3.y);
        return jo;  
        }

    @Override
    public void fromJsonObject(JsonObject j) {
        super.fromJsonObject(j);
        if(point2==null)
         point2=new Point();
        if(point3==null)
         point3=new Point();
        
        point2.x=((BigDecimal)j.get("x-coordinate 2")).intValue();
        point2.y=((BigDecimal)j.get("y-coordinate 2")).intValue();
        point3.x=((BigDecimal)j.get("x-coordinate 3")).intValue();
        point3.y=((BigDecimal)j.get("y-coordinate 3")).intValue();       
        }
    
}
