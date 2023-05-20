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
public class LineSegment extends SuperShape{

    private Point position2;
    public LineSegment(){}
    public LineSegment(Point point1,Point point2){
        super(point1);
        position2=point2;
    }
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawLine((int)getPosition().x, (int)getPosition().y, (int)position2.x, (int)position2.y);
        if(isSelected==1){
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5, this.getPosition().y-5, 10, 10);
        canvas.drawRect(position2.x-5, position2.y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(position2.x-5, position2.y-5, 10, 10);
        }
    }

    @Override
    public boolean contains(Point point) {
        double dx1,dx2,dy1,dy2,dx3,dy3,d1,d2,d3;
        dx1=Math.abs(point.x-getPosition().x);
        dx2=Math.abs(point.x-position2.x);
        dy1=Math.abs(point.y-getPosition().y);
        dy2=Math.abs(point.y-position2.y);
        dx3=Math.abs(getPosition().x-position2.x);
        dy3=Math.abs(getPosition().y-position2.y);
        d1=Math.sqrt(Math.pow(dx1,2)+Math.pow(dy1,2));
        d2=Math.sqrt(Math.pow(dx2,2)+Math.pow(dy2,2));
        d3=Math.sqrt(Math.pow(dx3,2)+Math.pow(dy3,2));
        return (d1+d2)==d3;
        
    }

    @Override
    public void moveTo(Point point) {
        Point newPosition=new Point();
        Point nPoint2=new Point();
        int dfx=getDraggedPoint().x-point.x;
        int dfy=getDraggedPoint().y-point.y;
        newPosition.x=getPosition().x-dfx;
        newPosition.y=getPosition().y-dfy;
        setPosition(newPosition);
        nPoint2.x=position2.x-dfx;
        nPoint2.y=position2.y-dfy;
        position2=nPoint2;

    }

    @Override
    public Shape copy() {
        LineSegment l=new LineSegment(this.getPosition(),position2);
        l.setColor(this.getColor());
        return l;
    }

    @Override
    public boolean isInsideBorder(Point point) {
        Square s=new Square(new Point(this.getPosition().x-5, this.getPosition().y-5),10);
        if(s.contains(point))
        {
            edgeNumber=1;
            return true;
        }
        s=new Square(new Point(position2.x-5,position2.y-5),10);
        if(s.contains(point))
        {
            edgeNumber=2;
            return true;
        }
        return false;
    }

    @Override
    public void resize(Point point) {
        Point newPosition=new Point();
        Point nPoint2=new Point();
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
        nPoint2.x=position2.x-dfx;
        nPoint2.y=position2.y-dfy;
        position2=nPoint2; 
        }
    }
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo=super.toJsonObject();
        jo.put("x-coordinate 2", position2.x);
        jo.put("y-coordinate 2", position2.y);
        return jo;   
    }

    @Override
    public void fromJsonObject(JsonObject j) {
        super.fromJsonObject(j);
        if(position2==null)
         position2=new Point();
        position2.x=((BigDecimal)j.get("x-coordinate 2")).intValue();
        position2.y=((BigDecimal)j.get("y-coordinate 2")).intValue();
    }
    
    
}
