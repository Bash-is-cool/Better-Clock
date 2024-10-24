 package net.blueaxealotle.clock;

import java.awt.*;
import java.util.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides behavior and state for a pen with randomly generated colors.  A new random color is chosen for the pen each time it is moved or draws a string.
*/

public class RainbowPen extends StandardPen {

   private Random random = new Random();
   
   public RainbowPen(){
      super();
   }

   public RainbowPen(SketchPad pad){
     super(pad);
   }

   public RainbowPen(SketchPadWindow w){
      this(new SketchPad());
      Container c = w.getContentPane();
      c.add(pad);
      w.setVisible(true);
   }

   public void drawString (String str){
      setColor(new Color (random.nextInt (256), 
                          random.nextInt (256), 
                          random.nextInt (256)));
      super.drawString(str);
   }
      
   public void move(double distance){
      setColor(new Color (random.nextInt (256), 
                          random.nextInt (256), 
                          random.nextInt (256)));
      super.move(distance);
   }
   
   public void move(double x, double y){
      setColor(new Color (random.nextInt (256), 
                          random.nextInt (256), 
                          random.nextInt (256)));
      super.move(x, y);
   }
}   
