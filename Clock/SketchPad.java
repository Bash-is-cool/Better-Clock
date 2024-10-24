 package net.blueaxealotle.clock;

import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
The panel associated with a pen.  The initial background color is white.
The client can modify the sketchpad's background color by using setBackground(aColor).
*/

public class SketchPad extends JPanel {

   private java.util.List commands;

// Constructors ----------------------------------

   public SketchPad(){
      commands = new java.util.LinkedList();
      setBackground (Color.white);
   }

// Public methods --------------------------------

   public void paintComponent(Graphics gg){
      super.paintComponent(gg);
      Iterator iter = commands.iterator();
      while (iter.hasNext()){
         Command command = (Command) iter.next();
         command.doCommand((Graphics2D)gg, getWidth(), getHeight());
      }
   } 

   public void setColor(Color color){
      commands.add(new CommandSetColor(color));
   }

   public void setPenWidth(int width){
      commands.add(new CommandSetPenWidth(width));
   }

   public void drawLine( double x1, double x2, double x3, double x4, Color color, int width){
      commands.add(new CommandDrawLine(x1, x2, x3, x4));
      repaint();
   }
   
   public void drawString(String str, double x1, double x2, Color color){
      commands.add(new CommandDrawString(str, x1, x2));
      repaint();
   }
}  
      

