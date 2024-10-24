 package net.blueaxealotle.clock;

import java.awt.*;
import java.util.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides behavior and state for a pen with wiggles.  The shape of the
wiggles depends on a constant rate of wiggling and a wiggle angle.  The
default wiggle rate is 5 and the default wiggle angle is 30 degrees.
The client can specify these values with a constructor. 
*/

public class WigglePen extends StandardPen {

   private int numWiggles = 5;
   private double wiggleAngle = 30;
   
   /** 
   Action: Pops up an application window containing a sketchpad 
   and an associated wiggle pen with a wiggle rate of 5 and a 
   wiggle angle of 30 degrees.
   */   
   public WigglePen(){
      super();
   }

   /** 
   Action: Associates a wiggle pen with the client's sketchpad
   using the client's wiggle rate and wiggle angle. 
   @param pad The client's sketchpad
   @param w The number of wiggles or wiggle rate
   @param wa The wiggle angle in degrees
   */   
   public WigglePen(SketchPad pad, int w, double wa){
     super(pad);
     numWiggles = w;
     wiggleAngle = wa;
   }

   /**   
   Action: Pops up the client's application window containing a sketchpad 
   and an associated wiggle pen.
   */   
   public WigglePen(SketchPadWindow w){
      this(new SketchPad(), 5, 30);
      Container c = w.getContentPane();
      c.add(pad);
      w.setVisible(true);
   }

   public void move(double distance){
      int i;
      double sizeOfMove;
      double halfAngle = wiggleAngle / 2.0;
      sizeOfMove = distance / 
                   (numWiggles * 2.0 * Math.cos (Math.PI * halfAngle / 180.0));
      turn(halfAngle);
      for (i = 1; i <= numWiggles; i++){
         turn(-wiggleAngle); super.move(sizeOfMove);
         turn(+wiggleAngle); super.move(sizeOfMove);
      }
      turn(-halfAngle);
   }
   
   public void move(double x, double y){
      double deltaX = x - xPos;
      double deltaY = y - yPos;
      double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY); 
      turn (x, y);
      move(distance);
   }
}   
