 package net.blueaxealotle.clock;

import java.awt.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
*/
abstract public class Command {

   abstract public void doCommand(Graphics2D g, int width, int height);

// Protected methods -------------------------------

   protected double adjustX(double x, int width){
      return (x + width /2.0);

   }
   
   protected double adjustY(double y, int height){
      return (height / 2.0 - y);
   }
   
   protected int round (double x) {
      if (x >= 0.0)
         return (int)(0.5 + x);
      else
         return -(int)(0.5 - x);
   }
   
   
}
