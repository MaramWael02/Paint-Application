/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.math.BigDecimal;

/**
 *
 * @author HP
 */
public abstract class SuperShape implements Shape,Moveable  {
    private Point position,draggingPoint;
    private Color color;
    private Color fillColor;
    private Color borderColor=Color.WHITE;
    int isSelected=0;
   //private Point resizePoint; // similar to dragging point
   int isEdge=0;  //  for mouse dragging and mouse released to either move or resize
   int edgeNumber=0;
   private String sc=new String();
    private String sfc=new String();
    private String sbc=Integer.toString(borderColor.getRGB());;
    private String type;
    public SuperShape(){}
    public SuperShape(Point position)
    {
        this.position=position;
          if(this instanceof Circle)
        {
            type="Circle";
        }
        else if(this instanceof Rectangle)
            type="Rectangle";
        else if(this instanceof Triangle)
            type="Triangle";
        else type="LineSegment";
  
  
    }
    @Override
    public void setPosition(Point position) {
        this.position=position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setColor(Color color) {
        this.color=color;
        this.sc= Integer.toString(color.getRGB());
    }

    @Override
    public Color getColor() {
        return color;
    }
    @Override
    public void setBorderColor(Color color) {
        borderColor=color;
        sbc=Integer.toString(color.getRGB());
    }

    /**
     *
     * @return
     */
    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    @Override
    public void setFillColor(Color color) {
        fillColor=color;
        sfc=Integer.toString(color.getRGB());
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
     abstract public void draw(Graphics canvas); 

    @Override
    public void setDraggedPoint(Point point) {
        draggingPoint=point;
    }

    @Override
    public Point getDraggedPoint() {
        return draggingPoint;
    }
    public JsonObject toJsonObject()
    {
        JsonObject jo= new JsonObject();
        //Color c=new Color(Color);
        
        if(color==null)
        {
            sc=Integer.toString(Color.BLACK.getRGB());
        }
        if(fillColor==null)
        {
            sfc=Integer.toString(Color.BLACK.getRGB());
        }
        jo.put("type", type);
        jo.put("borderColor", sbc);
        jo.put("color", sc);
        jo.put("fillcolor", sfc);
        jo.put("x-coordinates", position.x);
        jo.put("y-coordinates", position.y);
        return jo;
    }
    public void fromJsonObject(JsonObject j)
    {   type=(String)j.get("type");
        String sc1= (String)j.get("color");
        String sfc1= (String)j.get("fillcolor");
        String sbc1=(String)j.get("borderColor");
        System.out.println(sc1+" "+sfc1+" "+sbc1);
       
        if(sc1==null&&sfc1==null){
            this.color=Color.BLACK;
            this.fillColor=Color.BLACK;
        }
        else if(sfc1==null)
        {this.fillColor=Color.BLACK;
        this.color= new Color(Integer.parseInt(sc1));
        }
        else if(sc1==null)
        { this.color=Color.BLACK;
          this.fillColor= new Color(Integer.parseInt(sfc1));}
        else
        { this.color= new Color(Integer.parseInt(sc1));
        this.fillColor= new Color(Integer.parseInt(sfc1));}
        
        this.borderColor=new Color(Integer.parseInt(sbc1));
        int x= ((BigDecimal)j.get("x-coordinates")).intValue();
        int y= ((BigDecimal)j.get("y-coordinates")).intValue();
        if(position==null)
         position=new Point();
        position.x=x;
        position.y=y;
      
        
    }

    /**
     *
     * @param point
     * @return 
     */
    @Override
    abstract public boolean contains(Point point);

    @Override
    abstract public void moveTo(Point point);
         
    
}
