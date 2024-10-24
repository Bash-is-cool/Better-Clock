

import java.awt.*;
import java.util.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides behavior for a pen with wiggles and random colors (combines the
behavior of WigglePen and RainbowPen).
*/

public class WiggleRainbowPen extends WigglePen {

   private Random random = new Random();
   
   public WiggleRainbowPen(){
      super();
   }

   public WiggleRainbowPen(SketchPad pad, int wiggles, double wiggleAngle){
     super(pad, wiggles, wiggleAngle);
   }

   public void drawString(String str){
      setColor(new Color (random.nextInt (256), 
                          random.nextInt (256), 
                          random.nextInt (256)));
      super.drawString(str);
   }

   public WiggleRainbowPen(SketchPadWindow w){
      this(new SketchPad(), 5, 30);
      Container c = w.getContentPane();
      c.add(pad);
      w.setVisible(true);
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
