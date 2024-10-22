 

import java.awt.Color;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides an application window with a pen for drawing lines,
circles, and rectangles.
*/

public class Shapes {
   private Pen p;
   
   public Shapes(){
      this(200, 200);
   }
   
   public Shapes(int width, int height){
      SketchPad sp = new SketchPad();
      p = new StandardPen(sp);
      SketchPadWindow sw = new SketchPadWindow(width, height, sp);
   }
   
   public void setColor(Color color){
      p.setColor(color);
   }
   
   /** 
   Action: Draws a line segment.
   @param x1 The line segment's initial x coordinate
   @param y1 The line segment's initial y coordinate
   @param x2 The line segment's ending x coordinate
   @param y2 The line segment's ending y coordinate
   */   
   public void drawLine(double x1, double y1, double x2, double y2){
      p.up();
      p.move(x1, y1);
      p.down();
      p.move(x2, y2);
   }
   
   /** 
   Action: Draws a circle.
   @param x The x coordinate of the circle's center point
   @param y The y coordinate of the circle's center point
   @param r The circle's radius
   */   
   public void drawCircle(double x, double y, double r){
      double side = 2.0 * Math.PI * r / 120.0;
      p.up();
      p.move(x + r, y - side / 2.0); 
      p.setDirection(90); 
      p.down();
      for (int i = 0; i < 120; i++){
         p.move(side); 
         p.turn(3);
      }
   }
   
   /** 
   Action: Draws a rectangle.
   @param x The x coordinate of the rectangle's upper left corner point
   @param y The y coordinate of the rectangle's upper left corner point
   @param w The rectangle's width
   @param h The rectangle's height
   */   
   public void drawRectangle(double x, double y, double w, double h){
      p.up();
      p.move(x, y);
      p.down();
      p.move(x + w, y);
      p.move(x + w, y + h);
      p.move(x, y + h);
      p.move(x, y);
   }
}
