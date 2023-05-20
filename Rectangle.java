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
public class Rectangle extends SuperShape {
    private int width, length;
    int dfx=0,dfy=0;
    
    public Rectangle(){}
    public Rectangle(Point point,int width,int length){
    super(point);
    this.width=width;
    this.length=length;
    }
    @Override
    public void draw(Graphics canvas) {
        if(isSelected==1){
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5+width, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5+width, this.getPosition().y-5, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5,this.getPosition().y-5+length, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5, this.getPosition().y-5+length, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.drawRect(this.getPosition().x-5+width, this.getPosition().y-5+length, 10, 10);
        canvas.setColor(this.getBorderColor());
        canvas.fillRect(this.getPosition().x-5+width, this.getPosition().y-5+length, 10, 10);
        }
        canvas.setColor(getColor());
        canvas.drawRect(getPosition().x,getPosition().y, width, length);
        canvas.setColor(getFillColor());
        canvas.fillRect(getPosition().x,getPosition().y, width, length);
    }

    /**
     *
     * @param point
     * @return
     */
    @Override
    public boolean contains(Point point) {
        return (int)point.x<=(int)getPosition().x+width &&(int)point.x>=(int)getPosition().x&& point.y<=getPosition().y+length&&point.y>=getPosition().y;   
    }
    @Override
    public void moveTo(Point point) { 
        dfx=getDraggedPoint().x-point.x;
        dfy=getDraggedPoint().y-point.y;
        Point newPosition=new Point();
        newPosition.x=getPosition().x-dfx;
        newPosition.y=getPosition().y-dfy;
        setPosition(newPosition);
    }

    @Override
    public Shape copy() {
        Rectangle r=new Rectangle(this.getPosition(),width,length);
        r.setColor(this.getColor());
        r.setFillColor(this.getFillColor());
        return r;
    }

    @Override
    public boolean isInsideBorder(Point point) {
        Square s=new Square(new Point(this.getPosition().x-5, this.getPosition().y-5),10);
        if(s.contains(point))
        {
            edgeNumber=1;
            return true;
        }
        s.setPosition(new Point(this.getPosition().x-5+width, this.getPosition().y-5));
        if(s.contains(point))
        {
            edgeNumber=2;
            return true;
        }
        s.setPosition(new Point(this.getPosition().x-5, this.getPosition().y-5+length));
        if(s.contains(point))
        {
            edgeNumber=3;
            return true;
        }
        s.setPosition(new Point(this.getPosition().x-5+width, this.getPosition().y-5+length));  
        if(s.contains(point))
        {
            edgeNumber=4;
            return true;
        }
        return false;
        
    }

    @Override
    public void resize(Point point) {
        dfx=getDraggedPoint().x-point.x;
        dfy=getDraggedPoint().y-point.y;
        Point newPosition=new Point();
        if(edgeNumber==1){
        length=length+dfy;
        width=width+dfx;
        if(length<=0)
        {
            length=1;
        }
        if(width<=0)
        {
            width=1;
        }
        newPosition.x=getPosition().x-dfx;
        newPosition.y=getPosition().y-dfy;
        setPosition(newPosition);
        }
        if(edgeNumber==2){
        length=length+dfy;
        width=width-dfx;
        if(length<=0)
        {
            length=1;
        }
        if(width<=0)
        {
            width=1;
        }
        newPosition.x=getPosition().x;
        newPosition.y=getPosition().y-dfy;
        setPosition(newPosition);
        }
        if(edgeNumber==3)
        {
            length=length-dfy;
            width=width+dfx;
            if(length<=0)
        {
            length=1;
        }
        if(width<=0)
        {
            width=1;
        }
            newPosition.x=getPosition().x-dfx;
            newPosition.y=getPosition().y;
            setPosition(newPosition);
        }
        if(edgeNumber==4)
        {
            length=length-dfy;
            width=width-dfx;
            if(length<=0)
        {
            length=1;
        }
        if(width<=0)
        {
            width=1;
        }
            newPosition.x=getPosition().x;
            newPosition.y=getPosition().y;
            setPosition(newPosition);
        }     
    }
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo=super.toJsonObject();
        jo.put("length",length);
        jo.put("width", width);
    return jo;
    }

    @Override
    public void fromJsonObject(JsonObject j) {
        super.fromJsonObject(j);
        length=((BigDecimal)j.get("length")).intValue();
        width= ((BigDecimal)j.get("width")).intValue();
        }
    
}
