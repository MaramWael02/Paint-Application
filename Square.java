/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author HP
 */
public class Square extends SuperShape{

    private int side;
    public Square(Point point,int side)
    {
        super(point);
        this.side=side;
    }
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawRect((int)getPosition().x,(int)getPosition().y, side, side);
        canvas.setColor(getFillColor());
        canvas.fillRect((int)getPosition().x,(int)getPosition().y, side, side);
    }

    @Override
    public boolean contains(Point point) {
        return (int)point.x<=(int)getPosition().x+side && (int)point.x>=(int)getPosition().x &&(int)point.y>=(int)getPosition().y && point.y<=getPosition().y+side;
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
    public Shape copy() {
        Square s=new Square(this.getPosition(),side);
        s.setColor(getColor());
        s.setFillColor(this.getFillColor());
        return s;
    }

    @Override
    public boolean isInsideBorder(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void resize(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
